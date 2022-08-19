package com.megaulorder.spaghet

enum class TouchaObject(val title: String) {
	SPAGHET("spaghet"),
	HEAD("head"),
	TEXT_BUBBLE("bubble"),
	BACKGROUND("background");

	companion object {
		fun getByTitle(title: String?): TouchaObject? = values().find { it.title == title }
	}
}
