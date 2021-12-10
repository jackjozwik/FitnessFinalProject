package project.st991281499.jack

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import project.st991281499.jack.data.*
import project.st991281499.jack.repository.CardioRepository
import project.st991281499.jack.repository.StrengthRepository
import java.util.*

class CardioViewModel(application: Application) : AndroidViewModel(application) {

    val cardioDao: CardioDAO = FitnessRoomDatabase.getDatabase(application).cardioDao()
    val repository: CardioRepository
    val getCardio: LiveData<List<Cardio>>

    init {
        repository = CardioRepository(cardioDao)
        getCardio = repository.readAllCardioData
    }

    fun readCardio(exerciseType: String) :LiveData<List<Cardio>>{
        return repository.readData(exerciseType)
    }

    fun insertCardioEntry(cardio: Cardio){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCardio(cardio)
        }
    }
    fun updateCardioEntry(cardio: Cardio){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateCardio(cardio)
        }
    }
    fun deleteCardioEntry(cardio: Cardio){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteCardio(cardio)
        }
    }


    fun isEntryValid(exerciseType: String, datetime: String, duration: String): Boolean {
        if (exerciseType.isBlank() || datetime.isBlank() || duration.isBlank()) {
            return false
        }
        return true
    }

}
