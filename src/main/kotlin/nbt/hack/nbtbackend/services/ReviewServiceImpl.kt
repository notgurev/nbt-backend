package nbt.hack.nbtbackend.services

import nbt.hack.nbtbackend.model.ExpertAnswer
import nbt.hack.nbtbackend.model.ReviewRequest
import nbt.hack.nbtbackend.repositories.ExpertAnswerRepository
import nbt.hack.nbtbackend.repositories.ReviewRequestRepository
import nbt.hack.nbtbackend.util.maybeValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReviewServiceImpl @Autowired constructor(
    private val cropFieldService: CropFieldService,
    private val reviewRequestRepository: ReviewRequestRepository,
    private val expertAnswerRepository: ExpertAnswerRepository
) : ReviewService {
    override fun createReviewRequest(fieldId: Long) {
        val field = cropFieldService.getCropField(fieldId)
        val reviewRequest = ReviewRequest(field = field, submitted = false)
        reviewRequestRepository.save(reviewRequest)
    }

    override fun updateExpertAnswer(answerId: Long, expertAnswer: ExpertAnswer) {
        expertAnswer.id = answerId
        expertAnswerRepository.save(expertAnswer)
    }

    override fun markExpertAnswerAsDone(answerId: Long) {
        val expertAnswer = expertAnswerRepository.findById(answerId).maybeValue
        expertAnswer?.let { it.done = true } ?: throw IllegalArgumentException("No expert answer with id = $answerId")
        expertAnswerRepository.save(expertAnswer)
    }

    override fun getUnansweredReviewRequest(): List<ReviewRequest>{
        return reviewRequestRepository.findAll().filter {
            if (it.expertAnswer == null) false else !(it.expertAnswer!!.done)
        }
    }
}