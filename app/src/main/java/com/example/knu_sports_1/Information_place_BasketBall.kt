package com.example.knu_sports_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.knu_sports_1.databinding.ActivityInformationPlaceBasketBallBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceBigPlaygroundBinding
import com.google.android.material.tabs.TabLayout

class Information_place_BasketBall : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInformationPlaceBasketBallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("KNU | 시설물사용신청")

        binding.btnIp1.setOnClickListener {
            intent= Intent(this,Facility_Apply_basketball::class.java)
            startActivity(intent)
        }
        val tabLayout: TabLayout = binding.tabs
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            //탭 버튼은 선택할 때 이벤트
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text) {
                    "이용 안내" -> transaction.replace(R.id.tabContent, Information_place_Basketball_fragmentOne())
                    "예약 안내" -> transaction.replace(R.id.tabContent, Information_place_Basketball_fragmentTwo())
                    "취소/환급 규정"->transaction.replace(R.id.tabContent, Information_place_Basketball_fragmentThree())
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text) {
                    "이용 안내" -> transaction.replace(R.id.tabContent, Information_place_Basketball_fragmentOne())
                    "예약 안내" -> transaction.replace(R.id.tabContent, Information_place_Basketball_fragmentTwo())
                    "취소/환급 규정"->transaction.replace(R.id.tabContent, Information_place_Basketball_fragmentThree())
                }
                transaction.commit()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text) {
                    "이용 안내" -> transaction.replace(R.id.tabContent, Information_place_Basketball_fragmentOne())
                    "예약 안내" -> transaction.replace(R.id.tabContent, Information_place_Basketball_fragmentTwo())
                    "취소/환급 규정"->transaction.replace(R.id.tabContent, Information_place_Basketball_fragmentThree())
                }
                transaction.commit()
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.menu_home_button,menu)
        val menuHome=menu?.findItem(R.id.menu_home)
        menuHome?.setOnMenuItemClickListener {
            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            return@setOnMenuItemClickListener true
        }
        return true
    }
    override fun onBackPressed() {
        startActivity(Intent(this, Button5::class.java))
        finish()
    }
}