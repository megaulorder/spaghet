package com.megaulorder.spaghet

import android.content.Context
import androidx.core.view.GestureDetectorCompat
import com.megaulorder.spaghet.view.TouchaView

class TouchaWidget(private val view: TouchaView, val context: Context) {

	val name: TouchaObjects? = TouchaObjects.getByTitle(view.name)

	fun setViewDetector(detector: GestureDetectorCompat) {
		view.detector = detector
	}
}
