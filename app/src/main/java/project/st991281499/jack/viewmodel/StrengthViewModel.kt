package project.st991281499.jack.viewmodel

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import project.st991281499.jack.data.FitnessRoomDatabase
import project.st991281499.jack.data.Strength
import project.st991281499.jack.data.StrengthDAO
import project.st991281499.jack.repository.StrengthRepository


class StrengthViewModel(application: Application) : AndroidViewModel(application) {


    val strengthDao: StrengthDAO = FitnessRoomDatabase.getDatabase(application).strengthDao()
    val repository: StrengthRepository
    val getStrength: LiveData<List<Strength>>

    init {
        repository= StrengthRepository(strengthDao)
        getStrength = repository.readAllStrengthData
    }

    fun readStrength(exerciseType: String) :LiveData<List<Strength>>{
        return repository.readData(exerciseType)
    }

    fun insertStrengthEntry(strength: Strength){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addStrength(strength)
        }
    }

    fun isEntryValid(exerciseType: String, datetime: String, sets: String, reps: String): Boolean {
        if (exerciseType.isBlank() || datetime.isBlank() || sets.isBlank() || reps.isBlank()) {
            return false
        }
        return true
    }

}
