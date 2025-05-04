package edu.quinnipiac.ser210.stackd.api
import androidx.room.Entity
import androidx.room.Ignore

import androidx.room.PrimaryKey
import kotlinx.serialization.descriptors.PrimitiveKind



@Entity(tableName = "exercises")
data class Exercise(
    @PrimaryKey val id: Int,
    val name: String,
    val bodyPart: String?,
    val equipment: String?,
    val target: String?,
    val gifUrl: String?,

    val exercises: List<String>? = emptyList(),   // ← make it `?`
    val isFavorited: Boolean = false
)


