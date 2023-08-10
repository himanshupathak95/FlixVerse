package dev.himanshu.flixverse.service

import dev.himanshu.flixverse.model.Movie
import dev.himanshu.flixverse.model.Review
import dev.himanshu.flixverse.repository.ReviewRepository
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ReviewService(
    private val repository: ReviewRepository,
    private val mongoTemplate: MongoTemplate
) {
    fun createReview(reviewBody: String, imdbId: String): Review {
        val review = repository.insert(
            Review(
                null,
                reviewBody,
                LocalDateTime.now(),
                LocalDateTime.now(),
            ),
        )
        mongoTemplate.updateFirst(
            Query.query(Criteria.where("imdbId").`is`(imdbId)),
            Update().push("reviews", review),
            Movie::class.java,
        )
        return review
    }
}
