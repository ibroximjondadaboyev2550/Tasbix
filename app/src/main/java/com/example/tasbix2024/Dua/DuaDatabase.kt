package com.example.tasbix2024.Dua

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Dua::class], version = 1)
abstract class DuaDatabase : RoomDatabase() {
    abstract fun duaDao(): DuaDao

    companion object {
        @Volatile
        private var INSTANCE: DuaDatabase? = null

        fun getDatabase(context: Context): DuaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DuaDatabase::class.java,
                    "dua_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
