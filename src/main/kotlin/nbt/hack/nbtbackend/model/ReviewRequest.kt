package nbt.hack.nbtbackend.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
data class ReviewRequest(
    @Id
    var id: Long = -1,
    @Column(name = "submitted")
    var submitted: Boolean,
    @OneToOne
    var expertAnswer: ExpertAnswer? = ExpertAnswer(),
)
