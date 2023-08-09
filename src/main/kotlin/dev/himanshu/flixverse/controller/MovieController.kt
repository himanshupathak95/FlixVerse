package dev.himanshu.flixverse.controller

import dev.himanshu.flixverse.model.Movie
import dev.himanshu.flixverse.service.MovieService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/movies")
class MovieController(private val service: MovieService) {

    @GetMapping
    fun getMovies(): ResponseEntity<List<Movie>> {
        val movieList = service.findAllMovies()
        return ResponseEntity.ok(movieList)
    }

    @GetMapping("/{imdbId}")
    fun getSingleMovie(@PathVariable imdbId: String): ResponseEntity<Movie?> {
        val singleMovie = service.findMovieByImdbId(imdbId)
        return ResponseEntity.ok(singleMovie)
    }
}
