package pl.bk.books.warehouse.domain.book

import pl.bk.books.warehouse.domain.AbstractEntity
import pl.bk.books.warehouse.domain.bookAuthors.BookAuthors
import pl.bk.books.warehouse.domain.location.Location
import java.time.LocalDate
import javax.persistence.*

@Entity
class Book(var title: String, @Embedded var isbn : ISBN) : AbstractEntity() {

    @OneToMany(mappedBy = "book", cascade = [(CascadeType.ALL)])
    var authors : MutableSet<BookAuthors> = HashSet()

    @OneToOne
    var location : Location? = null

    var releaseDate : LocalDate? = null

    var publisher :String? = null

    var notes: String? = null
}