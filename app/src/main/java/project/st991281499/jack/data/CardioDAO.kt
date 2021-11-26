package project.st991281499.jack.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CardioDAO {

    @Query("SELECT * from cardio ORDER BY exerciseType ASC")
    fun getItems(): Flow<List<Cardio>>

    @Query("SELECT * from cardio WHERE id = :id")
    fun getItem(id: Int): Flow<Cardio>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cardio: Cardio)

    @Update
    suspend fun update(cardio: Cardio)

    @Delete
    suspend fun delete(cardio: Cardio)

}