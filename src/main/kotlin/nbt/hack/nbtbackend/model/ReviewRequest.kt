package nbt.hack.nbtbackend.model

import javax.persistence.*

@Entity
data class ReviewRequest(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1,
    @Column(name = "submitted")
    var submitted: Boolean = false,
    @OneToOne
    var field: CropField? = null,
    @OneToOne(orphanRemoval = true, cascade = [CascadeType.ALL])
    var expertAnswer: ExpertAnswer? = ExpertAnswer(),
)
