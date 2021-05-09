package nbt.hack.nbtbackend.repositories

import nbt.hack.nbtbackend.model.ReviewRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRequestRepository : JpaRepository<ReviewRequest, Long>