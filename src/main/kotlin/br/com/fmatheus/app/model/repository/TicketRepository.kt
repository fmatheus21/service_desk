package br.com.fmatheus.app.model.repository

import br.com.fmatheus.app.model.entity.Ticket
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TicketRepository : JpaRepository<Ticket, UUID> {
}