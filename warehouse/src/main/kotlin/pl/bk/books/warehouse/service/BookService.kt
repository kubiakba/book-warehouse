package pl.bk.books.warehouse.service

import org.springframework.stereotype.Service
import pl.bk.books.warehouse.domain.author.AuthorRepository
import pl.bk.books.warehouse.domain.book.Book
import pl.bk.books.warehouse.domain.book.BookRepository
import pl.bk.books.warehouse.domain.bookAuthors.BookAuthors
import pl.bk.books.warehouse.domain.bookAuthors.BookAuthorsRepository
import pl.bk.books.warehouse.dto.BookDto
import pl.bk.books.warehouse.dto.DtoMappers
import pl.bk.books.warehouse.dto.NewBookDto

@Service
class BookService (private val bookRepository : BookRepository,
                   private val authorsRepository: AuthorRepository,
                   private val bookAuthorsRepository: BookAuthorsRepository,
                   private val mappers: DtoMappers){

    fun addBook(bookDto : NewBookDto) {
        val authors = authorsRepository.findAll(bookDto.authorsId.map { x -> x.toLong() })
        val book = mappers.mapBookFromDto(bookDto)
        val savedBook = bookRepository.save(book)
        authors.forEach { x-> bookAuthorsRepository.save(BookAuthors(savedBook, x)) }
    }

    fun getAll(): List<BookDto> = bookRepository.findAll().map { x-> mappers.mapBookToDto(x) }

    fun delete(id: String) = bookRepository.delete(id.toLong())

    fun getOne(id: String): BookDto {
        val book: Book? = bookRepository.findOne(id.toLong())
        return if(book != null) mappers.mapBookToDto(book) else BookDto()
    }
}