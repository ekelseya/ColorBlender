package com.example.inclassfuntime

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        var buttonCounterT = 1
        var buttonCountColor = 1
        val tView = findViewById<TextView>(R.id.textView3)

        val btnHideText = findViewById<Button>(R.id.changeText)
        btnHideText.setOnClickListener {
            if (buttonCounterT == 2) {
                tView.text = getString(R.string.hello_world)
                buttonCounterT = 1
            } else if (buttonCounterT == 1) {
                tView.text = getString(R.string.empty)
                buttonCounterT = 2
            }

        }

        val btnChangeColor: Button = findViewById(R.id.BtnColor)
        btnChangeColor.setOnClickListener {
            if(buttonCountColor == 1) {
                tView.setBackgroundColor(this@MainActivity.getColor(R.color.clickedColor))
                buttonCountColor = 2
            } else if (buttonCountColor == 2) {
                tView.setBackgroundColor(this@MainActivity.getColor(R.color.blank))
                buttonCountColor = 1
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
            // Inflate the menu; this adds items to the action bar if it is present.
            menuInflater.inflate(R.menu.menu_main, menu)
            return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
            R.id.action_settings -> {
                // User chose the "Settings" item, show the app settings UI...
                true
            }

            R.id.action_help -> {
                val TAG = getString(R.string.tag)
                Toast.makeText(this, getString(R.string.app_description), Toast.LENGTH_LONG).show()
                Log.i(TAG, getString(R.string.log_string))
                true
            }

            else -> {
                // Recommended overflow
                super.onOptionsItemSelected(item)
            }
        }
    }
