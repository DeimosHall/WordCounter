package dev.deimos.wordcounter.ui.viewmodel

import androidx.lifecycle.ViewModel
import dev.deimos.wordcounter.domain.WordCounterLogic
import dev.deimos.wordcounter.ui.state.TextState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WordCounterViewModel: ViewModel() {
    private val wordCounterLogic = WordCounterLogic()
    private val _uiState = MutableStateFlow(TextState())
    val uiState = _uiState.asStateFlow()

    fun updateText(newText: String) {
        _uiState.update { currentState ->
            currentState.copy(
                text = newText,
                charCount = wordCounterLogic.getCharactersCounting(newText),
                wordsCount = wordCounterLogic.getWordsCounting(newText),
                linesCount = wordCounterLogic.getLinesCounting(newText)
            )
        }
    }

    fun clear() {
        _uiState.update { TextState() }
    }
}