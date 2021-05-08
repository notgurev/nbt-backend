package nbt.hack.nbtbackend.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class ExpertAnswer(
        @Id
        var id: Long = -1,
        @Column(name = "text")
        var text: String? = null,
        @Column(name = "expected_yield")
        var expectedYield: Float? = null
)
