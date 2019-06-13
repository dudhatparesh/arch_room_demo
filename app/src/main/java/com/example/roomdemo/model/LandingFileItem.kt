package com.example.roomdemo.model

import com.google.gson.annotations.SerializedName

data class LandingFileItem(
    @SerializedName("language_title")
    val languageTitle: String,
    @SerializedName("language_login")
    val languageLogin: String,
    @SerializedName("language_quick_start")
    val languageQuickStart: String,
    @SerializedName("language_get_started")
    val languageGetStarted: String

)