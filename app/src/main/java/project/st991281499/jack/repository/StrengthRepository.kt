package project.st991281499.jack.repository

import androidx.lifecycle.LiveData
import project.st991281499.jack.data.Strength
import project.st991281499.jack.data.StrengthDAO

class StrengthRepository(private val strengthDAO: StrengthDAO) {

    val readAllStrengthData:LiveData<List<Strength>> = strengthDAO.getItems()
    //val readExerciseData: LiveData<List<Strength>> = strengthDAO.getExerciseType(exerciseType)

    fun readData(exerciseType: String): LiveData<List<Strength>>{
        return strengthDAO.getExerciseType(exerciseType)
    }

    fun addStrength(strength: Strength): Long{
        return strengthDAO.insert(strength)
    }

    fun updateBucket(strength: Strength){
        strengthDAO.update(strength)
    }

}