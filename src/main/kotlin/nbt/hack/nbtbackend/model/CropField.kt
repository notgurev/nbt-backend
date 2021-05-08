package nbt.hack.nbtbackend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
data class CropField(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crop_field_sequence")
    @SequenceGenerator(name = "crop_field_sequence", initialValue = 1)
    var id: Long = -1,
    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JsonIgnore
    var owner: User? = null,
    var name: String? = "", // имя культуры
    @OneToOne(cascade = [CascadeType.ALL])
    var culture: Culture? = Culture(), // растение и его характеристики
    var previousCulture: String? = "", // имя предыдущей культуры
    var area: Float? = -1.0F, // площадь поля
    var yield: Float? = -1.0F, // урожайность
    @Min(0)
    var snowCover: Float? = -1.0F, // средняя толщина снежного покрова
    @Min(0)
    @Max(100)
    var fieldIllness: Float? = -1.0F, // поражение болезнью растений
    @Min(0)
    @Max(100)
    var fieldWeed: Float? = -1.0F // поражение сорняками
)