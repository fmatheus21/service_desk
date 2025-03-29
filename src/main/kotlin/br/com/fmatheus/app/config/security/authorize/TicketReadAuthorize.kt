package br.com.fmatheus.app.config.security.authorize

import org.springframework.security.access.prepost.PreAuthorize

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@PreAuthorize("hasAnyAuthority('service_desk/all_authorize', 'service_desk/ticket_read', 'client_credentials')")
annotation class TicketReadAuthorize()
