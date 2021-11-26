package project.st991281499.jack

import android.app.Application
import project.st991281499.jack.data.FitnessRoomDatabase

class FitnessApplication : Application() {
    val database: FitnessRoomDatabase by lazy { FitnessRoomDatabase.getDatabase(this) }
}