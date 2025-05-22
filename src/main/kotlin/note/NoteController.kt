package note


import note.database.model.Note
import note.database.repository.NoteRepository
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
@RequestMapping("/notes")
class NoteController(private val repository: NoteRepository) {

    data class NoteRequest(val id: String?, val title:String, val content: String, val color:Long )

    data class NoteResponse(val id: String, val title: String, val content: String, val color: Long, val createdAt: Instant)

    @PostMapping
    fun save(@RequestBody body: NoteRequest): NoteResponse {
        val note = repository.save(
            Note(
                id = body.id?.let { ObjectId(it) } ?: ObjectId.get(),
                title =  body.title,
                content =  body.content,
                color = body.color,
                createAt = Instant.now(),
                ownerId = ObjectId()
            )
        )
        return  note.toResponse()
    }

    @GetMapping
    fun findByOwnerId(): List<NoteResponse> {
        val ownerId =

        return repository.findByOwnerId(ObjectId(ownerId)).map {
            it.toResponse()
        }
    }

    @DeleteMapping(path = ["/{id}"])
    fun deleteById(
        @PathVariable id: String
    ) {
        repository.deleteById(ObjectId(id))
    }

    private fun Note.toResponse(): NoteController.NoteResponse {
        return NoteResponse(
            id = id.toHexString(),
            title = title,
            content = content,
            color = color,
            createdAt = createAt
        )
    }
}

