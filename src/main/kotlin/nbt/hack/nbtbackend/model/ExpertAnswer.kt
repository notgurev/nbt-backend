package nbt.hack.nbtbackend.model

import javax.persistence.*

@Entity
data class ExpertAnswer(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = -1,
        @Column(name = "done")
        var done: Boolean = false,
        @Column(name = "text")
        var text: String? = null,
        @Column(name = "expected_yield")
        var expectedYield: Float? = null
)
