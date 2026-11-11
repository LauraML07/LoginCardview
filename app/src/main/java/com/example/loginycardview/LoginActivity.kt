package com.example.loginycardview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    private lateinit var editUsuario: EditText
    private lateinit var editPass: EditText
    private lateinit var btnValidar: Button
    private val MYUSER = "admin"
    private val MYPASS = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editUsuario = findViewById(R.id.edit_usuario)
        editPass = findViewById(R.id.edit_pass)
        btnValidar = findViewById(R.id.btnValidar)

        initEvent()
    }

    private fun initEvent() {
        btnValidar.setOnClickListener {
            val inputUser = editUsuario.text.toString()
            val inputPass = editPass.text.toString()

            if (inputUser == MYUSER && inputPass == MYPASS) {
                val intent = Intent(this, PrincipalActivity::class.java).apply {
                    putExtra("USER_KEY", inputUser)
                    putExtra("PASS_KEY", inputPass)
                }
                startActivity(intent)
                finish()
            } else {
                showMSG("Usuario o contraseña incorrectos")
            }
        }
    }

    private fun showMSG(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}