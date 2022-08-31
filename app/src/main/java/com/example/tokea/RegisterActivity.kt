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
import com.example.tokea.databinding.ActivityRegisterBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {


    lateinit var signUp: Button

    lateinit var pass: TextInputEditText
    lateinit var email: TextInputEditText


    private lateinit var firebase: FirebaseAuth

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        email=findViewById(R.id.inputEmail)
        pass=findViewById(R.id.inputPassword)
        signUp=findViewById(R.id.btn_register)

        var mAuth = FirebaseAuth.getInstance()

        signUp.setOnClickListener {
            val email = email.text.toString()
            val password = pass.text.toString()

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener
                    Log.d("SIGN UP", "Your account has been created successfully")
                    val intent = Intent(this, Home::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed to create account\n" + "Email id already in use", Toast.LENGTH_SHORT)
                        .show()
                }
        }
    }
}


 //       setContentView(R.layout.activity_register)

//        binding = ActivityRegisterBinding.inflate(layoutInflater)
//        setContentView(binding.root)

//        firebaseAuth = FirebaseAuth.getInstance()

//        progressDialog = ProgressDialog(this)
//        progressDialog.setTitle("please wait")
//        progressDialog.setCanceledOnTouchOutside(false)
//
//        binding.btnRegister.setOnClickListener {
//            validateData()
//        }
//
//        binding.btnGotoLogin.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
//    }
//
//    private var name = ""
//    private var email = ""
//    private var password = ""
//
//    private fun validateData() {
//        name = binding.inputUsername.text.toString().trim()
//        email = binding.inputEmail.text.toString().trim()
//        password = binding.inputPassword.text.toString().trim()
//        val cpassword = binding.ConfirmPassword.text.toString().trim()
//
//        if (name.isEmpty()) {
//            Toast.makeText(this, "Input Username..", Toast.LENGTH_SHORT).show()
//        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            Toast.makeText(this, "Invalid email account!", Toast.LENGTH_SHORT).show()
//        } else if (password.isEmpty()) {
//            Toast.makeText(this, "Enter password..", Toast.LENGTH_SHORT).show()
//        } else if (cpassword.isEmpty()) {
//            Toast.makeText(this, "Confirm password..", Toast.LENGTH_SHORT).show()
//        } else if (cpassword != password) {
//            Toast.makeText(this, "Password don't match!", Toast.LENGTH_SHORT).show()
//        } else {
//            createUserAccount()
//        }
//    }
//
//    private fun createUserAccount() {
//        progressDialog.setMessage("Creating account...")
//        progressDialog.show()
//
//        firebase.createUserWithEmailAndPassword(email, password)
//            .addOnSuccessListener {
//                updateUserInfo()
//            }
//            .addOnFailureListener { e ->
//                progressDialog.dismiss()
//                Toast.makeText(
//                    this, "failed to create account due to ${e.message}", Toast.LENGTH_SHORT
//                ).show()
//            }
//    }
//
//    private fun updateUserInfo() {
//        progressDialog.setMessage("saving user info...")
//        val timestamp = System.currentTimeMillis()
//        val uid = firebase.uid
//
//        val hashMap:HashMap<String,Any?> = HashMap()
//        hashMap["uid"] = uid
//        hashMap["email"] = email
//        hashMap["name"] = name
//        hashMap["profile image"] = ""
//        hashMap["timestamp"] = timestamp
//
//        startActivity(Intent(this@RegisterActivity,Home::class.java))
//               finish()
//
//}
//}
//
//        val ref= FirebaseDatabase.getInstance().getReference("Users")
//        ref.child(uid!!)
//            .setValue(hashMap)
//            .addOnSuccessListener {
//                progressDialog.dismiss()
//                Toast.makeText(this, "Account created...", Toast.LENGTH_SHORT
//                ).show()
//                startActivity(Intent(this@RegisterActivity,Home::class.java))
//                finish()
//            }
//
//            .addOnFailureListener {e->
//                progressDialog.dismiss()
//                Toast.makeText(this, "Failed to save user info due to ${e.message}", Toast.LENGTH_SHORT
//                ).show()
//            }
//
//    }
//}