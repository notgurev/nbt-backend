package nbt.hack.nbtbackend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
data class Soil(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1,
    var type: String? = null, // тип почвы
    @Min(0) @Max(100)
    var wet: Float? = null, // содержание влаги в почве %
    var deepOfRootSystem: Float? = null, // Максимальная глубина корневой системы культуры
    @Min(0) @Max(100)
    var nitrogen: Float? = null, // содержание азота
    @Min(0) @Max(100)
    var phosphorus: Float? = null, // содержание фосфора
    @Min(0) @Max(100)
    var potassium: Float? = null, // содержание калия
    var earthTemperature: Float? = null, // температура почвы
)
