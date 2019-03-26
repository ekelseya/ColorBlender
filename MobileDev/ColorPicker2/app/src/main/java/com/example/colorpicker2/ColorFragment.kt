package com.example.colorpicker2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ColorFragment : Fragment() {


    companion object {
        fun newInstance(): ColorFragment {
            return ColorFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.color_frag, container, false)
    }
}