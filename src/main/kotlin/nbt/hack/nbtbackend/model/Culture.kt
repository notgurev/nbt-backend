package nbt.hack.nbtbackend.model

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "cultures")
data class Culture(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1,
    var variety: String? = null, // сорт
    @PositiveOrZero
    var height: Float? = null, // высота растения
    @Min(0) @Max(100)
    var coverage: Float? = null, // проектное покрытие
    @Min(0) @Max(100)
    var dryTerrestrialPhytomass: Float? = null, // значение сухой наземной фитомассы
    @Min(0) @Max(100)
    var moistureAbsorption: Float? = null, // параметры поглощения влаги
    var evapotranspiration: Float? = null, // эвапотранспирация
    var ph: Float? = null, // благоприятный pH для культуры
    var sowingTime: LocalDateTime? = null, // дата посева
    var collectionTime: LocalDateTime? = null, // дата сбора урожая
)
