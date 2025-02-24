package br.com.fmatheus.app.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank


@Entity
@Table(name = "person")
class Person(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Int?,

    @NotBlank
    @Column(name = "name", nullable = false, length = 150)
    var name: String,

    @NotBlank
    @Column(name = "document", nullable = false, length = 20)
    var document: String,

    @ManyToOne
    @JoinColumn(name = "id_person_type", referencedColumnName = "id")
    var personType: PersonType,

    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "person", orphanRemoval = true)
    var contact: Contact,

    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "person", orphanRemoval = true)
    var client: Client,

    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "person", orphanRemoval = true)
    var user: User?
) {

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