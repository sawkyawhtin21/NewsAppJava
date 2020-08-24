package com.skh.firebasedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.PhantomReference

class MainActivity : AppCompatActivity() {

    lateinit var dbReference: DatabaseReference
    lateinit var firebaseDatabase: FirebaseDatabase
    private var userId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseDatabase = FirebaseDatabase.getInstance()
        dbReference = firebaseDatabase.getReference("user")
        userId = dbReference.push().key.toString()

        btn1.setOnClickListener {  // instance build
            if (TextUtils.isEmpty(userId)) {
           //     createUser(editname.text.toString(), edittwo.text.toString())
                var name: String = editname.text.toString()
                var mobile: String = edittwo.text.toString()
                createUser(name,mobile)
            } else {
                updateUser(editname.text.toString(), edittwo.text.toString())
            }
        }
    }

    fun createUser(name: String, mobile: String) {
        val user = User(name, mobile)
        dbReference.child(userId).setValue(user)

    }

    fun updateUser(name: String, mobile: String) {
        val user = User(name, mobile)
        if (!TextUtils.isEmpty(name)) {
            dbReference.child(userId).child(name).setValue(name)
        }
        if (!TextUtils.isEmpty(mobile)) {
            dbReference.child(userId).child(mobile).setValue(mobile)
        }
        dbReference.child(userId).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var user = snapshot.getValue(User::class.java)
                editname.setText(user?.name)
                edittwo.setText(user?.mobile)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}

