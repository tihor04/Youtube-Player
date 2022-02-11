package com.example.youtubeplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playsingle= findViewById<Button>(R.id.btnplaysingle)

        val playstandalone=findViewById<Button>(R.id.btnStandAlone)

        playsingle.setOnClickListener(this)

        playstandalone.setOnClickListener(this)


    }

    override fun onClick(v: View) {
       val intent=when(v.id){
           R.id.btnplaysingle-> Intent(this,YoutubeActivity::class.java)
           R.id.btnStandAlone->Intent(this,StandAloneActivity::class.java)
           else-> throw IllegalArgumentException("button not recognised ")

       }

        startActivity(intent)
    }
}