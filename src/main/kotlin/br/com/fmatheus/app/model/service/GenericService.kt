package br.com.fmatheus.app.model.service

import java.util.Optional

interface GenericService<T, ID> {
    fun findAll(): Collection<T>?

    fun findById(id: ID): Optional<T>?

    fun save(t: T): T

    fun deleteById(id: ID)
}