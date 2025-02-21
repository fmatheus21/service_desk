package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "contact")
class Contact(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private val id: Int,

    @NotBlank
    @Column(name = "phone", nullable = false, length = 20)
    private var phone: String,

    @NotBlank
    @Column(name = "email", nullable = false, length = 200)
    private var email: String,

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false)
    private var person: Person
) {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Contact) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}