package br.com.fmatheus.app.controller.converter.impl

import br.com.fmatheus.app.controller.converter.TicketConverter
import br.com.fmatheus.app.controller.dto.request.TicketRequest
import br.com.fmatheus.app.controller.dto.response.TicketResponse
import br.com.fmatheus.app.model.entity.Ticket
import br.com.fmatheus.app.model.service.ClientService
import br.com.fmatheus.app.model.service.TicketStatusService
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TicketConverterImpl(
    private val clientService: ClientService,
    private val ticketStatusService: TicketStatusService
) : TicketConverter {
    override fun converterToEntity(s: TicketRequest): Ticket {

        val client = this.clientService.findById(s.client.id).orElseThrow { EntityNotFoundException("Cliente não encontrado") }
        val ticketStatus = this.ticketStatusService.findById(1).orElseThrow { EntityNotFoundException("Status não encontrado") }

        val ticket = Ticket(
            id = null,
            title = s.title,
            problemDescription = s.problemDescription,
            createdDate = LocalDateTime.now(),
            client = client,
            ticketStatus = ticketStatus,
            owner = null,
            ticketDiscussions = null
        )

        return ticket

    }

    override fun converterToResponse(t: Ticket): TicketResponse {

        val person = t.client.person
        val client = t.client
        val contact = t.client.person.contact

        return TicketResponse(
            title = t.title,
            problemDescription = t.problemDescription,
            ticketStatus = TicketResponse.TicketStatusResponse(
                t.ticketStatus.name
            ),
            client = TicketResponse.ClientResponse(
                id = client.id!!,
                person = TicketResponse.ClientResponse.PersonResponse(
                    person.name,
                    contact = TicketResponse.ClientResponse.PersonResponse.ContactResponse(
                        contact.phone,
                        contact.email
                    )
                )
            )
        )

    }
}