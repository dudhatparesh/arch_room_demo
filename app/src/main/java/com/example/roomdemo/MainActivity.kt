package com.example.roomdemo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.example.roomdemo.data.AppDatabase
import com.example.roomdemo.data.model.LandingItem
import com.example.roomdemo.model.LandingFileItem
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    lateinit var appDatabase: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appDatabase = AppDatabase.getInstance(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
                view ->

            Handler(Looper.myLooper()).post{
                Thread {

                    val inputStreamReader = InputStreamReader(assets.open("dummydata/data.json"))
                    val landingFileItem = Gson().fromJson<LandingFileItem>(inputStreamReader,LandingFileItem::class.java)



                    val landingItem = LandingItem(title= landingFileItem.languageTitle,login=landingFileItem.languageLogin,
                        quickLinks = landingFileItem.languageQuickStart,getStarted =landingFileItem.languageGetStarted)
                    appDatabase.landingItemDao().add(landingItem)
                }.start()

            }

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
