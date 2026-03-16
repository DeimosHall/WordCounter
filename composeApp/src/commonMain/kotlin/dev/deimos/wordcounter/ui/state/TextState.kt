package dev.deimos.wordcounter.ui.state

data class TextState(
    val text: String = "",
    val charCount: Int = 0,
    val wordsCount: Int = 0,
    val linesCount: Int = 0
)
