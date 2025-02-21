package br.com.fmatheus.app.controller.resource

import br.com.fmatheus.app.controller.dto.request.TicketRequest
import br.com.fmatheus.app.controller.facade.TicketFacade
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.reflect.full.memberProperties

@RestController
@RequestMapping("/tickets")
class TicketResource(private val facade: TicketFacade) {

    @GetMapping
    fun helloWorld(): String {
        val ticket = TicketRequest::class.memberProperties
        for (prop in ticket) {
            prop.name
        }
        return "Hello World"
    }
}