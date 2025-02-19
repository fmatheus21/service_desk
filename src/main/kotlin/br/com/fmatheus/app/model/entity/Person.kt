package br.com.fmatheus.app.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "person")
class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private val id: Int? = null

    @Column(name = "name", nullable = false, length = 70)
    private var name: String = ""

    @Column(name = "document", nullable = false, length = 20)
    private var document: String = ""

    @ManyToOne
    @JoinColumn(name = "id_person_type", referencedColumnName = "id")
    private var personType: PersonType = PersonType()

    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "person", orphanRemoval = true)
    private var contact: Contact = Contact()

    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "person", orphanRemoval = true)
    private var client: Client = Client()

    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "person", orphanRemoval = true)
    private var user: User = User()


    fun getId(): Int? = this.id

    fun getName(): String = this.name
    fun setName(name: String) {
        this.name = name
    }

    fun getDocument(): String = this.document
    fun setDocument(document: String) {
        this.document = document
    }

    fun getPersonType(): PersonType = this.personType
    fun setPersonType(personType: PersonType) {
        this.personType = personType
    }

    fun getContact(): Contact = this.contact
    fun setContact(contact: Contact) {
        this.contact = contact
    }

    fun getClient(): Client = this.client
    fun setClient(client: Client) {
        this.client = client
    }

    fun getUser(): User = this.user
    fun setUser(user: User) {
        this.user = user
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