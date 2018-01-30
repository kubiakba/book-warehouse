package pl.bk.books.warehouse.service

import org.springframework.stereotype.Service
import pl.bk.books.warehouse.domain.author.AuthorRepository
import pl.bk.books.warehouse.dto.DtoMappers
import pl.bk.books.warehouse.dto.NewAuthorDto
import pl.bk.books.warehouse.dto.UpdatedAuthorDto

@Service
class AuthorService(private val authorRepository: AuthorRepository,
                    private val mappers: DtoMappers) {

    fun addAuthor(authorDto: NewAuthorDto) {
        authorRepository.save(mappers.mapAuthorFromDto(authorDto))!!
    }

    fun getAuthors() = authorRepository.findAll().map { x-> mappers.mapAuthorToDto(x) }

    fun getOne(id: String) = mappers.mapAuthorToDto(authorRepository.findOne(id.toLong()))

    fun updateUser(updatedAuthorDto: UpdatedAuthorDto) {
        val author = authorRepository.findOne(updatedAuthorDto.id)
        if (updatedAuthorDto.name != null) author.name = updatedAuthorDto.name
        if (updatedAuthorDto.surname != null) author.surname = updatedAuthorDto.surname
        if (updatedAuthorDto.birth != null) author.birth = updatedAuthorDto.birth
        if (updatedAuthorDto.birthCity != null) author.birthCity = updatedAuthorDto.birthCity
        if (updatedAuthorDto.nationality != null) author.nationality = updatedAuthorDto.nationality
        authorRepository.save(author)
    }

}