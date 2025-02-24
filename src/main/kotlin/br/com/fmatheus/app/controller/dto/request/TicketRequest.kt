package br.com.fmatheus.app.controller.dto.request

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.*

class TicketRequest(
    @NotBlank
    @NotNull
    var title: String,
    @NotBlank
    var problemDescription: String,
    @Valid
    @NotNull
    var client: ClientRequest
) {
    class ClientRequest(
        @NotNull
        var id: UUID
    ) {}

}