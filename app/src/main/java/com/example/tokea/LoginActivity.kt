package com.example.tokea

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.tokea.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.sign

class LoginActivity : AppCompatActivity() {

    lateinit var login_btn: Button

    lateinit var forgot_pass: TextView
    lateinit var email: TextInputEditText
    lateinit var password: TextInputEditText
    private lateinit var binding: ActivityLoginBinding

    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_btn=findViewById(R.id.btn_login)
        forgot_pass=findViewById(R.id.forgot_pass)
        email=findViewById(R.id.email)
        password=findViewById(R.id.password)

        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {

            login_btn.setOnClickListener {
                val email = email.text.toString()
                val password = password.text.toString()
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (!it.isSuccessful) return@addOnCompleteListener

                        Log.d("login", "successful")
                        intent = Intent(this, Home::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "login failure", Toast.LENGTH_SHORT).show()
                    }
            }

            }

            forgot_pass.setOnClickListener {
                intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
        }



    }


