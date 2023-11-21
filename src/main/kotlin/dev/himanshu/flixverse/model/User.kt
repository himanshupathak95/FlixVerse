package dev.himanshu.flixverse.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class User(@Id val userId: String, val password: String)
