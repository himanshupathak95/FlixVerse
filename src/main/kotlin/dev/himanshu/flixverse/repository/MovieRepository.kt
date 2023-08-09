package dev.himanshu.flixverse.repository

import dev.himanshu.flixverse.model.Movie
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : MongoRepository<Movie, ObjectId> {
    fun findMovieByImdbId(imdbId: String): Movie?
}
