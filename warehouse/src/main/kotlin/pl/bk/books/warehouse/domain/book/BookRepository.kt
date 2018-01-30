package pl.bk.books.warehouse.domain.book

import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book,Long>