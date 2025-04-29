package com.example.demo.database.repository

import com.example.demo.database.model.Note
import org.bson.types.ObjectId

import org.springframework.data.mongodb.repository.MongoRepository

interface NoteRepository: MongoRepository<Note, ObjectId> {
    fun findByOwnerId(ownerId: ObjectId): List<Note>
}
