package nbt.hack.nbtbackend.util

import java.util.*

val <T> Optional<T>.maybeValue: T?
    get() = this.orElse(null)
