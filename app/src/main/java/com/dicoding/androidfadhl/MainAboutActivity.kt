package com.dicoding.androidfadhl

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainAboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_about)

        val pembuatDetailName = findViewById<TextView>(R.id.namapembuat)
        val pembuatEmail = findViewById<TextView>(R.id.emailpembuat)

        val namaPembuat = resources.getString(R.string.name)
        val emailPembuat= resources.getString(R.string.bangkitemail)

        pembuatDetailName.text = namaPembuat
        pembuatEmail.text = emailPembuat
    }
}