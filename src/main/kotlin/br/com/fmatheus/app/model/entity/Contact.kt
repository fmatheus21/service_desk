package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "contact")
class Contact(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Int?,

    @NotBlank
    @Column(name = "phone", nullable = false, length = 20)
    var phone: String,

    @NotBlank
    @Column(name = "email", nullable = false, length = 200)
    var email: String,

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false)
    var person: Person
) {

    constructor(id: Int?) : this(
        id = id,
        phone = "",
        email = "",
        person = Person(null)
    )

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