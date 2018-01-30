package pl.bk.books.warehouse.domain

import java.time.LocalDateTime
import java.time.ZoneId
import javax.persistence.*

@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    val id: Long = 0

    private var lastUpdateDate: LocalDateTime? = null

    private var creationDate: LocalDateTime? = null

    @Version
    val version :Int = 0

    @PreUpdate
    fun onPreUpdate(){
        lastUpdateDate = LocalDateTime.now(ZoneId.of("Europe/Warsaw"))
    }

    @PrePersist
    fun onPrePersist(){
        creationDate = LocalDateTime.now(ZoneId.of("Europe/Warsaw"))
    }
}