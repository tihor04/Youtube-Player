package com.example.youtubeplayer


import android.os.Bundle
import android.view.ViewGroup

import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

const val YOUTUBE_VIDEO_ID="ic1l36GrNOU"
const val YOUTUBE_PLAYLIST="RDGMEMQ1dJ7wXfLlqCjwV0xfSNbA&start_radio=1&rv=ic1l36GrNOU"

class YoutubeActivity : YouTubeBaseActivity(),YouTubePlayer.OnInitializedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)

        //val layout= findViewById<ConstraintLayout>(R.id.activity_youtube)

        val layout =layoutInflater.inflate(R.layout.activity_youtube,null) as ConstraintLayout
        setContentView(layout)

//        val button1 = Button(this)
//        button1.layoutParams=ConstraintLayout.LayoutParams(600,180)
//        button1.text="Button Added"
//        layout.addView(button1)

        val playerview  = YouTubePlayerView(this)
        playerview.layoutParams=ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layout.addView(playerview)





    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        TODO("Not yet implemented")
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        TODO("Not yet implemented")
    }
}