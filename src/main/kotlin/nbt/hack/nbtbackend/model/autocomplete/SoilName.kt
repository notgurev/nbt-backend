package nbt.hack.nbtbackend.model.autocomplete

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class SoilName(
    @Id
    var id: Long = -1,
    @Column(unique = true)
    var name: String = ""
)