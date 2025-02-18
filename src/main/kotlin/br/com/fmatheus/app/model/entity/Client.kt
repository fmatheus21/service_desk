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

    fun getId(): Int? = this.id

    fun getCreatedDate(): LocalDateTime = this.createdDate
    fun setCreatedDate(createdDate: LocalDateTime) {
        this.createdDate = createdDate
    }

    fun getPerson(): Person = this.person
    fun setPerson(person: Person) {
        this.person = person
    }
}