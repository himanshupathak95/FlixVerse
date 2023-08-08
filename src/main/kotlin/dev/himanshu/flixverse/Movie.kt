package dev.himanshu.flixverse

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference

@Document(collection = "Movies")
data class Movie(
    @Id
    var id: ObjectId? = null,
    var imdbId: String,
    var title: String,
    var releaseDate: String,
    var trailerLink: String,
    var poster: String,
    var backdrops: List<String>,
    var genres: List<String>,
    @DocumentReference
    var reviews: List<Review> = emptyList(),
)
