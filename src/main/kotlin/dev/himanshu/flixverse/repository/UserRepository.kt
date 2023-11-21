package dev.himanshu.flixverse.repository

import dev.himanshu.flixverse.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String>