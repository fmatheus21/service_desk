package br.com.fmatheus.app.model.service.impl

import br.com.fmatheus.app.model.entity.TicketStatus
import br.com.fmatheus.app.model.repository.TicketStatusRepository
import br.com.fmatheus.app.model.service.TicketStatusService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.*

@Service
class TicketStatusServiceImpl(private val repository: TicketStatusRepository) : TicketStatusService {

    companion object {
        const val CACHE_NAME = "ticketStatus"
    }

    @Cacheable(CACHE_NAME)
    override fun findAll(): Collection<TicketStatus> {
        return this.repository.findAll()
    }

    @Cacheable(CACHE_NAME)
    override fun findById(id: Int): Optional<TicketStatus> {
        return this.repository.findById(id)
    }

    @CacheEvict(value = [CACHE_NAME], allEntries = true)    // Se este método for chamado, o cache será invalidado.
    override fun save(t: TicketStatus): TicketStatus {
        return this.repository.save(t)
    }


    @CacheEvict(value = [CACHE_NAME], allEntries = true)    // Se este método for chamado, o cache será invalidado.
    override fun deleteById(id: Int) {
        this.repository.deleteById(id)
    }
}