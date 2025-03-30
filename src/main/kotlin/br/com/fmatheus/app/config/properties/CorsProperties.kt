package br.com.fmatheus.app.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "cors")
class CorsProperties {
    var allowedOrigins: List<String> = listOf()
}