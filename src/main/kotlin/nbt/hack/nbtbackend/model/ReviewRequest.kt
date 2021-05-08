package nbt.hack.nbtbackend.model

import javax.persistence.*

@Entity
data class ReviewRequest(
    @Id
    var id: Long = -1,
    @Column(name = "submitted")
    var submitted: Boolean = false,
    @OneToOne
    var field: CropField? = null,
    @OneToOne(orphanRemoval = true)
    var expertAnswer: ExpertAnswer? = ExpertAnswer(),
)
