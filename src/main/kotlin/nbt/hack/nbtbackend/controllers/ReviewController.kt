package nbt.hack.nbtbackend.controllers

import nbt.hack.nbtbackend.model.ExpertAnswer
import nbt.hack.nbtbackend.model.ReviewRequest
import nbt.hack.nbtbackend.services.ReviewService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/reviews")
class ReviewController @Autowired constructor(
        private var reviewService: ReviewService,
){
    @GetMapping("/{fieldId}")
    @PreAuthorize("hasAuthority('user')")
    fun createReviewRequest(@PathVariable fieldId: Long){
        reviewService.createReviewRequest(fieldId)
    }

    @PostMapping("/{answerId}")
    @PreAuthorize("hasAuthority('expert')")
    fun updateExpertAnswer(@PathVariable answerId: Long, @RequestBody expertAnswer: ExpertAnswer){
        reviewService.updateExpertAnswer(answerId, expertAnswer)
    }

    @PostMapping("/{answerId}/done")
    @PreAuthorize("hasAuthority('expert')")
    fun markExpertAnswerAsDone(@PathVariable answerId: Long){
        reviewService.markExpertAnswerAsDone(answerId)
    }

    @GetMapping
    @PreAuthorize("hasAuthority('expert')")
    fun getUnansweredReviewRequest(): List<ReviewRequest>{
        return reviewService.getUnansweredReviewRequest()
    }
}