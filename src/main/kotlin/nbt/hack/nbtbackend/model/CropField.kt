package nbt.hack.nbtbackend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
data class CropField(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crop_field_sequence")
    @SequenceGenerator(name = "crop_field_sequence", initialValue = 0)
    var id: Long = -1,
    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JsonIgnore
    var owner: User? = null,
    var name: String? = null, // имя культуры
    @OneToOne(cascade = [CascadeType.ALL])
    var culture: Culture = Culture(), // растение и его характеристики
    @OneToOne(cascade = [CascadeType.ALL])
    var soil: Soil = Soil(),
    var previousCulture: String? = null, // имя предыдущей культуры
    var area: Float? = null, // площадь поля
    var yield: Float? = null, // урожайность
    @Min(0)
    var snowCover: Float? = null, // средняя толщина снежного покрова
    @Min(0)
    @Max(100)
    var fieldIllness: Float? = null, // поражение болезнью растений
    @Min(0)
    @Max(100)
    var fieldWeed: Float? = null // поражение сорняками
)