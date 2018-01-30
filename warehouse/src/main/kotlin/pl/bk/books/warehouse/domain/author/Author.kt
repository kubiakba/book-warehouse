package pl.bk.books.warehouse.domain.author

import pl.bk.books.warehouse.domain.AbstractEntity
import pl.bk.books.warehouse.domain.bookAuthors.BookAuthors
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
class Author (var name: String,
              var surname : String,
              var birth: LocalDate,
              var birthCity: String,
              @Enumerated(EnumType.STRING)
              var nationality: Country): AbstractEntity() {

    @OneToMany(mappedBy="author", cascade = [(CascadeType.ALL)])
    var books : MutableSet<BookAuthors> = HashSet()
}