package com.megaulorder.spaghet

import android.view.GestureDetector
import android.view.MotionEvent
import kotlinx.coroutines.flow.MutableStateFlow

class TouchaOnGestureListener : GestureDetector.SimpleOnGestureListener() {

	private var touchCount: Long = 0

	var gesture: MutableStateFlow<Map<Gesture?, Long?>> = MutableStateFlow(mapOf(null to null))
		private set

	override fun onDown(event: MotionEvent?): Boolean {
		return true
	}

	override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
		gesture.value = mapOf(Gesture.SINGLE_TAP to ++touchCount)
		return true
	}

	override fun onLongPress(event: MotionEvent?) {
		gesture.value = mapOf(Gesture.LONG_TAP to ++touchCount)
	}

	override fun onDoubleTap(e: MotionEvent?): Boolean {
		gesture.value = mapOf(Gesture.DOUBLE_TAP to ++touchCount)
		return true
	}

	override fun onScroll(
		e1: MotionEvent?,
		e2: MotionEvent?,
		distanceX: Float,
		distanceY: Float
	): Boolean {
		gesture.value = mapOf(Gesture.SCROLL to ++touchCount)
		return true
	}

	override fun onFling(
		e1: MotionEvent?,
		e2: MotionEvent?,
		velocityX: Float,
		velocityY: Float
	): Boolean {
		gesture.value = mapOf(Gesture.FLING to ++touchCount)
		return true
	}
}
