package com.megaulorder.spaghet.mvi

import com.megaulorder.spaghet.Gestures
import com.megaulorder.spaghet.TouchaObjects

sealed interface Event {

	data class Touch(
		val what: TouchaObjects?,
		val how: Gestures?
	) : Event
}

sealed interface Effect {

	data class Say(
		val what: TouchaObjects?,
		val how: Gestures?
	) : Effect
}
