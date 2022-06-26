package com.megaulorder.spaghet

enum class TouchaObjects(val title: String) {
	SPAGHET("spaghet"),
	HEAD("head"),
	TEXT_BUBBLE("bubble"),
	BACKGROUND("background");

	companion object {
		fun getByTitle(title: String?): TouchaObjects? = values().find { it.title == title }
	}
}
