package project.st991281499.jack.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface StrengthDAO {

    @Query("SELECT * from strength ORDER BY exerciseType ASC")
    fun getItems(): Flow<List<Strength>>

    @Query("SELECT * from strength WHERE id = :id")
    fun getItem(id: Int): Flow<Strength>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(strength: Strength)

    @Update
    suspend fun update(strength: Strength)

    @Delete
    suspend fun delete(strength: Strength)

}