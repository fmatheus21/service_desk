package br.com.fmatheus.app.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID


@Entity
@Table(name = "ticket")
class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private val id: UUID? = null

    @Column(name = "title", nullable = false, length = 100)
    private var title: String = ""

    @Column(name = "problem_description", nullable = false, columnDefinition = "MEDIUMTEXT")
    private var problemDescription: String = ""

    @Column(name = "created_date", nullable = false)
    private var createdDate: LocalDateTime = LocalDateTime.now()

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    private var client: Client = Client()

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = true)
    private var owner: User? = null


    fun getId(): UUID? = this.id

}