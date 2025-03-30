package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.io.Serializable

@Entity
@Table(name = "person_type")
class PersonType : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private var id: Int? = 0

    @NotBlank
    @Column(name = "name", nullable = false, length = 20)
    private var name: String = ""

    fun getId(): Int? = this.id

    fun getName(): String = this.name
    fun setName(name: String) {
        this.name = name
    }

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