package br.com.fmatheus.app.config

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.modelmapper.convention.NameTokenizers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.csrf.CsrfTokenRepository


@Configuration
class BeanConfig {

    @Bean
    fun mapper(): ModelMapper {
        val mapper = ModelMapper()
        mapper
            .configuration
            .setMatchingStrategy(MatchingStrategies.STRICT)
            .setUseOSGiClassLoaderBridging(true)
            .setPreferNestedProperties(false)
            .setSourceNameTokenizer(NameTokenizers.UNDERSCORE)
            .setDestinationNameTokenizer(NameTokenizers.UNDERSCORE)
        return mapper
    }

    @Bean
    fun csrfTokenRepository(): CsrfTokenRepository {
        return CookieCsrfTokenRepository.withHttpOnlyFalse()
    }
}