package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "client")
class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private val id: UUID,

    @NotNull
    @Column(name = "created_date", nullable = false)
    private var createdDate: LocalDateTime = LocalDateTime.now(),

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    private var person: Person,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "client", fetch = FetchType.LAZY)
    private var tickets: MutableList<Ticket> = mutableListOf()
) {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Client) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}