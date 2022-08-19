package com.megaulorder.spaghet

import androidx.core.view.GestureDetectorCompat
import com.megaulorder.spaghet.view.TouchaView

class TouchaWidget(private val view: TouchaView) {

	val name: TouchaObject? = TouchaObject.getByTitle(view.name)

	var onTouchCallback: ((name: String?) -> Unit)? = null

	init {
		view.onTouchCallback = { onTouchCallback?.invoke(it) }
	}

	fun setViewDetector(detector: GestureDetectorCompat) {
		view.detector = detector
	}
}
