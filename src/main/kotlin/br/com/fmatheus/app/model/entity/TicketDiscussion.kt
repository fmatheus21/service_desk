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

    fun getId(): UUID? = this.id

    fun getCreatedDate(): LocalDateTime = this.createdDate
    fun setCreatedDate(createdDate: LocalDateTime) {
        this.createdDate = createdDate
    }

    fun getDiscussion(): String = this.discussion
    fun setDiscussion(discussion: String) {
        this.discussion = discussion
    }

    fun getTicket(): Ticket = this.ticket
    fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TicketDiscussion) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }


}