package pl.bk.books.warehouse.dto

import com.fasterxml.jackson.annotation.JsonFormat
import pl.bk.books.warehouse.domain.author.Country
import pl.bk.books.warehouse.domain.book.ISBN
import java.time.LocalDate

class NewBookDto(val title: String? = null,
                 val isbn: ISBN? = null,
                 val authorsId :Set<String> = emptySet(),
                 val publisher:String? = null,
                 val releaseDate: LocalDate? = null,
                 val notes: String? = null,
                 val location: String? = null)

class BookDto(val id: Long? = null,
              val title: String? = null,
              val isbn: ISBN? = null,
              val authors:Set<NewAuthorDto> = emptySet(),
              val publisher:String? = null,
              val releaseDate: LocalDate? = null,
              val notes: String? = null,
              val location: String? = null)

class NewAuthorDto(val name: String? = null,
                   val surname: String? = null,
                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                   val birth: LocalDate? = null,
                   val birthCity: String? = null,
                   val nationality: Country? = null)

class UpdatedAuthorDto(val id:Long? = null,
                       val name: String? = null,
                       val surname: String? = null,
                       @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                       val birth: LocalDate? = null,
                       val birthCity: String? = null,
                       val nationality: Country? = null)

class NewLocationDto(val city:String? = null,
                     val street: String? = null,
                     val streetNumber: String? = null,
                     val postCode: String? = null)

class LocationDto(val city:String? = null,
                  val street: String? = null,
                  val streetNumber: String? = null,
                  val postCode: String? = null)



