package com.example.guideflixprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TelaInicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicio)

        window.statusBarColor = 0xFF373435.toInt()

        val botao: Button = findViewById(R.id.btnlogin)
        botao.setOnClickListener {
            val intent = Intent(this@TelaInicioActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        val botao2: Button = findViewById(R.id.btnCadastro)
        botao2.setOnClickListener {
            val intent = Intent(this@TelaInicioActivity, CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}