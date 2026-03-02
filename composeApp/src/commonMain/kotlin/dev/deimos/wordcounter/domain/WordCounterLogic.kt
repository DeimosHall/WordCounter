package dev.deimos.wordcounter.domain

class WordCounterLogic {
    fun getWordsCounting(text: String): Int {
        return text.split(Regex("\\s+")).filter { it.isNotBlank() }.size
    }

    fun getLinesCounting(text: String): Int {
        return text.split(Regex("\\r?\\n")).filter { it.isNotBlank() }.size
    }

    fun getCharactersCounting(text: String): Int {
        return text.length
    }
}