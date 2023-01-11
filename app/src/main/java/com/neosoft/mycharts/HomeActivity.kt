package com.neosoft.mycharts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
     var btn_barChart :Button? =null
    var btn_pieChart :Button? =null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btn_barChart = findViewById(R.id.btn_barChart)
        btn_pieChart = findViewById(R.id.btn_pieChart)

        btn_barChart?.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        btn_pieChart?.setOnClickListener {
            startActivity(Intent(this,PieChartActivity::class.java))
        }
    }




}