package com.dicoding.androidfadhl

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMadrid: RecyclerView
    private val list = ArrayList<Madrid>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        rvMadrid = findViewById(R.id.rv_madrid)
        rvMadrid.setHasFixedSize(true)

        list.addAll(getListMadrid())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListMadrid(): ArrayList<Madrid> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Madrid>()
        for (i in dataName.indices) {
            val hero = Madrid(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvMadrid.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListMadridAdapter(list)
        rvMadrid.adapter = listHeroAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                startActivity(Intent(this@MainActivity, MainAboutActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}