package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "user")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private val id: UUID? = null

    @Column(name = "created_date", nullable = false)
    private var createdDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "active", nullable = false)
    private var active: Boolean = false

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false)
    private var person: Person = Person()

    fun getId(): UUID? = this.id

    fun getCreatedDate(): LocalDateTime = this.createdDate
    fun setCreatedDate(createdDate: LocalDateTime) {
        this.createdDate = createdDate
    }

    fun getActive(): Boolean = this.active
    fun setActive(active: Boolean) {
        this.active = active
    }

    fun getPerson(): Person = this.person
    fun setPerson(person: Person) {
        this.person = person
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }


}