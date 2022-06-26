package com.megaulorder.spaghet.bubble

import android.content.res.Resources
import android.widget.TextView
import com.megaulorder.spaghet.R

class BubbleTextWidget(private val view: TextView, private val resources: Resources) {

	init {
		setSilence()
	}

	fun setSilence() {
		view.text = resources.getString(R.string.nothing)
	}

	fun setText(what: String?, how: String) {
		view.text =
			String.format(resources.getString(R.string.somebody_toucha_my_spaghet), how, what)
	}
}
