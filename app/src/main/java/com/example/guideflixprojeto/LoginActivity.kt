package com.example.guideflixprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        window.statusBarColor = 0xFF373435.toInt()

        val botao: Button = findViewById(R.id.btnCadastroLogin)
        botao.setOnClickListener {
            val intent = Intent(this@LoginActivity, CadastroActivity::class.java)
            startActivity(intent)
        }

        val botao2: Button = findViewById(R.id.btEntrar)
        botao2.setOnClickListener {
            val intent = Intent(this@LoginActivity, AppActivity::class.java)
            startActivity(intent)
        }
    }
}