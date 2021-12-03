package project.st991281499.jack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import project.st991281499.jack.data.CardioDAO
import project.st991281499.jack.data.Strength
import java.util.*
import project.st991281499.jack.data.StrengthDAO


class StrengthViewModel(private val strengthDao: StrengthDAO) : ViewModel() {

    private fun insertStrengthEntry(strength: Strength){
        viewModelScope.launch {
            strengthDao.insert(strength)
        }
    }

    fun addNewStrength(exerciseType: String, datetime: String, sets: String, reps: String){
        val newStrength = getNewStrengthEntry(exerciseType, datetime, sets, reps)
        insertStrengthEntry(newStrength)
    }

    fun isEntryValid(exerciseType: String, datetime: String, sets: String, reps: String): Boolean {
        if (exerciseType.isBlank() || datetime.isBlank() || sets.isBlank() || reps.isBlank()) {
            return false
        }
        return true
    }

    private fun getNewStrengthEntry(exerciseType: String, datetime: String, sets: String, reps: String): Strength {
        return Strength(
            exerciseType = exerciseType,
            datetime = datetime,
            sets = sets,
            reps = reps
        )
    }
}

class StrengthViewModelFactory(private val strengthDao: StrengthDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StrengthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StrengthViewModel(strengthDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}