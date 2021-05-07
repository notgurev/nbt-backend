package nbt.hack.nbtbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NbtBackendApplication

fun main(args: Array<String>) {
    runApplication<NbtBackendApplication>(*args)
}
