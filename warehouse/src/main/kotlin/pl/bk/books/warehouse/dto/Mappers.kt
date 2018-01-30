package pl.bk.books.warehouse.dto

import org.springframework.stereotype.Service
import pl.bk.books.warehouse.domain.author.Author
import pl.bk.books.warehouse.domain.author.AuthorRepository
import pl.bk.books.warehouse.domain.book.Book
import pl.bk.books.warehouse.domain.location.Location
import pl.bk.books.warehouse.domain.location.LocationRepository

@Service
class DtoMappers(private val authorRepository : AuthorRepository,
                 private val locationRepository: LocationRepository){

    fun mapAuthorToDto(author: Author) = NewAuthorDto(author.name,
            author.surname,
            author.birth,
            author.birthCity,
            author.nationality)

    fun mapAuthorFromDto(authorDto: NewAuthorDto) = Author(authorDto.name!!,
                                                           authorDto.surname!!,
                                                           authorDto.birth!!,
                                                           authorDto.birthCity!!,
                                                           authorDto.nationality!!)

    fun mapBookToDto(book : Book): BookDto {
        val authors = authorRepository.findAll(book.authors.map { x -> x.id })
        return BookDto(
                book.id,
                book.title,
                book.isbn,
                authors.map { x-> mapAuthorToDto(x) }.toSet(),
                book.publisher,
                book.releaseDate
        )
    }

    fun mapBookFromDto(bookDto : NewBookDto): Book {
        val location: Location? = locationRepository.findOne(bookDto.location?.toLong())
        val book = Book(bookDto.title!!, bookDto.isbn!!)
        book.location = location
        book.releaseDate = bookDto.releaseDate
        book.publisher = bookDto.publisher
        book.notes = bookDto.notes
        return book
    }

    fun mapLocationToDto(location: Location): LocationDto{
        return LocationDto(location.city,
                location.street,
                location.streetNumber,
                location.postCode)
    }

    fun mapLocationFromDto(locationDto: NewLocationDto): Location {
        return Location(locationDto.city!!,
                locationDto.street!!,
                locationDto.streetNumber!!,
                locationDto.postCode!!)
    }
}