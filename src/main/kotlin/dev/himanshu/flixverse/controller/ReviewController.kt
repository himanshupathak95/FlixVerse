package dev.himanshu.flixverse.controller

import dev.himanshu.flixverse.model.Review
import dev.himanshu.flixverse.service.ReviewService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/reviews")
class ReviewController(
    private val service: ReviewService,
) {
    @PostMapping
    fun createReview(@RequestBody payload: Map<String, String>): ResponseEntity<Review> {
        val reviewBody = payload["reviewBody"] ?: error("Missing 'reviewBody' in payload")
        val imdbId = payload["imdbId"] ?: error("Missing 'imdbId' in payload")
        val review = service.createReview(reviewBody, imdbId)
        return ResponseEntity.status(HttpStatus.CREATED).body(review)
    }
}
