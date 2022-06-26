package com.megaulorder.spaghet

import android.view.GestureDetector
import android.view.MotionEvent
import kotlinx.coroutines.flow.MutableStateFlow

class TouchaGestureDetector : GestureDetector.SimpleOnGestureListener() {

	var gesture: MutableStateFlow<Gestures?> = MutableStateFlow(value = null)

	override fun onDown(event: MotionEvent?): Boolean {
		return true
	}

	override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
		gesture.value = Gestures.SINGLE_TAP

		return true
	}

	override fun onLongPress(event: MotionEvent?) {
		gesture.value = Gestures.LONG_TAP
	}

	override fun onDoubleTap(e: MotionEvent?): Boolean {
		gesture.value = Gestures.DOUBLE_TAP
		return true
	}

	override fun onScroll(
		e1: MotionEvent?,
		e2: MotionEvent?,
		distanceX: Float,
		distanceY: Float
	): Boolean {
		gesture.value = Gestures.SCROLL
		return true
	}

	override fun onFling(
		e1: MotionEvent?,
		e2: MotionEvent?,
		velocityX: Float,
		velocityY: Float
	): Boolean {
		gesture.value = Gestures.FLING
		return true
	}
}
