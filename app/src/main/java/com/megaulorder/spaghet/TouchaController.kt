package com.megaulorder.spaghet

import android.content.Context
import android.util.Log
import androidx.core.view.GestureDetectorCompat
import androidx.lifecycle.LifecycleCoroutineScope
import com.megaulorder.spaghet.mvi.Event
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect

class TouchaController(
	private val widgets: List<TouchaWidget>,
	private val coroutineScope: LifecycleCoroutineScope,
	private val eventsFlow: MutableSharedFlow<Event>,
	private val listener: TouchaOnGestureListener,
	private val context: Context,
) {

	private var name: String? = null

	init {
		widgets.forEach { widget ->
			widget.setViewDetector(GestureDetectorCompat(context, listener))
			widget.onTouchCallback = { name = it }
		}

		coroutineScope.launchWhenResumed {
			listener.gesture.collect {
				eventsFlow.emit(Event.Touch(TouchaObject.getByTitle(name), it.keys.last()))
//				Log.d("zhopa", "Toucha Controller высрал $name ${it.keys.last()}")
			}
		}
	}
}

