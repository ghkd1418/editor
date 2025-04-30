package com.example.demo.database.model

import io.jsonwebtoken.security.Password
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class User(
    @Id val id: ObjectId = ObjectId(),
    val name: String,
    val age: Int,
    val email: String,
    val hashedPassword: Password
    )
