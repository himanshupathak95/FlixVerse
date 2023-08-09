package dev.himanshu.flixverse.service

import com.mongodb.client.result.UpdateResult
import dev.himanshu.flixverse.model.Movie
import dev.himanshu.flixverse.model.Review
import dev.himanshu.flixverse.repository.ReviewRepository
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.bson.types.ObjectId
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import java.time.LocalDateTime

@SpringBootTest
class ReviewServiceTest {

    private val reviewRepository: ReviewRepository = mockk()
    private val mongoTemplate: MongoTemplate = mockk()

    private lateinit var reviewService: ReviewService

    @BeforeEach
    fun setUp() {
        reviewService = ReviewService(reviewRepository, mongoTemplate)
    }

    @AfterEach
    fun shutDown() {
        clearAllMocks()
    }

    @Test
    fun `test createReview`() {
        val reviewBody = "Sample review"
        val imdbId = "sampleImdbId"
        val review = Review(ObjectId(), reviewBody, LocalDateTime.now(), LocalDateTime.now())

        every { reviewRepository.insert(any<Review>()) } returns review
        every {
            mongoTemplate.updateFirst(
                Query.query(Criteria.where("imdbId").`is`(imdbId)),
                any<Update>(),
                Movie::class.java,
            )
        } returns UpdateResult.acknowledged(1, 1, null)

        val result = reviewService.createReview(reviewBody, imdbId)
        assertEquals(review, result)

        verify { reviewRepository.insert(any<Review>()) }
        verify {
            mongoTemplate.updateFirst(
                Query.query(Criteria.where("imdbId").`is`(imdbId)),
                any<Update>(),
                Movie::class.java,
            )
        }
    }
}
