package com.devmob.minhagrade

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.devmob.minhagrade.Model.RootRoot
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_new_course.*

class NewCourseActivity : AppCompatActivity() {

    var database:FirebaseDatabase = FirebaseDatabase.getInstance()
    var myRef:DatabaseReference = database.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_course)
//
//        val colors = arrayOf("Red", "Green", "Blue", "Yellow", "Black", "Crimson", "Orange")
//
//        val adapter = ArrayAdapter(
//                this,
//                android.R.layout.simple_spinner_item,
//                colors
//        )

        loadCourses()
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
//
//        spinner.adapter = adapter
    }

    fun loadCourses(){
        myRef.child("cursos")
                .addValueEventListener(object :ValueEventListener{
                    override fun onCancelled(p0: DatabaseError) {

                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        Log.d("ooo",p0.toString())
                    }
                })
    }
}
