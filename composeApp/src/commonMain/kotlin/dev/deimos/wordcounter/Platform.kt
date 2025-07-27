package dev.deimos.wordcounter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform