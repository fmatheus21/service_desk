package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "ticket_discussion")
class TicketDiscussion(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    val id: UUID?,

    @NotNull
    @Column(name = "created_date", nullable = false)
    var createdDate: LocalDateTime,

    @NotBlank
    @Column(name = "discussion", nullable = false, columnDefinition = "MEDIUMTEXT")
    var discussion: String,

    @ManyToOne
    @JoinColumn(name = "id_ticket", referencedColumnName = "id", nullable = false)
    var ticket: Ticket
) {

    constructor(id: UUID?) : this(
        id = id,
        createdDate = LocalDateTime.now(),
        discussion = "",
        ticket = Ticket(null)
    )

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