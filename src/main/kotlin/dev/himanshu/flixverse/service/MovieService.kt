package dev.himanshu.flixverse.service

import dev.himanshu.flixverse.model.Movie
import dev.himanshu.flixverse.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(
    private val repository: MovieRepository
) {

    fun findAllMovies(): List<Movie> {
        return repository.findAll()
    }

    fun findMovieByImdbId(imdbId: String): Movie? {
        return repository.findMovieByImdbId(imdbId)
    }
}
