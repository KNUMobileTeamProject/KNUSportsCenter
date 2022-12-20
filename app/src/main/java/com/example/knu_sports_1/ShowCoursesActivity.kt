package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.knu_sports_1.databinding.ActivityShowCoursesBinding
import com.example.knu_sports_1.databinding.ActivityShowFacilitiesBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.*
import com.google.firebase.ktx.Firebase

class ShowCoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityShowCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val refSessionUser = Firebase.database("https://mobliappteamproject-default-rtdb.asia-southeast1.firebasedatabase.app")
            .reference.child("usrs")
            .child(Firebase.auth.uid.toString())
            .child("applied_courses")

        val refCourses = Firebase.database("https://mobliappteamproject-default-rtdb.asia-southeast1.firebasedatabase.app")
            .reference.child("courses")
        var course_details = mutableListOf<String>()
        refSessionUser.addValueEventListener(object: ValueEventListener {
            val session_user_courses = arrayListOf<String>()
            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val session_user_courses = snapshot.getValue() as ArrayList<String>
                course_details.clear()

                for(serial_id in session_user_courses)
                {
                    refCourses.child(serial_id).addValueEventListener(object: ValueEventListener {

                       override fun onDataChange(snapshot: DataSnapshot) {
                            // This method is called once with the initial value and again
                            // whenever data at this location is updated.
                            val course_info = snapshot.getValue() as Map<String, String>
                            Log.d("ssong", course_info.toString())
                           if(serial_id != "0-0-0")
                                course_details.add(course_info["CourseDetail"]!!)
                           (binding.coursesRecyclerView.adapter as CourseAdapter).notifyDataSetChanged()
                        }

                        override fun onCancelled(error: DatabaseError) {
                            Log.w("ssong", "Failed to read value.", error.toException())
                        }

                    })
                }


            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("ssong", "Failed to read value.", error.toException())
            }

        })
        binding.coursesRecyclerView.adapter = CourseAdapter(course_details)
        binding.coursesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.coursesRecyclerView.addItemDecoration(
            DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL))
    }
}