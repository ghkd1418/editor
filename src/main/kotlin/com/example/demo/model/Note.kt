package com.example.demo.model

import java.time.Instant
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("notes")
data class Note(
    val title: String,
    val content: String,
    val color: Long,
    val createAt: Instant,
    @Id val id: ObjectId = ObjectId.get()
)
