package com.megaulorder.spaghet.mvi

import com.megaulorder.spaghet.Gesture
import com.megaulorder.spaghet.TouchaObject

sealed interface Event {

	data class Touch(
		val what: TouchaObject?,
		val how: Gesture?
	) : Event
}

sealed interface Effect {

	data class Say(
		val what: TouchaObject?,
		val how: Gesture?
	) : Effect
}
