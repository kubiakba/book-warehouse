package pl.bk.books.warehouse.controller

import org.springframework.web.bind.annotation.*
import pl.bk.books.warehouse.dto.BookDto
import pl.bk.books.warehouse.dto.NewBookDto
import pl.bk.books.warehouse.service.BookService

@RestController
@RequestMapping("/books")
class BookController (private val bookService: BookService){

    @GetMapping
    fun getAll(): List<BookDto> = bookService.getAll()

    @PostMapping
    fun addBook(@RequestBody book: NewBookDto) =  bookService.addBook(book)

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable("id") id :String) = bookService.delete(id)

    @GetMapping("/{id}")
    fun getOne(@PathVariable("id") id :String) = bookService.getOne(id)
}