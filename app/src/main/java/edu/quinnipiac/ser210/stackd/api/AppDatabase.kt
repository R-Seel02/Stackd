package edu.quinnipiac.ser210.stackd.api

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Exercise::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao

    companion object {
        const val DATABASE_NAME = "exercise_database"
    }

    // Singleton instance of the database
    @Volatile
    private var INSTANCE: AppDatabase? = null
    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            ).build()
            INSTANCE = instance
            instance
        }
    }
}