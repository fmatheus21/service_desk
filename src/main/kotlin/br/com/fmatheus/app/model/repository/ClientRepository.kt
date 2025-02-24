package br.com.fmatheus.app.model.repository

import br.com.fmatheus.app.model.entity.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClientRepository : JpaRepository<Client, UUID> {
}