package br.com.fmatheus.app.controller.facade

import br.com.fmatheus.app.controller.converter.TicketConverter
import br.com.fmatheus.app.controller.dto.request.TicketRequest
import br.com.fmatheus.app.controller.dto.response.TicketResponse
import br.com.fmatheus.app.model.service.TicketService
import org.springframework.stereotype.Component

@Component
data class TicketFacade(
    private val ticketService: TicketService,
    private val ticketConverter: TicketConverter
) {

    fun create(request: TicketRequest): TicketResponse {
        val ticket = this.ticketConverter.converterToEntity(request)
        val commit = this.ticketService.save(ticket)
        return ticketConverter.converterToResponse(commit)
    }
}