package edu.quinnipiac.ser210.stackd.api

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercises")
    fun getAll(): kotlinx.coroutines.flow.Flow<List<Exercise>>

    @Query("SELECT * FROM exercises WHERE isFavorited = 1")
    fun getFavorites(): kotlinx.coroutines.flow.Flow<List<Exercise>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(exercises: List<Exercise>)

    @Query("UPDATE exercises SET isFavorited = :isFav WHERE id = :id")
    suspend fun toggleFavorite(id: Int, isFav: Boolean)
}
