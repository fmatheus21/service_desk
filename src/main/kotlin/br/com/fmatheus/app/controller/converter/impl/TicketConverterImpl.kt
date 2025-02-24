package br.com.fmatheus.app.controller.converter.impl

import br.com.fmatheus.app.controller.converter.TicketConverter
import br.com.fmatheus.app.controller.dto.request.TicketRequest
import br.com.fmatheus.app.controller.dto.response.TicketResponse
import br.com.fmatheus.app.model.entity.Client
import br.com.fmatheus.app.model.entity.Ticket
import br.com.fmatheus.app.model.entity.TicketStatus
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TicketConverterImpl : TicketConverter {
    override fun converterToEntity(s: TicketRequest): Ticket {

        val ticket = Ticket(
            id = null,
            title = s.title,
            problemDescription = s.problemDescription,
            createdDate = LocalDateTime.now(),
            client = Client(s.client.id),
            ticketStatus = TicketStatus(1),
            owner = null,
            ticketDiscussions = arrayListOf()
        )

        return ticket

    }

    override fun converterToResponse(t: Ticket): TicketResponse {

        val person = t.client.person
        val client = person.client
        val contact = person.contact

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