package nbt.hack.nbtbackend.model

import org.springframework.validation.annotation.Validated
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
data class Soil (
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = TODO(0.toString()),
    var type: String = "",
    @Min(0)
    @Max(100)
    var wet: Double = TODO(0.toString()),
    var deepOfRootSystem: Double = TODO(0.toString())


)
