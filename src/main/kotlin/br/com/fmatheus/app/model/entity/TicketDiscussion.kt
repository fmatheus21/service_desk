package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "ticket_discussion")
class TicketDiscussion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private val id: UUID? = null

    @Column(name = "created_date", nullable = false)
    private var createdDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "discussion", nullable = false, columnDefinition = "MEDIUMTEXT")
    private var discussion: String = ""

    @ManyToOne
    @JoinColumn(name = "id_ticket", referencedColumnName = "id", nullable = false)
    private var ticket: Ticket = Ticket()
}