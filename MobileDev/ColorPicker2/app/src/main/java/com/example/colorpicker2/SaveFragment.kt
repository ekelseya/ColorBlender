package com.example.colorpicker2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SaveFragment : Fragment() {


    companion object {
        fun newInstance(): SaveFragment {
            return SaveFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.save_frag, container, false)
    }
}