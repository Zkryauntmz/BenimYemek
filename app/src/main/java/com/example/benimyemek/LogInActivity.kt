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

class LogInActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityLogInBinding

    private  lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        auth = Firebase.auth
        val kayitText : TextView = findViewById(R.id.textViewUyeOl)
        val resetPass : TextView = findViewById(R.id.textViewSifreUnut2)
        kayitText.setOnClickListener {
            val intent  = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        resetPass.setOnClickListener {
            val intent  = Intent(this,SifreUnuttumActivity::class.java)
            startActivity(intent)
        }


        val girisButton : Button = findViewById(R.id.buttonGiris2)

        girisButton.setOnClickListener {
            girisYap()
        }



    }


    private fun girisYap(){
        val email : EditText = findViewById(R.id.editTextEmail)
        val password : EditText = findViewById(R.id.editTextTextPassword2)
        if (email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this,"Lutfen Alanları Bos Bırakmayınız !! ", Toast.LENGTH_LONG).show()
            return
        } else {
            val emailInput = email.text.toString()
            val passInput = password.text.toString()

            auth.signInWithEmailAndPassword(emailInput, passInput)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful){
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this,"Anasayfa ya Yönlendiriliyorsunuz", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this,"Giris Basarısız !! ", Toast.LENGTH_LONG).show()
                    }
                }

            }
        }
    }
