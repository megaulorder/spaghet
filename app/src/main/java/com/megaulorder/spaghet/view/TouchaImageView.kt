package com.megaulorder.spaghet.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.GestureDetectorCompat

class TouchaImageView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs),
	TouchaView {

	override var name: String? = resources.getResourceEntryName(id) ?: null

	override var detector: GestureDetectorCompat? = null

	override var onTouchCallback: ((name: String?) -> Unit)? = null

	override fun onTouchEvent(event: MotionEvent): Boolean {
		super.onTouchEvent(event)
		detector?.onTouchEvent(event)
		onTouchCallback?.invoke(name)
		return true
	}
}
