package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "person_type")
class PersonType(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Int?,

    @NotBlank
    @Column(name = "name", nullable = false, length = 20)
    var name: String

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PersonType) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id ?: 0
    }
}