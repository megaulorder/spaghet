package com.megaulorder.spaghet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import androidx.lifecycle.coroutineScope
import com.megaulorder.spaghet.bubble.BubbleTextController
import com.megaulorder.spaghet.bubble.BubbleTextWidget
import com.megaulorder.spaghet.mvi.Effect
import com.megaulorder.spaghet.mvi.Event
import com.megaulorder.spaghet.mvi.Reducer
import kotlinx.coroutines.flow.MutableSharedFlow

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val eventsFlow = MutableSharedFlow<Event>()
		val effectsFlow = MutableSharedFlow<Effect>()
		val reducer = Reducer(lifecycle.coroutineScope, eventsFlow, effectsFlow)
		val listener = TouchaOnGestureListener()
		val detector = GestureDetectorCompat(this, listener)

		val spaghetWidget = TouchaWidget(findViewById(R.id.spaghet))
		val headWidget = TouchaWidget(findViewById(R.id.head))
		val bubbleWidget = TouchaWidget(findViewById(R.id.bubble))
		val backgroundWidget = TouchaWidget(findViewById(R.id.background))
		val controller = TouchaController(
			widgets = listOf(spaghetWidget, headWidget, bubbleWidget, backgroundWidget),
			coroutineScope = lifecycle.coroutineScope,
			eventsFlow = eventsFlow,
			listener = listener,
			context = this,
		)

		val bubbleTextWidget = BubbleTextWidget(findViewById(R.id.text), resources)
		val bubbleTextController = BubbleTextController(
			widget = bubbleTextWidget,
			coroutineScope = lifecycle.coroutineScope,
			effectsFlow = effectsFlow,
		)
	}
}
