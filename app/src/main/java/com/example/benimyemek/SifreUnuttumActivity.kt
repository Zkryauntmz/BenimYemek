package com.example.benimyemek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SifreUnuttumActivity : AppCompatActivity() {
    private lateinit var etPassword : EditText
    private lateinit var buttonReset : Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sifre_unuttum)

        etPassword = findViewById(R.id.editTextKisiName2)
        buttonReset = findViewById(R.id.button)

        auth = FirebaseAuth.getInstance()

        buttonReset.setOnClickListener {

            val sPassword = etPassword.text.toString()

            auth.sendPasswordResetEmail(sPassword).addOnSuccessListener {
                Toast.makeText(this,"Sifre Sıfırlama Maili Adresinize Gonderilmiştir", Toast.LENGTH_SHORT).show()
                val intent  = Intent(this,LogInActivity::class.java)
                startActivity(intent)

            }.addOnFailureListener{
                Toast.makeText(this,"Boyle bir mail adresi bulunamadı !!", Toast.LENGTH_SHORT).show()
            }


        }

    }
}