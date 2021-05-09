package nbt.hack.nbtbackend.services

import nbt.hack.nbtbackend.model.ExpertAnswer
import nbt.hack.nbtbackend.model.ReviewRequest
import org.springframework.stereotype.Component

@Component
interface ReviewService {
    fun createReviewRequest(fieldId: Long)

    fun updateExpertAnswer(answerId: Long, expertAnswer: ExpertAnswer)

    fun markExpertAnswerAsDone(answerId: Long)

    fun getUnansweredReviewRequest(): List<ReviewRequest>

    fun getReviewRequests(): List<ReviewRequest>
}