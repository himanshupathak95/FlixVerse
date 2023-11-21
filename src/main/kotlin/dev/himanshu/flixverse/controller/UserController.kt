package dev.himanshu.flixverse.controller

import dev.himanshu.flixverse.model.User
import dev.himanshu.flixverse.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = ["http://localhost:3000"])
class AuthController(private val userRepository: UserRepository, private val passwordEncoder: BCryptPasswordEncoder) {

    // POST endpoint for handling user registration
    @PostMapping("/register")
    fun register(@RequestBody credentials: User): Map<String, String> {
        // Check if the user already exists
        if (userRepository.existsById(credentials.userId)) {
            return mapOf("success" to "false", "message" to "User already exists")
        }

        // Hash the password before storing it
        val hashedPassword = passwordEncoder.encode(credentials.password)
        userRepository.save(User(credentials.userId, hashedPassword))

        return mapOf("success" to "true", "message" to "Registration successful")
    }

    // POST endpoint for handling login
    @PostMapping("/login")
    fun login(@RequestBody credentials: User): Map<String, String> {
        val user = userRepository.findById(credentials.userId)

        return if (user.isPresent && passwordEncoder.matches(credentials.password, user.get().password)) {
            mapOf("success" to "true", "message" to "Login successful")
        } else {
            mapOf("success" to "false", "message" to "Invalid credentials")
        }
    }
}