package br.com.fmatheus.app.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "contact")
class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private val id: Int? = null

    @Column(name = "phone", nullable = false, length = 20)
    private var phone: String = ""

    @Column(name = "email", nullable = false, length = 200)
    private var email: String = ""

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false)
    private var person: Person = Person()

    fun getId(): Int? = this.id

    fun getPhone(): String = this.phone
    fun setPhone(phone: String) {
        this.phone = phone
    }

    fun getEmail(): String = this.email
    fun setEmail(email: String) {
        this.email = email
    }

    fun getPerson(): Person = this.person
    fun setPerson(person: Person) {
        this.person = person
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Contact) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id ?: 0
    }


}