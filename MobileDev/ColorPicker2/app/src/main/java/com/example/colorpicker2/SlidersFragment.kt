package com.example.colorpicker2

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast

class SlidersFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.slider_frag, container, false)
    }


    companion object {
        fun newInstance(): SlidersFragment {
            return SlidersFragment()
        }
    }

    override fun onCreate(
        inflater: LayoutInflater?, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(R.layout.slider_frag, container, false)}

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
                this@MainActivity.editTextRed.text =
                    Editable.Factory.getInstance().newEditable(seekBarRed.progress.toString())

                val colorView = findViewById<ImageView>(R.id.imageView)
                val redValue = seekBarRed.progress
                val greenValue = seekBarGreen.progress
                val blueValue = seekBarBlue.progress

                colorView.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                val redValue = java.lang.Integer.toHexString(seekBarRed.progress)
                val greenValue = java.lang.Integer.toHexString(seekBarGreen.progress)
                val blueValue = java.lang.Integer.toHexString(seekBarBlue.progress)
                val hexValue = "$redValue$greenValue$blueValue".toUpperCase()
                Toast.makeText(this@MainActivity, "#$hexValue", Toast.LENGTH_LONG).show()
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
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                this@MainActivity.editTextBlue.text =
                    Editable.Factory.getInstance().newEditable(seekBarBlue.progress.toString())

                val colorView = findViewById<ImageView>(R.id.imageView)
                val redValue = seekBarRed.progress
                val greenValue = seekBarGreen.progress
                val blueValue = seekBarBlue.progress

                colorView.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                val redValue = java.lang.Integer.toHexString(seekBarRed.progress)
                val greenValue = java.lang.Integer.toHexString(seekBarGreen.progress)
                val blueValue = java.lang.Integer.toHexString(seekBarBlue.progress)
                val hexValue = "$redValue$greenValue$blueValue".toUpperCase()
                Toast.makeText(this@MainActivity, "#$hexValue", Toast.LENGTH_LONG).show()
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
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                this@MainActivity.editTextGreen.text =
                    Editable.Factory.getInstance().newEditable(seekBarGreen.progress.toString())

                val colorView = findViewById<ImageView>(R.id.imageView)
                val redValue = seekBarRed.progress
                val greenValue = seekBarGreen.progress
                val blueValue = seekBarBlue.progress

                colorView.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                val redValue = java.lang.Integer.toHexString(seekBarRed.progress)
                val greenValue = java.lang.Integer.toHexString(seekBarGreen.progress)
                val blueValue = java.lang.Integer.toHexString(seekBarBlue.progress)
                val hexValue = "$redValue$greenValue$blueValue".toUpperCase()
                Toast.makeText(this@MainActivity, "#$hexValue", Toast.LENGTH_LONG).show()
            }
        })
    }
}