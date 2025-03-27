package br.com.fmatheus.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class KotlinApiRestApplication

fun main(args: Array<String>) {
    runApplication<KotlinApiRestApplication>(*args)
}
