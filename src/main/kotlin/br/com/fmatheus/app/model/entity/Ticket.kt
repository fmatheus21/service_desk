package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*


@Entity
@Table(name = "ticket")
class Ticket(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    val id: UUID?,

    @NotBlank
    @Column(name = "title", nullable = false, length = 100)
    var title: String,

    @NotBlank
    @Column(name = "problem_description", nullable = false, columnDefinition = "MEDIUMTEXT")
    var problemDescription: String,

    @NotNull
    @Column(name = "created_date", nullable = false)
    var createdDate: LocalDateTime,

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    var client: Client,

    @ManyToOne
    @JoinColumn(name = "id_ticket_status", referencedColumnName = "id", nullable = false)
    var ticketStatus: TicketStatus,

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    var owner: User?,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "ticket", orphanRemoval = true, fetch = FetchType.LAZY)
    var ticketDiscussions: MutableList<TicketDiscussion>?

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Ticket) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}