package com.example.youtubeplayer

import android.os.Bundle

import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import com.google.android.youtube.player.YouTubeStandalonePlayer.*
import java.lang.IllegalArgumentException

class StandAloneActivity: AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)

        val playbutton=findViewById<Button>(R.id.btnPlayVideo)
        playbutton.setOnClickListener(this)

        val playplaylist=findViewById<Button>(R.id.btnPlayList)
         playplaylist.setOnClickListener(this)




    }

    override fun onClick(v: View) {
        val intent= when (v.id){
            R.id.btnPlayVideo-> createVideoIntent(
                this,getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_ID
            )
            R.id.btnPlayList-> createPlaylistIntent(this,getString(R.string.GOOGLE_API_KEY),
                YOUTUBE_PLAYLIST)

            else -> {throw IllegalArgumentException("undefined button clicked")}

        }

        startActivity(intent)

    }
}