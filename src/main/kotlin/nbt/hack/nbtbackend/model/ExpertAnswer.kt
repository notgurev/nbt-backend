package nbt.hack.nbtbackend.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class ExpertAnswer(
        @Id
        var id: Long = TODO("initialize me"),
        @Column(name = "weather_forecast")
        var forecast: String = "",
        @Column(name = "text")
        var text: String,
        @Column(name = "expected_yield")
        var expectedYield: Float
)
