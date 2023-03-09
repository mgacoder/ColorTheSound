package com.example.colorthesound

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {

    lateinit var boxOneText: TextView
    lateinit var boxTwoText: TextView
    lateinit var boxThreeText: TextView
    lateinit var boxFourText: TextView
    lateinit var boxFiveText: TextView
    lateinit var constraintLayout: ConstraintLayout
    lateinit var redButton: Button
    lateinit var yellowButton: Button
    lateinit var greenButton: Button
    lateinit var soundBite: SoundBite

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boxOneText = findViewById(R.id.box_one_text)
        boxTwoText = findViewById(R.id.box_two_text)
        boxThreeText = findViewById(R.id.box_three_text)
        boxFourText = findViewById(R.id.box_four_text)
        boxFiveText = findViewById(R.id.box_five_text)
        constraintLayout = findViewById(R.id.constraint_layout)
        redButton = findViewById(R.id.red_button)
        yellowButton = findViewById(R.id.yellow_button)
        greenButton = findViewById(R.id.green_button)
        soundBite = SoundBite(this)
        setListeners()
    }

    private fun setListeners() {

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                    boxFourText, boxFiveText, constraintLayout,
                    redButton, yellowButton, greenButton)

        for(item in clickableViews){
            item.setOnClickListener{ makeColored(it)}
        }
    }

    private fun makeColored(view: View) {
        when(view.id){

            //Boxes using Color class colors for background
            R.id.box_one_text -> {
                view.setBackgroundColor(Color.DKGRAY)
                soundBite.play(R.raw.song_one)
            }
            R.id.box_two_text -> {
                view.setBackgroundColor(Color.GRAY)
                soundBite.play(R.raw.song_two)
            }

            //Boxes using Android color resources for background
            R.id.box_three_text -> {
                view.setBackgroundResource(android.R.color.holo_green_light)
                soundBite.play(R.raw.song_three)
            }
            R.id.box_four_text -> {
                view.setBackgroundResource(android.R.color.holo_green_dark)
                soundBite.play(R.raw.song_four)
            }
            R.id.box_five_text -> {
                view.setBackgroundResource(android.R.color.holo_green_light)
                soundBite.play(R.raw.song_five)
            }

            //Boxes using custom color for background
            R.id.red_button -> {
                boxThreeText.setBackgroundResource(R.color.my_red)
                soundBite.play(R.raw.song_six)
            }
            R.id.yellow_button -> {
                boxFourText.setBackgroundResource(R.color.my_yellow)
                soundBite.play(R.raw.song_seven)
            }
            R.id.green_button -> {
                boxFiveText.setBackgroundResource(R.color.my_green)
                soundBite.play(R.raw.song_eight)
            }

            else -> {
                view.setBackgroundColor(Color.LTGRAY)
                soundBite.play(R.raw.song_nine)
            }
        }
    }
}