package pl.bk.books.warehouse.domain.bookAuthors

import pl.bk.books.warehouse.domain.AbstractEntity
import pl.bk.books.warehouse.domain.author.Author
import pl.bk.books.warehouse.domain.book.Book
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class BookAuthors(
        @ManyToOne
              @JoinColumn(name = "book_id", nullable = false)
              var book : Book,

        @ManyToOne
              @JoinColumn(name = "author_id", nullable = false)
              var author : Author): AbstractEntity()