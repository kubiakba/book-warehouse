package pl.bk.books.warehouse.domain.author

import org.springframework.data.repository.CrudRepository

interface AuthorRepository :CrudRepository<Author,Long>
