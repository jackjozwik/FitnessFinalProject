package project.st991281499.jack.data

import android.content.Context
import androidx.room.*

@Database(entities = [Cardio::class, Strength::class], version = 1, exportSchema = false)
abstract class FitnessRoomDatabase : RoomDatabase() {

    abstract fun cardioDao(): CardioDAO
    abstract fun strengthDao(): StrengthDAO

    companion object {
        @Volatile
        private var INSTANCE: FitnessRoomDatabase? = null

        fun getDatabase(context: Context): FitnessRoomDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FitnessRoomDatabase::class.java,
                    "fitness_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }

}