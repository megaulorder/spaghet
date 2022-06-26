package com.megaulorder.spaghet.mvi

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect

class Reducer(
	private val coroutineScope: LifecycleCoroutineScope,
	private val eventsFlow: MutableSharedFlow<Event>,
	private val effectsFlow: MutableSharedFlow<Effect>
) {
	init {
		coroutineScope.launchWhenResumed {
			eventsFlow.collect {
				if (it is Event.Touch) {
					effectsFlow.emit(Effect.Say(it.what, it.how))
				}
			}
		}
	}
}
