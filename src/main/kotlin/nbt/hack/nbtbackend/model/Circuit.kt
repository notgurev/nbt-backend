package nbt.hack.nbtbackend.model

import javax.persistence.*

@Entity
data class Circuit(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = -1,
        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
        var coordinateList: MutableList<Coordiante> = mutableListOf(Coordiante(x = -1.0F, y = 0.0F))
)
