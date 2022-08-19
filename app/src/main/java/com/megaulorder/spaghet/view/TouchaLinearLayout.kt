package com.megaulorder.spaghet.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.GestureDetectorCompat
import kotlin.math.roundToInt

class TouchaLinearLayout(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs),
	TouchaView {

	override var name: String? = resources.getResourceEntryName(id) ?: null

	override var detector: GestureDetectorCompat? = null

	override var onTouchCallback: ((name: String?) -> Unit)? = null

	override fun onTouchEvent(event: MotionEvent): Boolean {
		detector?.onTouchEvent(event)
		onTouchCallback?.invoke(name)
		return true
	}

	override fun setTag(tag: Any?) {
		super.setTag(tag)
	}

	override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
		return getChildTouched(event, this) == null
	}

	private fun getChildTouched(event: MotionEvent, viewGroup: ViewGroup): View? {
		val x = event.x.roundToInt()
		val y = event.y.roundToInt()

		for (i in 0 until viewGroup.childCount) {
			val child = getChildAt(i)
			if (x > child.left && x < child.right && y > child.top && y < child.bottom) {
				if (child is View) {
//					child as TouchaView
//					child.onTouchCallback?.let { it(child.name) }
//					detector?.onTouchEvent(event)
//					child.dispatchTouchEvent(event)
					return child

				} else if (child is ViewGroup) {
					return getChildTouched(event, child)
				}
			}
		}
		return null
	}
}
