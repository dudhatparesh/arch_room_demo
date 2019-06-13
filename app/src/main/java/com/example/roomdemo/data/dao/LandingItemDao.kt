package com.example.roomdemo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.roomdemo.data.model.LandingItem

@Dao
interface LandingItemDao {
    @Insert
    fun add(landingItem: LandingItem)
}