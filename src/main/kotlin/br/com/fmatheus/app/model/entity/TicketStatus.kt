package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.io.Serializable

@Entity
@Table(name = "ticket_status")
class TicketStatus(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int?,

    @NotBlank
    @Column(name = "name", length = 20, nullable = false)
    var name: String,
) : Serializable {

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