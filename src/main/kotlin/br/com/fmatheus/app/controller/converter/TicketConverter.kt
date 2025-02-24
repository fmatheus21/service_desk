package br.com.fmatheus.app.controller.converter

import br.com.fmatheus.app.controller.dto.request.TicketRequest
import br.com.fmatheus.app.controller.dto.response.TicketResponse
import br.com.fmatheus.app.model.entity.Ticket

interface TicketConverter : MapperConverter<Ticket, TicketRequest, TicketResponse> {
}