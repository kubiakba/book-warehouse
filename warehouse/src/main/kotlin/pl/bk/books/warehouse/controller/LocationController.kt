package pl.bk.books.warehouse.controller

import org.springframework.web.bind.annotation.*
import pl.bk.books.warehouse.dto.LocationDto
import pl.bk.books.warehouse.dto.NewLocationDto
import pl.bk.books.warehouse.service.LocationService


@RestController
@RequestMapping("/location")
class LocationController(private val locationService: LocationService) {

    @GetMapping
    fun getAll(): List<LocationDto> = locationService.getAll()

    @PostMapping
    fun createLocation(@RequestBody locationDto: NewLocationDto) = locationService.createLocation(locationDto)
}