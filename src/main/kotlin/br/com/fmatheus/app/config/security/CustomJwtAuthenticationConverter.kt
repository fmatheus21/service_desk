package br.com.fmatheus.app.config.security

import br.com.fmatheus.app.controller.util.logger
import org.springframework.core.convert.converter.Converter
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter

//Converter um JWT em um objeto de autenticação do Spring Security.
class CustomJwtAuthenticationConverter : Converter<Jwt, AbstractAuthenticationToken> {

    private val logger = logger()
    private val jwtGrantedAuthoritiesConverter = JwtGrantedAuthoritiesConverter()   //Instancia JwtGrantedAuthoritiesConverter, responsável por extrair permissões (authorities) padrão de um JWT.

    private fun extractResourceRoles(jwt: Jwt): Collection<GrantedAuthority> {

        return if (jwt.claims["sub"].toString().equals(AuthorizationGrantType.CLIENT_CREDENTIALS.value, ignoreCase = true)) {   //Verifica se o sub do JWT é igual a client_credentials (usado para autenticação de aplicações, não de usuários).
            setOf(SimpleGrantedAuthority(AuthorizationGrantType.CLIENT_CREDENTIALS.value))  //Se for client_credentials, retorna um conjunto com uma única permissão client_credentials.
        } else {
            val authorities = jwt.getClaimAsStringList("authorities") ?: emptyList()    //Caso contrário, obtém a lista de permissões (authorities) do JWT. Se não existir, retorna uma lista vazia.
            logger.info("Extraindo funções de recursos: {}", authorities)
            authorities.map { SimpleGrantedAuthority(it) }.toSet()  //Converte cada string da lista de authorities em um SimpleGrantedAuthority e retorna um Set.
        }
    }

    /**
     * Implementa o método convert da interface Converter. Ele recebe um JWT (source) e retorna um AbstractAuthenticationToken.
     */
    override fun convert(source: Jwt): AbstractAuthenticationToken {
        logger.info("Convertendo token")
        //Obtém as permissões padrões do JWT (jwtGrantedAuthoritiesConverter.convert(source)) e adiciona as funções extraídas pelo método extractResourceRoles.
        val authorities = (this.jwtGrantedAuthoritiesConverter.convert(source).orEmpty() + extractResourceRoles(source)).toList()
        return JwtAuthenticationToken(source, authorities)
    }
}