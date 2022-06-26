package com.megaulorder.spaghet

import android.util.Log
import android.view.GestureDetector
import androidx.core.view.GestureDetectorCompat
import androidx.lifecycle.LifecycleCoroutineScope
import com.megaulorder.spaghet.mvi.Event
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect

class TouchaController(
	private val widget: TouchaWidget,
	private val coroutineScope: LifecycleCoroutineScope,
	private val eventsFlow: MutableSharedFlow<Event>
) {

	private val detector = TouchaGestureDetector()

	init {
		widget.setViewDetector(
			GestureDetectorCompat(
				widget.context,
				detector as GestureDetector.SimpleOnGestureListener
			)
		)

		coroutineScope.launchWhenResumed {
			detector.gesture.collect {
				eventsFlow.emit(Event.Touch(widget.name, it))
			}
		}
	}
}
