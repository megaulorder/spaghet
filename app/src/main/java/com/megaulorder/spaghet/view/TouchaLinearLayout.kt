package com.megaulorder.spaghet.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.core.view.GestureDetectorCompat

class TouchaLinearLayout(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs),
	TouchaView {

	override var name: String? = resources.getResourceEntryName(id) ?: null

	override var detector: GestureDetectorCompat? = null

	override fun onTouchEvent(event: MotionEvent): Boolean {
		detector?.onTouchEvent(event)
		return true
	}
}
