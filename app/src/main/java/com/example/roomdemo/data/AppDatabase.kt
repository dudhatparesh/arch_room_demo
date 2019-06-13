package com.example.roomdemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdemo.data.dao.LandingItemDao
import com.example.roomdemo.data.model.LandingItem

@Database(entities = [LandingItem::class], version = 1)
abstract  class AppDatabase: RoomDatabase() {
    abstract fun landingItemDao(): LandingItemDao
    companion object{
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase{
            if(INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context,AppDatabase::class.java,"main.db").build()
                }
            }
            return INSTANCE!!
        }
    }
}