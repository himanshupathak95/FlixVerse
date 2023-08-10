package dev.himanshu.flixverse.service

import dev.himanshu.flixverse.model.Movie
import dev.himanshu.flixverse.repository.MovieRepository
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.bson.types.ObjectId
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MovieServiceTest {

    private val imdbId1 = "123"
    private val imdbId2 = "456"
    private val movie1 = Movie(
        ObjectId(),
        imdbId1,
        "Movie 1",
        "2023-08-09",
        "trailer1",
        "poster1",
        emptyList(),
        emptyList(),
        emptyList(),
    )
    private val movie2 = Movie(
        ObjectId(),
        imdbId2,
        "Movie 2",
        "2023-08-10",
        "trailer2",
        "poster2",
        emptyList(),
        emptyList(),
        emptyList(),
    )

    private lateinit var movieRepository: MovieRepository
    private lateinit var movieService: MovieService

    @BeforeEach
    fun setUp() {
        movieRepository = mockk()
        movieService = MovieService(movieRepository)
    }

    @AfterEach
    fun shutDown() {
        clearAllMocks()
    }

    @Test
    fun `test findAllMovies`() {
        val expectedMovies = listOf(movie1, movie2)
        every { movieRepository.findAll() } returns expectedMovies
        val result = movieService.findAllMovies()
        assertEquals(expectedMovies, result)
    }

    @Test
    fun `test findMovieByImdbId with existing movie`() {
        every { movieRepository.findMovieByImdbId(imdbId1) } returns movie1
        val result = movieService.findMovieByImdbId(imdbId1)
        assertEquals(movie1, result)
    }

    @Test
    fun `test findMovieByImdbId with non-existing movie`() {
        val imdbId = "789"
        every { movieRepository.findMovieByImdbId(imdbId) } returns null
        val result = movieService.findMovieByImdbId(imdbId)
        assertEquals(null, result)
    }
}
