package pl.bk.books.warehouse

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters

@EntityScan(basePackageClasses = [(WarehouseApplication::class), (Jsr310JpaConverters::class)])
@SpringBootApplication
class WarehouseApplication{

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(WarehouseApplication::class.java, *args)
        }
    }
}