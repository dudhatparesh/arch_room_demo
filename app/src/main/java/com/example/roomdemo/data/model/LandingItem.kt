package com.example.roomdemo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "landing_item")
data class LandingItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?=null,

    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "login")
    val login: String,
    @ColumnInfo(name = "quick_links")
    val quickLinks: String,
    @ColumnInfo(name = "get_started")
    val getStarted: String

)