package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList


@Entity
@Table(name = "ticket")
class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private val id: UUID? = null

    @Column(name = "title", nullable = false, length = 100)
    private var title: String = ""

    @Column(name = "problem_description", nullable = false, columnDefinition = "MEDIUMTEXT")
    private var problemDescription: String = ""

    @Column(name = "created_date", nullable = false)
    private var createdDate: LocalDateTime = LocalDateTime.now()

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    private var client: Client = Client()

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = true)
    private var owner: User? = null

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "ticket", orphanRemoval = true, fetch = FetchType.LAZY)
    private var ticketDiscussions: List<TicketDiscussion> = ArrayList()


    fun getId(): UUID? = this.id

    fun getTitle(): String = this.title
    fun setTitle(title: String) {
        this.title = title
    }

    fun getProblemDescription(): String = this.problemDescription
    fun setProblemDescription(problemDescription: String) {
        this.problemDescription = problemDescription
    }

    fun getCreatedDate(): LocalDateTime = this.createdDate
    fun setCreatedDate(createdDate: LocalDateTime) {
        this.createdDate = createdDate
    }

    fun getClient(): Client = this.client
    fun setClient(client: Client) {
        this.client = client
    }

    fun getOwner(): User? = this.owner
    fun setOwner(owner: User) {
        this.owner = owner
    }

    fun getTicketDiscussions(): List<TicketDiscussion> = this.ticketDiscussions
    fun setTicketDiscussions(ticketDiscussion: List<TicketDiscussion>) {
        this.ticketDiscussions = ticketDiscussion
    }

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