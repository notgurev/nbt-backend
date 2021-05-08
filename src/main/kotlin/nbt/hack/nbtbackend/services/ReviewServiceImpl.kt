package nbt.hack.nbtbackend.services

import nbt.hack.nbtbackend.model.ExpertAnswer
import org.springframework.stereotype.Service

@Service
class ReviewServiceImpl : ReviewService {
    override fun draftReviewRequest(fieldId: Long) {
        TODO("Not yet implemented")
    }

    override fun updateReviewRequest(requestId: Long) {
        TODO("Not yet implemented")
    }

    override fun submitReviewRequest(requestId: Long) {
        TODO("Not yet implemented")
    }

    override fun updateExpertAnswer(id: Long, expertAnswer: ExpertAnswer) {
        TODO("Not yet implemented")
    }

    override fun markExpertAnswerAsDone(answerId: Long) {
        TODO("Not yet implemented")
    }
}