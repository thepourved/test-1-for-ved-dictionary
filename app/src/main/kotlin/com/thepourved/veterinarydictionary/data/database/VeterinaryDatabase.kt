package com.thepourved.veterinarydictionary.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thepourved.veterinarydictionary.data.dao.WordDao
import com.thepourved.veterinarydictionary.data.entity.Word

@Database(
    entities = [Word::class],
    version = 1,
    exportSchema = false
)
abstract class VeterinaryDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: VeterinaryDatabase? = null

        fun getDatabase(context: Context): VeterinaryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VeterinaryDatabase::class.java,
                    "veterinary_dictionary.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}