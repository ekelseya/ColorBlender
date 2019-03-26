package com.example.colorpicker

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(this.findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val textBoxA = findViewById<EditText>(R.id.editTextA)
        textBoxA.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                this@MainActivity.seekBarA.progress = Integer.parseInt(textBoxA.text.toString())
            }
        })

        val seekBarA = findViewById<SeekBar>(R.id.seekBarA)
        seekBarA.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            //TODO set textbox onclick event to set progress bar
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                this@MainActivity.editTextA.text = Editable.Factory.getInstance().newEditable(seekBarA.progress.toString())

                val colorView = findViewById<ImageView>(R.id.imageView)
                val aValue = seekBarA.progress
                val redValue = seekBarRed.progress
                val greenValue = seekBarGreen.progress
                val blueValue = seekBarBlue.progress

                colorView.setBackgroundColor(Color.argb(aValue, redValue, greenValue, blueValue))

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                val aValue = seekBarA.progress
                val redValue = java.lang.Integer.toHexString(seekBarRed.progress)
                val greenValue = java.lang.Integer.toHexString(seekBarGreen.progress)
                val blueValue = java.lang.Integer.toHexString(seekBarBlue.progress)
                val hexValue = "$redValue$greenValue$blueValue".toUpperCase()
                val transparency = "%.2f".format((aValue/255.0)*100.0)
                //TODO change aValue to percentage and hexValue to 8 digit string
                Toast.makeText(this@MainActivity, "#$hexValue\n$transparency %Transparency", Toast.LENGTH_LONG).show()
            }
        })

        val textBoxRed = findViewById<EditText>(R.id.editTextRed)
        textBoxRed.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                this@MainActivity.seekBarRed.progress = Integer.parseInt(textBoxRed.text.toString())
            }
        })

        val seekBarRed = findViewById<SeekBar>(R.id.seekBarRed)
        seekBarRed.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                this@MainActivity.editTextRed.text = Editable.Factory.getInstance().newEditable(seekBarRed.progress.toString())

                val colorView = findViewById<ImageView>(R.id.imageView)
                val aValue = seekBarA.progress
                val redValue = seekBarRed.progress
                val greenValue = seekBarGreen.progress
                val blueValue = seekBarBlue.progress

                colorView.setBackgroundColor(Color.argb(aValue, redValue, greenValue, blueValue))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                val aValue = seekBarA.progress
                val redValue = java.lang.Integer.toHexString(seekBarRed.progress)
                val greenValue = java.lang.Integer.toHexString(seekBarGreen.progress)
                val blueValue = java.lang.Integer.toHexString(seekBarBlue.progress)
                val hexValue = "$redValue$greenValue$blueValue".toUpperCase()
                val transparency = "%.2f".format((aValue/255.0)*100.0)
                //TODO change aValue to percentage and hexValue to 8 digit string
                Toast.makeText(this@MainActivity, "#$hexValue\n$transparency %Transparency", Toast.LENGTH_LONG).show()
            }
        })

        val textBoxBlue = findViewById<EditText>(R.id.editTextBlue)
        textBoxBlue.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                this@MainActivity.seekBarBlue.progress = Integer.parseInt(textBoxBlue.text.toString())
            }
        })

        val seekBarBlue = findViewById<SeekBar>(R.id.seekBarBlue)
        seekBarBlue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            //TODO set textbox onclick event to set progress bar
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                this@MainActivity.editTextBlue.text = Editable.Factory.getInstance().newEditable(seekBarBlue.progress.toString())

                val colorView = findViewById<ImageView>(R.id.imageView)
                val aValue = seekBarA.progress
                val redValue = seekBarRed.progress
                val greenValue = seekBarGreen.progress
                val blueValue = seekBarBlue.progress

                colorView.setBackgroundColor(Color.argb(aValue, redValue, greenValue, blueValue))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                val aValue = seekBarA.progress
                val redValue = java.lang.Integer.toHexString(seekBarRed.progress)
                val greenValue = java.lang.Integer.toHexString(seekBarGreen.progress)
                val blueValue = java.lang.Integer.toHexString(seekBarBlue.progress)
                val hexValue = "$redValue$greenValue$blueValue".toUpperCase()
                val transparency = "%.2f".format((aValue/255.0)*100.0)
                //TODO change aValue to percentage and hexValue to 8 digit string
                Toast.makeText(this@MainActivity, "#$hexValue\n$transparency %Transparency", Toast.LENGTH_LONG).show()
            }
        })

        val textBoxGreen = findViewById<EditText>(R.id.editTextGreen)
        textBoxGreen.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                this@MainActivity.seekBarGreen.progress = Integer.parseInt(textBoxGreen.text.toString())
            }
        })

        val seekBarGreen = findViewById<SeekBar>(R.id.seekBarGreen)
        seekBarGreen.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            //TODO set textbox onclick event to set progress bar
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                this@MainActivity.editTextGreen.text = Editable.Factory.getInstance().newEditable(seekBarGreen.progress.toString())

                val colorView = findViewById<ImageView>(R.id.imageView)
                val aValue = seekBarA.progress
                val redValue = seekBarRed.progress
                val greenValue = seekBarGreen.progress
                val blueValue = seekBarBlue.progress

                colorView.setBackgroundColor(Color.argb(aValue, redValue, greenValue, blueValue))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                val aValue = seekBarA.progress
                val redValue = java.lang.Integer.toHexString(seekBarRed.progress)
                val greenValue = java.lang.Integer.toHexString(seekBarGreen.progress)
                val blueValue = java.lang.Integer.toHexString(seekBarBlue.progress)
                val hexValue = "$redValue$greenValue$blueValue".toUpperCase()
                val transparency = "%.2f".format((aValue/255.0)*100.0)
                //TODO change aValue to percentage and hexValue to 8 digit string
                Toast.makeText(this@MainActivity, "#$hexValue\n$transparency %Transparency", Toast.LENGTH_LONG).show()
            }
        })

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.save -> {

            true
        }

        R.id.favorite -> {
            // User chose "Favorites"
            true
        }

        else -> {
            // Recommended overflow
            super.onOptionsItemSelected(item)
        }
    }
}



