package nbt.hack.nbtbackend.model

import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
class CropField (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1,
    @OneToOne
    var owner: User,
    var name: String? = "", // имя культуры
    @OneToOne
    var culture: Culture? = Culture(), // растение и его характеристики
    var previousCulture: String? = "", // имя предыдущей культуры
    var area: Float? = -1.0F, // площадь поля
    var yeild: Float? = -1.0F, // урожайность
    @Min(0)
    var snowCover: Float? = -1.0F, // средняя толщина снежного покрова
    @Min(0)
    @Max(100)
    var fildIllnes: Float? = -1.0F, // поражение болезнью растений
    @Min(0)
    @Max(100)
    var fildWeed: Float? = -1.0F // поражение сорняками
)