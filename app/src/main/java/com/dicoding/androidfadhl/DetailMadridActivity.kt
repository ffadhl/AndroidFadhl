package com.dicoding.androidfadhl

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailMadridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_madrid)

        val dataMadrid = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Madrid>("key_Madrid", Madrid::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Madrid>("key_Madrid")
        }

        val madridDetailName = findViewById<TextView>(R.id.detailpemain)
        val madridDetailDescription = findViewById<TextView>(R.id.detaildeskripsipemain)
        val madridDetailPhoto = findViewById<ImageView>(R.id.detailfotoplayer)

        madridDetailName.text = dataMadrid?.name ?: "Unknown Name!"
        madridDetailDescription.text = dataMadrid?.description ?: "No Data Description can be found!"
        madridDetailPhoto.setImageResource(dataMadrid?.photo ?: 0)
    }
}