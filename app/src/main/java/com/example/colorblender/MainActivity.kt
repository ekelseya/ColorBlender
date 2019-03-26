package com.example.colorblender

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    var arrayColorOne = arrayListOf<Int>(255, 255, 255)
    var arrayColorTwo = arrayListOf<Int>(255, 255, 255)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorViewOne = findViewById<ImageView>(R.id.colorView1)
        val colorOneLabel = findViewById<TextView>(R.id.color_1_percent)
        val colorOneButton = findViewById<Button>(R.id.btn_clr_1)
        colorOneButton.setOnClickListener {
            launchColorPicker(colorOneButton)
            if (intent.extras != null) {

                val redValue = arrayColorOne[0]
                val greenValue = arrayColorOne[1]
                val blueValue = arrayColorOne[2]

                val newColor = Color.rgb(redValue, greenValue, blueValue)

                colorViewOne.setColorFilter(newColor)
            } else {
                Log.e("EXTRAS", "Null error thrown")
            }
        }

        val colorViewTwo = findViewById<ImageView>(R.id.colorView2)
        val colorTwoLabel = findViewById<TextView>(R.id.color_2_percent)
        val colorTwoButton = findViewById<Button>(R.id.btn_clr_2)
        colorTwoButton.setOnClickListener {
            launchColorPicker(colorTwoButton)
            Log.e("LAUNCH", "colorTwoButton")

            val redValue = arrayColorTwo[0]
            val greenValue = arrayColorTwo[1]
            val blueValue = arrayColorTwo[2]

            val newColor = Color.rgb(redValue, greenValue, blueValue)

            colorViewTwo.setColorFilter(newColor)
        }

        val blendSeekBar = findViewById<SeekBar>(R.id.seekBar)
        blendSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar) {
                blendSeekBar.progress = 50
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                val blendValue = blendSeekBar.progress
                val colorOnePercent = """${(100 - blendValue)}%"""
                val colorTwoPercent = "$blendValue%"
                colorOneLabel.text = colorOnePercent
                colorTwoLabel.text = colorTwoPercent


                val redOne = arrayColorOne[0]
                val greenOne = arrayColorOne[1]
                val blueOne = arrayColorOne[2]

                val redTwo = arrayColorTwo[0]
                val greenTwo = arrayColorTwo[1]
                val blueTwo = arrayColorTwo[2]

                val blendColorView = findViewById<ImageView>(R.id.BlendedColorView)

                val newRed = ((redOne * (100.0 - blendValue) / 100.0)
                                + (redTwo * (blendValue / 100.0))).roundToInt()
                val newGreen = ((greenOne * ((100.0 - blendValue) / 100.0))
                                  + (greenTwo * (blendValue / 100.0))).roundToInt()
                val newBlue = ((blueOne * ((100.0 - blendValue)) / 100.0)
                                 + (blueTwo * (blendValue / 100.0))).roundToInt()

                val newColor = Color.rgb(newRed, newGreen, newBlue)

                blendColorView.setColorFilter(newColor)

            }
        })
    }

    private fun launchColorPicker(view: View){
        val launchIntent = Intent("com.example.rgbcolorpicker.ACTION_COLOR")
        launchIntent.putExtra("color", "")
        if (view.id == R.id.btn_clr_1) {
            startActivityForResult(launchIntent, 1)
        } else if (view.id == R.id.btn_clr_2) {
            startActivityForResult(launchIntent, 2)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // Check which request we're responding to
        val extras = data?.extras
        Log.i("RETURN", "Return OK")
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                //val arrayColorOne = extras?.getIntArray("color")
                val colorViewOne = findViewById<ImageView>(R.id.colorView1)

                val redValue = extras!!.getInt("red")
                val greenValue = extras.getInt("green")
                val blueValue = extras.getInt("blue")

                arrayColorOne[0] = redValue
                arrayColorOne[1] = greenValue
                arrayColorOne[2] =blueValue

                val newColor =  Color.rgb(redValue, greenValue, blueValue)

                colorViewOne.setColorFilter(newColor)
            }
        }else if(requestCode == 2){
            if (resultCode == Activity.RESULT_OK) {
                val colorViewTwo = findViewById<ImageView>(R.id.colorView2)

                val redValue = extras!!.getInt("red")
                val greenValue = extras.getInt("green")
                val blueValue = extras.getInt("blue")

                arrayColorTwo[0] = redValue
                arrayColorTwo[1] = greenValue
                arrayColorTwo[2] = blueValue

                val newColor =  Color.rgb(redValue, greenValue, blueValue)

                colorViewTwo.setColorFilter(newColor)
            }
        }
    }
}


