package dev.himanshu.flixverse

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "media")
data class Media(var a: String) {
    @Id
    private var id: ObjectId = ObjectId.get()
    private var imdbId: String = ""
    private var title: String = ""
    private var releaseDate: String = ""
    private var trailerLink: String = ""
    private var poster: String = ""
    private var genres: List<String> = emptyList()
    private var backdrops: List<String> = emptyList()
}
