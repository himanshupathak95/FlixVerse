package dev.himanshu.flixverse.controller

import dev.himanshu.flixverse.model.Movie
import dev.himanshu.flixverse.service.MovieService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = ["http://localhost:3000"])
class MovieController(
    private val service: MovieService
) {

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
