package br.com.fmatheus.app.controller.dto.request

data class TicketRequest(
    var title: String,
    var problemDescription: String,
    var client: ClientRequest
) {
    data class ClientRequest(var id: Int) {}

}