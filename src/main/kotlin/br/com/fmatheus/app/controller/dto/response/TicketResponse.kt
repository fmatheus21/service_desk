package br.com.fmatheus.app.controller.dto.response

import java.util.*

data class TicketResponse(
    var title: String,
    var problemDescription: String,
    var ticketStatus: TicketStatusResponse,
    var client: ClientResponse
) {
    data class TicketStatusResponse(
        var name: String
    ) {}

    data class ClientResponse(
        var id: UUID,
        var person: PersonResponse
    ) {
        data class PersonResponse(
            var name: String,
            var contact: ContactResponse
        ) {
            data class ContactResponse(
                var phone: String,
                var email: String
            ) {}
        }
    }
}