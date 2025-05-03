package edu.quinnipiac.ser210.stackd.api

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercises")
    fun getAll(): Flow<List<Exercise>>

    @Query("SELECT * FROM exercises WHERE isFavorited = 1")
    fun getFavorites(): Flow<List<Exercise>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(exercises: List<Exercise>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(exercise: Exercise)

    @Query("UPDATE exercises SET isFavorited = :isFav WHERE id = :id")
    suspend fun toggleFavorite(id: Int, isFav: Boolean): Int
}
