package br.com.fmatheus.app.config.security

import br.com.fmatheus.app.config.properties.CorsProperties
import br.com.fmatheus.app.controller.util.logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.csrf.CsrfTokenRepository
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
class SecurityConfig(
    private val corsProperties: CorsProperties,
    private val csrfTokenRepository: CsrfTokenRepository
) {

    private val logger = logger()
    private val URL_TICKET = "/tickets"

    companion object {
        private val AUTH_WHITELIST = arrayOf(
            "/swagger-ui.html",
            "/v3/api-docs/**",
            "/actuator/*",
            "/swagger-ui/**"
        )
        private val TICKET_READ = arrayOf(
            "service_desk/ticket_read",
            "service_desk/all_authorize",
            "client_credentials"
        )
        private val TICKET_CREATE = arrayOf(
            "service_desk/ticket_create",
            "service_desk/all_authorize"
        )
    }

    /**
     * O método securityFilterChain é anotado com @Bean, o que significa que ele será gerado como um bean no contexto do Spring. Esse bean será usado para configurar a segurança na aplicação.
     * Ele recebe um objeto HttpSecurity como parâmetro, que é usado para configurar as regras de segurança da aplicação.
     */
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        logger.info("Iniciando Filter Chain")
        return http
            .csrf { csrf -> csrf.csrfTokenRepository(this.csrfTokenRepository) }  //Habilita a proteção contra CSRF (Cross-Site Request Forgery), o que pode ser necessário em APIs REST sem sessões de usuário.
            .cors { it.configurationSource(corsConfigurationSource()) }  //Configura o CORS (Cross-Origin Resource Sharing) utilizando o método corsConfigurationSource(), que define as regras de compartilhamento de recursos entre origens.
            .authorizeHttpRequests {  //Configura a autorização de requisições HTTP:
                it.requestMatchers(*AUTH_WHITELIST).permitAll()  //Permite o acesso irrestrito às URLs definidas na constante AUTH_WHITELIST (ex: Swagger, Actuator).
                    .requestMatchers(HttpMethod.GET, URL_TICKET).hasAnyAuthority(*TICKET_READ)  //Permite requisições somente quem tiver este authority
                    .requestMatchers(HttpMethod.POST, URL_TICKET).hasAnyAuthority(*TICKET_CREATE)
                    .anyRequest().denyAll()  //Nega qualquer outra requisição.
            }
            .oauth2ResourceServer { oauth ->  //Configura o recurso de autenticação com OAuth2 usando JWT:
                oauth.jwt { jwt ->
                    jwt.jwtAuthenticationConverter(CustomJwtAuthenticationConverter())  //Especifica que o servidor de recursos usará JWT para autenticação e usa o CustomJwtAuthenticationConverter para converter o token JWT em um AuthenticationToken.
                }
            }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }    //Configura a política de criação de sessão para STATELESS, o que significa que o servidor não armazenará estado de sessão (ideal para APIs RESTful).
            .build()
    }

    /**
     * Cria e retorna um CorsConfigurationSource, que define as configurações CORS para a aplicação.
     * allowedHeaders: define os cabeçalhos permitidos nas requisições (ex: Authorization, Cache-Control, etc.).
     * allowedOrigins: define as origens permitidas para acessar a API (ex: http://localhost:4200).
     * allowedMethods: define os métodos HTTP permitidos (ex: POST, GET, PUT, etc.).
     * allowCredentials: permite que cookies e credenciais sejam enviados com as requisições.
     * exposedHeaders: define os cabeçalhos que podem ser acessados pelo cliente (ex: Authorization).
     */
    private fun corsConfigurationSource(): CorsConfigurationSource {
        val config = CorsConfiguration().apply {
            allowedHeaders = listOf("Authorization", "Cache-Control", "Content-Type")
            allowedOrigins = corsProperties.allowedOrigins
            allowedMethods = listOf("POST", "GET", "PUT", "PATCH", "DELETE", "HEAD", "OPTIONS")
            allowCredentials = true
            exposedHeaders = listOf("Authorization")
        }

        return UrlBasedCorsConfigurationSource().apply {
            registerCorsConfiguration("/**", config)
        }
    }

}