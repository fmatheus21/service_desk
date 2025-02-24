package br.com.fmatheus.app.controller.resource

import br.com.fmatheus.app.controller.dto.request.TicketRequest
import br.com.fmatheus.app.controller.dto.response.TicketResponse
import br.com.fmatheus.app.controller.facade.TicketFacade
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@RequestBody @Valid request: TicketRequest): TicketResponse {
        return this.facade.create(request)
    }
}