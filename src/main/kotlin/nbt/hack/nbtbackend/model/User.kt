package nbt.hack.nbtbackend.model

import lombok.Data
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "accounts")
class User {
    @Id
    private var username: String? = null
    private var password: String? = null

    fun User() {}
}