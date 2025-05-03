package edu.quinnipiac.ser210.stackd.api

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.quinnipiac.ser210.stackd.network.ApiService
//mport android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
//@Database(entities = [Exercise::class], version = 2, exportSchema = true)
//abstract class AppDatabase : RoomDatabase() {
//  abstract fun exerciseDao(): ExerciseDao
//
//
//
//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        const val DATABASE_NAME = "exercise_database"
//        fun getDatabase(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    DATABASE_NAME
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//
//
//}
@Database(
    entities = [Exercise::class],
    version = 3,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        private const val DATABASE_NAME = "exercise_database"

        /* ---------- 1 ➜ 2 ---------- */
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // add column only if it’s missing (safe re-run)
                val c = db.query("PRAGMA table_info(exercises)")
                var has = false
                while (c.moveToNext()) if (c.getString(1) == "isFavorited") { has = true; break }
                c.close()
                if (!has) {
                    db.execSQL(
                        """
                        ALTER TABLE exercises
                        ADD COLUMN isFavorited INTEGER NOT NULL DEFAULT 0
                        """.trimIndent()
                    )
                }
            }
        }

        /* ---------- 2 ➜ 3 ---------- */
        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // -- currently no schema change from 2 → 3;
                // you can leave this empty or add future tweaks here.
            }
        }

        fun getDatabase(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3)  // ← ORDER MATTERS
                    // .fallbackToDestructiveMigration()          // dev-only
                    .build()
                    .also { INSTANCE = it }
            }
    }
}
