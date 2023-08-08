package dev.himanshu.flixverse

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val mongoTemplate: MongoTemplate
) {
    fun createReview(reviewBody: String, imdbId: String): Review {
        val review = reviewRepository.insert(Review(reviewBody))
        mongoTemplate.update(Movie::class.java)
            .matching(Criteria.where("imdbId").`is`(imdbId))
            .apply(Update().push("reviewIds").value(review))
        return review
    }
}