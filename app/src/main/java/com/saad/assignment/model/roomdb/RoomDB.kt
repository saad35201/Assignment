package com.saad.assignment.model.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saad.assignment.model.models.ResultsItem
import com.saad.assignment.utils.Constants

@Database(entities = [ResultsItem::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(context: Context): RoomDB {
            if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        RoomDB::class.java,
                        Constants.DATABASE_NAME
                    ).build()
            }
            return INSTANCE!!
        }
    }

}