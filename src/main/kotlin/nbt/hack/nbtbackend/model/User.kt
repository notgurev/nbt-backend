package nbt.hack.nbtbackend.model

import javax.persistence.*

@Entity
@Table(name = "accounts")
data class User(
    @Id
    var username: String? = null,
    val name: String? = null, // имя для обращений
    var password: String? = null,
    var isExpert: Boolean = false,

    // for farmers
    @OneToMany(cascade = [CascadeType.PERSIST])
    var cropFields: MutableList<CropField> = mutableListOf(),
    @OneToMany(cascade = [CascadeType.PERSIST])
    var reviewRequests: MutableList<ReviewRequest> = mutableListOf(),

    // for experts
    @ManyToMany(cascade = [CascadeType.PERSIST])
    var assignedReviewRequests: MutableList<ReviewRequest> = mutableListOf(),
)