package project.st991281499.jack.data

import androidx.room.*
import java.util.*

@Entity
data class Strength (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "exerciseType")
    val exerciseType: String,

    @ColumnInfo(name = "datetime")
    val datetime: String,

    @ColumnInfo(name = "sets")
    val sets: String,

    @ColumnInfo(name = "reps")
    val reps: String

)