package pl.bk.books.warehouse.controller

import org.springframework.web.bind.annotation.*
import pl.bk.books.warehouse.dto.NewAuthorDto
import pl.bk.books.warehouse.dto.UpdatedAuthorDto
import pl.bk.books.warehouse.service.AuthorService

@RestController
@RequestMapping("/authors")
class AuthorController(private val authorService: AuthorService) {

    @PostMapping
    fun addAuthor(@RequestBody authorDto: NewAuthorDto) = authorService.addAuthor(authorDto)

    @GetMapping
    fun getAll() : List<NewAuthorDto> = authorService.getAuthors()

    @GetMapping("/{id}")
    fun getOne(@PathVariable("id") id :String ) = authorService.getOne(id)

    @PatchMapping("/{id}")
    fun updateAuthor(@RequestBody updatedAuthorDto: UpdatedAuthorDto) = authorService.updateUser(updatedAuthorDto)
}

