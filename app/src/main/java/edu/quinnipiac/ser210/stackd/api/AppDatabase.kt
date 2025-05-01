package edu.quinnipiac.ser210.stackd.api

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.quinnipiac.ser210.stackd.network.ApiService

@Database(entities = [Exercise::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
  abstract fun exerciseDao(): ExerciseDao



    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        const val DATABASE_NAME = "exercise_database"
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


}