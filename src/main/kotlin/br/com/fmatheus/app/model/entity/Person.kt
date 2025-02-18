package br.com.fmatheus.app.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "person")
class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Int? = null

    @Column(name = "name", nullable = false, length = 70)
    private var name: String = ""

    @Column(name = "document", nullable = false, length = 20)
    private var document: String = ""


    fun getId(): Int? = this.id

    fun getName(): String = this.name
    fun setName(name: String) {
        this.name = name
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Person) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id ?: 0
    }


}