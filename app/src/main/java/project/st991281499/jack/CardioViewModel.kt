package project.st991281499.jack

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import project.st991281499.jack.data.Cardio
import project.st991281499.jack.data.CardioDAO

class CardioViewModel(private val cardioDao: CardioDAO) : ViewModel() {

    val allExercises: LiveData<List<Cardio>> = cardioDao.getItems().asLiveData()

    fun retrieveItem(id: Int): LiveData<Cardio> {
        return cardioDao.getItem(id).asLiveData()
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