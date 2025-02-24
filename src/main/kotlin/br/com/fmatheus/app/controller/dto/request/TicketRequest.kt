package br.com.fmatheus.app.controller.dto.request

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.UUID

data class TicketRequest(
    @NotBlank
    var title: String,
    @NotBlank
    var problemDescription: String,
    @Valid
    @NotNull
    var client: ClientRequest
) {
    data class ClientRequest(
        @NotNull
        var id: UUID
    ) {}

}