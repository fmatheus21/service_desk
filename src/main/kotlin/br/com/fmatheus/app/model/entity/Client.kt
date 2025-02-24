package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "client")
class Client(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: UUID?,

    @NotNull
    @Column(name = "created_date", nullable = false)
    var createdDate: LocalDateTime,

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false)
    var person: Person,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "client", fetch = FetchType.LAZY)
    var tickets: MutableList<Ticket>

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Client) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}