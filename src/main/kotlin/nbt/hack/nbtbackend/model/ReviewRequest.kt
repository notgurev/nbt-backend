package nbt.hack.nbtbackend.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.OneToOne

@Entity
data class ReviewRequest(
    @Id
    var id: Long = -1,
    @ManyToMany
    var experts: List<User>,
    @OneToOne
    var expertAnswer: ExpertAnswer,
)
