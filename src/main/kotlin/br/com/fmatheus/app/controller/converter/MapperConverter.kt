package br.com.fmatheus.app.controller.converter


interface MapperConverter<T, S, U> {
    fun converterToEntity(s: S): T
    fun converterToResponse(t: T): U
}