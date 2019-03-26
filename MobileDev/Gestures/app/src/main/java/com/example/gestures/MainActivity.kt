package com.example.gestures

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private var mActivePointerId: Int = 0

    override fun onTouchEvent(event: MotionEvent): Boolean {
        mActivePointerId = event.getPointerId(0)

        val (x: Float, y: Float) = event.findPointerIndex(mActivePointerId).let { pointerIndex ->
            event.getX(pointerIndex) to event.getY(pointerIndex)
        }
    }

    val (xPos: Int, yPos: Int) = MotionEventCompat.getActionMasked(event).let { action ->
        Log.d(DEBUG_TAG, "The action is ${actionToString(action)}")
        MotionEventCompat.getActionIndex(event).let { index ->
            MotionEventCompat.getX(event, index).toInt() to MotionEventCompat.getY(event, index).toInt()
        }
    }

    if (event.pointerCount > 1) {
        Log.d(DEBUG_TAG, "Multitouch event")

    } else {
        Log.d(DEBUG_TAG, "Single touch event")
    }

    ...

    fun actionToString(action: Int): String {
        return when (action) {
            MotionEvent.ACTION_DOWN -> "Down"
            MotionEvent.ACTION_MOVE -> "Move"
            MotionEvent.ACTION_POINTER_DOWN -> "Pointer Down"
            MotionEvent.ACTION_UP -> "Up"
            MotionEvent.ACTION_POINTER_UP -> "Pointer Up"
            MotionEvent.ACTION_OUTSIDE -> "Outside"
            MotionEvent.ACTION_CANCEL -> "Cancel"
            else -> ""
        }
    }
}
