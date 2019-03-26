package com.example.colorpicker2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.Menu
import android.view.MenuItem

class MainActivity : FragmentActivity() {
    private var colorFrag:Fragment? = null
    private var slideFrag:Fragment? = null
    private var saveFrag:Fragment? = null
    private var favFrag:Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setSupportActionBar(my_toolbar)
        if (findViewById<>(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return
            }

            colorFrag = ColorFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, colorFrag as ColorFragment).commit()

            slideFrag = SlidersFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, slideFrag as SlidersFragment)
                .commit()
        }
    }

    // called by fragment (passed as the parameter) to switch to the other fragment
/*    override fun switchFragment(frag: Fragment) {
        when (frag) {
            is ToolbarFragment -> {
                if (frag2 == null) {
                    frag2 = ToolbarFragment2()
                }
                supportFragmentManager.beginTransaction().replace(R.id.fragframe, frag2!!).commit()
            }
            is ToolbarFragment2 -> {
                //bring back ToolbarFragment
                if (frag1 == null) {
                    frag1  = ToolbarFragment()
                }
                supportFragmentManager.beginTransaction().replace(R.id.fragframe, frag1!!).commit()
            }
        }
    }*/

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.save -> {

            val saveFrag = supportFragmentManager.findFragmentById(R.id.save_fragment) as SaveFragment
            true
        }

        R.id.favorite -> {
            val favFrag = supportFragmentManager.findFragmentById(R.id.favs_fragment) as FavoritesFragment
            true
        }

        else -> {
            // Recommended overflow
            super.onOptionsItemSelected(item)
        }
    }
}
/*override fun onButtonClick(fontsize: Int, text: String) {
    val textFragment = supportFragmentManager.findFragmentById(R.id.text_fragment)
            as TextFragment
    textFragment.changeTextProperties(fontsize, text)
}*/

