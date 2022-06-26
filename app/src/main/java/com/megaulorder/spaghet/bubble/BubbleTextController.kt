package com.megaulorder.spaghet.bubble

import androidx.lifecycle.LifecycleCoroutineScope
import com.megaulorder.spaghet.mvi.Effect
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect

class BubbleTextController(
	private val widget: BubbleTextWidget,
	private val coroutineScope: LifecycleCoroutineScope,
	private val effectsFlow: MutableSharedFlow<Effect>,
) {
	init {
		coroutineScope.launchWhenResumed {
			effectsFlow.collect {
				if (it is Effect.Say) {
					if (it.how != null) {
						widget.setText(it.what?.title, it.how.text)
					} else {
						widget.setSilence()
					}
				}
			}
		}
	}
}
