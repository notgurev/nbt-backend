package nbt.hack.nbtbackend.model

import javax.persistence.*
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "coordinates")
data class Coordinates(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1,
    @PositiveOrZero
    var x: Float? = null,
    @PositiveOrZero
    var y: Float? = null
)
