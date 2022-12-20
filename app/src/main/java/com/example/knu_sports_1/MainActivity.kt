package com.example.knu_sports_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.knu_sports_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("KNU|체육진흥센터")
        val sessionUID = intent.extras?.getString("SessionUID")
        binding.button1.setOnClickListener {
            intent=Intent(this,Button1::class.java)
            intent.putExtra("SessionUID", sessionUID)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            intent=Intent(this,Button2::class.java)
            intent.putExtra("SessionUID", sessionUID)
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            intent=Intent(this,ShowCoursesActivity::class.java)
            intent.putExtra("SessionUID", sessionUID)
            startActivity(intent)
        }
        binding.button4.setOnClickListener {
            intent=Intent(this,Button4::class.java)
            intent.putExtra("SessionUID", sessionUID)
            startActivity(intent)
        }
        binding.button5.setOnClickListener {
            intent=Intent(this,Button5::class.java)
            intent.putExtra("SessionUID", sessionUID)
            startActivity(intent)
        }
        binding.button6.setOnClickListener {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home_button,menu)
        return super.onCreateOptionsMenu(menu)
    }
}