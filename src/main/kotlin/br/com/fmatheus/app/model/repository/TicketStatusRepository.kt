package br.com.fmatheus.app.model.repository

import br.com.fmatheus.app.model.entity.TicketStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TicketStatusRepository : JpaRepository<TicketStatus, Int> {
}