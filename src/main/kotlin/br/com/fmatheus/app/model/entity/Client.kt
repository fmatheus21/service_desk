package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "client")
class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private val id: Int? = null

    @Column(name = "created_date", nullable = false)
    private var createdDate: LocalDateTime = LocalDateTime.now()

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    private var person: Person = Person()

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "owner", fetch = FetchType.LAZY)
    private var tickets: List<Ticket> = ArrayList()

    fun getId(): Int? = this.id

    fun getCreatedDate(): LocalDateTime = this.createdDate
    fun setCreatedDate(createdDate: LocalDateTime) {
        this.createdDate = createdDate
    }

    fun getPerson(): Person = this.person
    fun setPerson(person: Person) {
        this.person = person
    }

    fun getTickets(): List<Ticket> = this.tickets
    fun setTickets(tickets: List<Ticket>) {
        this.tickets = tickets
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Client) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id ?: 0
    }


}