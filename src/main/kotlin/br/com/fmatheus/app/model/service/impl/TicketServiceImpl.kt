package br.com.fmatheus.app.model.service.impl

import br.com.fmatheus.app.model.entity.Ticket
import br.com.fmatheus.app.model.repository.TicketRepository
import br.com.fmatheus.app.model.service.TicketService
import org.springframework.stereotype.Service
import java.util.*


@Service
class TicketServiceImpl(private val repository: TicketRepository) : TicketService {


    override fun findAll(): Collection<Ticket>? {
        return this.repository.findAll()
    }

    override fun findById(id: UUID): Optional<Ticket>? {
        return this.repository.findById(id)
    }

    override fun save(t: Ticket): Ticket {
        return this.repository.save(t)
    }

    override fun deleteById(id: UUID) {
        this.repository.deleteById(id)
    }
}