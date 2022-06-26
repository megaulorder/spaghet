package com.megaulorder.spaghet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

		val spaghetWidget = TouchaWidget(findViewById(R.id.spaghet), this)
		val spaghetController = TouchaController(
			widget = spaghetWidget,
			coroutineScope = lifecycle.coroutineScope,
			eventsFlow = eventsFlow
		)

		val headWidget = TouchaWidget(findViewById(R.id.head), this)
		val headController = TouchaController(
			widget = headWidget,
			coroutineScope = lifecycle.coroutineScope,
			eventsFlow = eventsFlow
		)

		val bubbleWidget = TouchaWidget(findViewById(R.id.bubble), this)
		val bubbleController = TouchaController(
			widget = bubbleWidget,
			coroutineScope = lifecycle.coroutineScope,
			eventsFlow = eventsFlow
		)

		val backgroundWidget = TouchaWidget(findViewById(R.id.background), this)
		val backgroundController = TouchaController(
			widget = backgroundWidget,
			coroutineScope = lifecycle.coroutineScope,
			eventsFlow = eventsFlow
		)

		val bubbleTextWidget = BubbleTextWidget(findViewById(R.id.text), resources)
		val bubbleTextController = BubbleTextController(
			widget = bubbleTextWidget,
			coroutineScope = lifecycle.coroutineScope,
			effectsFlow = effectsFlow
		)
	}
}
