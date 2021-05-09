package nbt.hack.nbtbackend.model

import javax.persistence.*

@Entity
@Table(name = "contour")
data class Contour(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = -1,
        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
        var coordinateList: MutableList<Coordinates> = mutableListOf(Coordinates())
)
