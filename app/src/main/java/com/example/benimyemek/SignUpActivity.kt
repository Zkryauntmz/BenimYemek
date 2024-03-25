package com.example.benimyemek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignUpActivity : AppCompatActivity() {

    private  lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = Firebase.auth
        val girisText : TextView = findViewById(R.id.textViewZaten)

        girisText.setOnClickListener {
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }

        val kayitButton : Button = findViewById(R.id.buttonGiris2)
        kayitButton.setOnClickListener {
            kayitOl()
        }


    }

    private fun kayitOl(){

        val email = findViewById<EditText>(R.id.editTextKisiName2)
        val password = findViewById<EditText>(R.id.editTextTextPassword2)

        val inputEmail = email.text.toString()
        val inputPass = password.text.toString()
        if (email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this,"Lutfen Alanları Bos Bırakmayınız !! ", Toast.LENGTH_LONG).show()
            return
        }else{

        auth.createUserWithEmailAndPassword(inputEmail,inputPass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful){
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"Kayıt Olusturuldu Lutfen Giriş Yapın ", Toast.LENGTH_LONG).show()

                } else{

                    Toast.makeText(this,"Kayıt Başarısız", Toast.LENGTH_SHORT).show()
                }




            }.addOnFailureListener{
                Toast.makeText(this,"Olusurken Hata ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
    } }
}