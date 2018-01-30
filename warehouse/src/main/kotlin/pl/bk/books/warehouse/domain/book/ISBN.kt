package pl.bk.books.warehouse.domain.book

import org.apache.commons.validator.routines.ISBNValidator
import javax.persistence.Embeddable

@Embeddable
data class ISBN(private val isbnNumber:String){

    init{
        validate(isbnNumber)
    }

    private fun validate(isbnNumber: String) {
        if(!ISBNValidator.getInstance().isValid(isbnNumber)){
            throw BadISBNumberException("ISBN number is invalid")
        }
    }

    class BadISBNumberException(message: String) : Throwable()
}

