package com.example.loginycardview

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PrincipalActivity : AppCompatActivity() {
    private lateinit var tvBienvenida: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvBienvenida = findViewById(R.id.tvBienvenida)

        if (intent != null && intent.hasExtra("USER_KEY") && intent.hasExtra("PASS_KEY")) {
            val usuario = intent.getStringExtra("USER_KEY")
            val password = intent.getStringExtra("PASS_KEY")

            tvBienvenida.text = "Bienvenido: $usuario\nTu contraseña es: $password"
        }
    }
}