package project.st991281499.jack

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import project.st991281499.jack.data.Cardio
import project.st991281499.jack.data.CardioDAO
import java.util.*

class CardioViewModel(private val cardioDao: CardioDAO) : ViewModel() {

    fun addNewCardio(exerciseType: String, datetime: String, duration: String) {
        val newCardio = getNewCardioEntry(exerciseType, datetime, duration)
        insertCardio(newCardio)
    }

    private fun insertCardio(cardio: Cardio) {
        viewModelScope.launch {
            cardioDao.insert(cardio)
        }
    }

    fun isEntryValid(exerciseType: String, datetime: String, duration: String): Boolean {
        if (exerciseType.isBlank() || datetime.isBlank() || duration.isBlank()) {
            return false
        }
        return true
    }

    private fun getNewCardioEntry(exerciseType: String, datetime: String, duration: String): Cardio {
        return Cardio(
            exerciseType = exerciseType,
            datetime = datetime,
            duration = duration
        )
    }

}

class CardioViewModelFactory(private val cardioDao: CardioDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardioViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CardioViewModel(cardioDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}