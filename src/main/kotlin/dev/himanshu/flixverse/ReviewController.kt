package dev.himanshu.flixverse

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/reviews")
class ReviewController(
    private val reviewService: ReviewService,
) {
    @PostMapping
    fun createReview(@RequestBody payload: Map<String, String>): ResponseEntity<Review> {
        return ResponseEntity<Review>(
            reviewService.createReview(
                payload["reviewBody"] ?: "",
                payload["imdbId"] ?: "",
            ),
            HttpStatus.CREATED,
        )
    }
}
