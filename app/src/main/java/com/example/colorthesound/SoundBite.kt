package com.example.colorthesound

import android.content.Context
import android.media.MediaPlayer

class SoundBite(
    context: Context
) {

   lateinit var player: MediaPlayer
   var context: Context

   init {
       this.context = context
   }
   fun play(sound: Int) {

       player = MediaPlayer.create(this.context, sound)
       player.start()
   }


}