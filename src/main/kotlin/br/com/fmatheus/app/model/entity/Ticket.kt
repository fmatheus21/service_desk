package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime
import java.util.*


@Entity
@Table(name = "ticket")
class Ticket(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private val id: UUID? = null,

    @NotBlank
    @Column(name = "title", nullable = false, length = 100)
    private var title: String,

    @NotBlank
    @Column(name = "problem_description", nullable = false, columnDefinition = "MEDIUMTEXT")
    private var problemDescription: String,

    @NotNull
    @Column(name = "created_date", nullable = false)
    private var createdDate: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    private var client: Client,

    @ManyToOne
    @JoinColumn(name = "id_ticket_status", referencedColumnName = "id", nullable = false)
    private var ticketStatus: TicketStatus,

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = true)
    private var owner: User? = null,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "ticket", orphanRemoval = true, fetch = FetchType.LAZY)
    private var ticketDiscussions: MutableList<TicketDiscussion> = mutableListOf()
) {

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