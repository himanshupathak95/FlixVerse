package dev.himanshu.flixverse

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Reviews")
data class Review(var a: String) {
    @Id
    private var id: ObjectId = ObjectId.get()
    private var body: String = ""
}

