package com.example.youtubeplayer


import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast

import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

const val YOUTUBE_VIDEO_ID="ic1l36GrNOU"
const val YOUTUBE_PLAYLIST="RDGMEMQ1dJ7wXfLlqCjwV0xfSNbA&start_radio=1&rv=ic1l36GrNOU"

class YoutubeActivity : YouTubeBaseActivity(),YouTubePlayer.OnInitializedListener {
    val TAG="YouTubeActivity"

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
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layout.addView(playerview)

        playerview.initialize(getString(R.string.GOOGLE_API_KEY),this)


    }

    override fun onInitializationSuccess(
        provider : YouTubePlayer.Provider?,
        youTubeplayer: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        Log.d(TAG,"onInitialisationSuccess: provider is ${provider?.javaClass}")
        Log.d(TAG,"onInitialisationSuccess: youTubePlayer is ${youTubeplayer?.javaClass}")
        Toast.makeText(this,"Initialse",Toast.LENGTH_LONG).show()

        //setting up listners for the youtube player class

        youTubeplayer?.setPlaybackEventListener(playbackEventListner)
        youTubeplayer?.setPlayerStateChangeListener(playbackStateChangeListner)

        if(!wasRestored){
            youTubeplayer?.loadVideo(YOUTUBE_VIDEO_ID)

        }else{
            youTubeplayer?.play()
        }


    }

    override fun onInitializationFailure(
        provider0: YouTubePlayer.Provider?,
        youTubeInitializationResult: YouTubeInitializationResult?
    ) {
       val REQUEST_CODE=0

        if(youTubeInitializationResult?.isUserRecoverableError==true)
        {
            youTubeInitializationResult.getErrorDialog(this,REQUEST_CODE).show()
        }
        else
        {
            val errormessage= "There was an error initialising the YoutubePlayer $youTubeInitializationResult"
            Toast.makeText(this,errormessage,Toast.LENGTH_LONG).show()
        }
    }
    private val playbackEventListner= object:YouTubePlayer.PlaybackEventListener{
        override fun onPlaying() {
            Toast.makeText(this@YoutubeActivity,"Video is Playing Fine",Toast.LENGTH_SHORT).show()
        }

        override fun onPaused() {
           Toast.makeText(this@YoutubeActivity,"Video is paused",Toast.LENGTH_SHORT).show()
        }

        override fun onStopped() {
            Toast.makeText(this@YoutubeActivity,"Video Stopped",Toast.LENGTH_SHORT).show()
        }

        override fun onBuffering(p0: Boolean) {
        }

        override fun onSeekTo(p0: Int) {
        }
    }

    private val playbackStateChangeListner=object :YouTubePlayer.PlayerStateChangeListener{
        override fun onLoading() {
        }

        override fun onLoaded(p0: String?) {
        }

        override fun onAdStarted() {
         Toast.makeText(this@YoutubeActivity,"make creator Rich",Toast.LENGTH_SHORT).show()
        }

        override fun onVideoStarted() {
        }

        override fun onVideoEnded() {
            Toast.makeText(this@YoutubeActivity,"Video Ended",Toast.LENGTH_SHORT).show()
        }

        override fun onError(p0: YouTubePlayer.ErrorReason?) {
        }
    }
}