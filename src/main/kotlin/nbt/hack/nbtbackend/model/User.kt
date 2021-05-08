package nbt.hack.nbtbackend.model

import javax.persistence.*

@Entity
@Table(name = "accounts")
data class User(
        @Id
        var username: String? = null,
        var password: String? = null,
        var isExpert: Boolean = false,

        // for farmers
        @OneToMany
        var cropFields: List<CropField> = emptyList(),
        @OneToMany
        var reviewRequests: List<ReviewRequest> = emptyList(),

        // for experts
        @ManyToMany
        var assignedReviewRequests: List<ReviewRequest> = emptyList(),
)