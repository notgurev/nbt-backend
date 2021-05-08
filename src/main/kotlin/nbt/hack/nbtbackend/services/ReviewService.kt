package nbt.hack.nbtbackend.services

import nbt.hack.nbtbackend.model.ExpertAnswer
import org.springframework.stereotype.Component

@Component
interface ReviewService {
    fun draftReviewRequest(fieldId: Long)

    fun updateReviewRequest(requestId: Long)

    fun submitReviewRequest(requestId: Long)

    fun updateExpertAnswer(id: Long, expertAnswer: ExpertAnswer)

    fun markExpertAnswerAsDone(answerId: Long)
}