package pl.bk.books.warehouse.domain.location

import pl.bk.books.warehouse.domain.AbstractEntity
import javax.persistence.Entity

@Entity
class Location(var city:String,
               var street: String,
               var streetNumber:String,
               var postCode: String): AbstractEntity()