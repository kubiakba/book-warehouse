package pl.bk.books.warehouse.service

import org.springframework.stereotype.Service
import pl.bk.books.warehouse.domain.location.LocationRepository
import pl.bk.books.warehouse.dto.DtoMappers
import pl.bk.books.warehouse.dto.LocationDto
import pl.bk.books.warehouse.dto.NewLocationDto

@Service
class LocationService (private val locationRepository: LocationRepository,
                       private val mappers: DtoMappers){

    fun getAll(): List<LocationDto> = locationRepository.findAll().map { x-> mappers.mapLocationToDto(x) }.toList()

    fun createLocation(locationDto: NewLocationDto): Unit {
        locationRepository.save(mappers.mapLocationFromDto(locationDto))
    }
}


