package br.com.fmatheus.app.model.service.impl

import br.com.fmatheus.app.model.entity.Client
import br.com.fmatheus.app.model.repository.ClientRepository
import br.com.fmatheus.app.model.service.ClientService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClientServiceImpl(private val repository: ClientRepository) : ClientService {

    override fun findAll(): Collection<Client>? {
        throw UnsupportedOperationException()
    }

    override fun findById(id: UUID): Optional<Client>? {
        return this.repository.findById(id)
    }

    override fun save(t: Client): Client {
        return this.repository.save(t)
    }

    override fun deleteById(id: UUID) {
        this.repository.deleteById(id)
    }
}