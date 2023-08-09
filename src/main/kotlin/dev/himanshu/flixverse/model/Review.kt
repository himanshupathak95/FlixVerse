package dev.himanshu.flixverse.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "reviews")
data class Review(
    @Id
    val id: ObjectId? = null,
    val body: String,
    val created: LocalDateTime,
    val updated: LocalDateTime,
)
