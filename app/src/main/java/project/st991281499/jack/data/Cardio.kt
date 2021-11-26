package project.st991281499.jack.data

import androidx.room.*
import java.util.*

@Entity
data class Cardio (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "exerciseType")
    val exerciseType: String,

    @ColumnInfo(name = "datetime")
    val datetime: Date,

    @ColumnInfo(name = "duration")
    val duration: Date

)