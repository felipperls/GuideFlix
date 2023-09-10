package com.example.guideflixprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = 0xFF373435.toInt()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, TelaInicioActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

    }
}