package com.megaulorder.spaghet.view

import androidx.core.view.GestureDetectorCompat

interface TouchaView {

	var name: String?

	var detector: GestureDetectorCompat?

	var onTouchCallback: ((name: String?) -> Unit)?
}
