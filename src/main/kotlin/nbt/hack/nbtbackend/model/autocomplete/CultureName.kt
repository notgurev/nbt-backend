package nbt.hack.nbtbackend.model.autocomplete

import javax.persistence.*

@Entity
data class CultureName(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1,
    @Column(unique = true)
    var name: String = ""
)

