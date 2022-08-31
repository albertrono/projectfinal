package com.example.tokea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()


        Handler().postDelayed(Runnable {
            startActivity(Intent(this@MainActivity, NoAuthActivity::class.java))
            finish()
        }, 3000)
    }
}


//        Handler().postDelayed(Runnable{
//            startActivity(Intent(this@MainActivity,NoAuthActivity::class.java))
//        },3000)

//
//        Handler().postDelayed({
//            val intent = Intent(this,NoAuthActivity::class.java)
//            startActivity(intent)
//            finish()
//        },1500)
//
//        }
//
//
//        }



//        Handler().postDelayed(Runnable {
//            firebaseAuth= FirebaseAuth.getInstance()
//            checkUser()
//        },3000)
//
//    }
//
//    private fun checkUser() {
//        val firebaseUser =firebaseAuth.currentUser
//        if (firebaseUser == null){
//            startActivity(Intent(this,MainActivity::class.java))
//            finish()
//        }else{
//
//            val ref= FirebaseDatabase.getInstance().getReference("Users")
//            ref.child(firebaseUser.uid)
//                .addListenerForSingleValueEvent(object : ValueEventListener {
//                    override fun onDataChange(snapshot: DataSnapshot) {
//
//
//                        val userType=snapshot.child("Users").value
//                        if (userType == "user"){
//                            startActivity(Intent(this@MainActivity,NoAuthActivity::class.java))
//                            finish()
//                        }
//                        if (userType == "user"){
//                            startActivity(Intent(this@MainActivity,NoAuthActivity::class.java))
//                            finish()
//                        }
//                    }
//                    override fun onCancelled(error: DatabaseError) {
//
//                    }
//
//
//                })
//        }
//    }
//}