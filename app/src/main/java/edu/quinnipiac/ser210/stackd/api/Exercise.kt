package edu.quinnipiac.ser210.stackd.api
import androidx.room.Entity

import androidx.room.PrimaryKey


@Entity(tableName = "exercises")

data class Exercise(
    @PrimaryKey val id: Int,
                     val name: String,
                     val exercises: String,
                     val targetList: String,
                     val equipment: String?,
                     val bodyPart: String,
                     val target: String,
                     val gifUrl: String?,
                     val isFavorited: Boolean = false
    )

