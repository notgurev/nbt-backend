package nbt.hack.nbtbackend.model

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
data class User(
        @Id
        var username: String? = null,
        var password: String? = null,
        var isExpert: Boolean = false
)