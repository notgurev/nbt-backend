package nbt.hack.nbtbackend.repositories

import nbt.hack.nbtbackend.model.ExpertAnswer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpertAnswerRepository : JpaRepository<ExpertAnswer, Long>