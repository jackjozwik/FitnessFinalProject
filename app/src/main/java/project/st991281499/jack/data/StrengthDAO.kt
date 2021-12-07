package project.st991281499.jack.data

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface StrengthDAO {

    @Query("SELECT * from strength ORDER BY exerciseType ASC")
    fun getItems(): LiveData<List<Strength>>

    @Query("SELECT * from strength WHERE id = :id")
    fun getItem(id: Int): LiveData<Strength>

    @Query("SELECT * FROM strength WHERE exerciseType = :selection")
    fun getExerciseType(selection: String): LiveData<List<Strength>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(strength: Strength): Long

    @Update
    fun update(strength: Strength)

    @Delete
    fun delete(strength: Strength)

}