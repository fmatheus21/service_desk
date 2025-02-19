package br.com.fmatheus.app.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "ticket_status")
class TicketStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private val id: Int? = null

    @Column(name = "name", length = 20, nullable = false)
    private var name: String = ""

    fun getId(): Int? = this.id

    fun getName(): String = this.name
    fun setName(name: String) {
        this.name = name
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TicketStatus) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id ?: 0
    }


}