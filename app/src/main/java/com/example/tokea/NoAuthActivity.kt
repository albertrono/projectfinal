package com.example.tokea

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.tokea.databinding.ActivityNoAuthBinding

class NoAuthActivity :AppCompatActivity() {

//    private lateinit var binding: ActivityNoAuthBinding

    lateinit var login: Button
    lateinit var signup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_auth)

//        binding = ActivityNoAuthBinding.inflate(layoutInflater)
        //      setContentView(binding.root)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        login = findViewById(R.id.btn_login)
        login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        signup = findViewById(R.id.btn_signup)
        signup.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

//        binding.btnSignup.setOnClickListener {
//            val intent = Intent(this, RegisterActivity::class.java)
//            startActivity(Intent(this@NoAuthActivity, RegisterActivity::class.java))
//            finish()
//        }
//
//        binding.btnLogin.setOnClickListener {
//            val kienyeji = Intent(this, LoginActivity::class.java)
//            startActivity(Intent(this@NoAuthActivity, LoginActivity::class.java))
//            finish()
//        }

//    }

//}