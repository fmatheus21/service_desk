package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private val id: UUID,

    @NotNull
    @Column(name = "created_date", nullable = false)
    private var createdDate: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @Column(name = "active", nullable = false)
    private var active: Boolean,

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false)
    private var person: Person
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}