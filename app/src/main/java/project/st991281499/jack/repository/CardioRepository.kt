package project.st991281499.jack.repository

import androidx.lifecycle.LiveData
import project.st991281499.jack.data.Cardio
import project.st991281499.jack.data.CardioDAO
import project.st991281499.jack.data.Strength


class CardioRepository(private val cardioDAO: CardioDAO) {

    val readAllCardioData:LiveData<List<Cardio>> = cardioDAO.getItems()

    fun readData(exerciseType: String): LiveData<List<Cardio>>{
        return cardioDAO.getExerciseType(exerciseType)
    }

    fun addCardio(cardio: Cardio): Long{
        return cardioDAO.insert(cardio)
    }

    fun updateCardio(cardio: Cardio){
        return cardioDAO.update(cardio)
    }

    fun deleteCardio(cardio: Cardio){
        return cardioDAO.delete(cardio)
    }

}