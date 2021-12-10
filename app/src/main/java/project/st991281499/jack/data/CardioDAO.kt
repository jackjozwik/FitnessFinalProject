package project.st991281499.jack.data

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CardioDAO {

    @Query("SELECT * from cardio")
    fun getItems(): LiveData<List<Cardio>>

    @Query("SELECT * from cardio WHERE id = :id")
    fun getItem(id: Int): LiveData<Cardio>

    @Query("SELECT * FROM cardio WHERE exerciseType = :selection")
    fun getExerciseType(selection: String): LiveData<List<Cardio>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(cardio: Cardio): Long

    @Update
    fun update(cardio: Cardio)

    @Delete
    fun delete(cardio: Cardio)

}