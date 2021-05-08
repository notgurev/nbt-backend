package nbt.hack.nbtbackend.util

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder

val AUTH_CONTEXT: Authentication
    get() = SecurityContextHolder.getContext().authentication