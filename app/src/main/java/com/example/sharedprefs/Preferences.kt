package com.example.sharedprefs

import android.content.Context

/**
 * Created by Sam Naduiev on 10/2/2022.
 */
class Preferences(context: Context) {
	private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

	fun saveText(text: String) {
		pref.edit().putString(PREF_SAVED_TEXT, text).apply()
	}

	fun getSavedText(): String? {
		return pref.getString(PREF_SAVED_TEXT, DEFAULT_STRING_VALUE)
	}

	fun setNotificationsEnableState(isEnabled: Boolean) {
		pref.edit().putBoolean(PREF_IS_NOTIFICATIONS_ENABLED, isEnabled).apply()
	}

	fun getNotificationsEnableState(): Boolean {
		return pref.getBoolean(PREF_IS_NOTIFICATIONS_ENABLED, false)
	}

	companion object {
		private const val PREF_NAME = "TEST_PREFS"
		private const val PREF_SAVED_TEXT = "PREF_SAVED_TEXT"
		private const val PREF_IS_NOTIFICATIONS_ENABLED = "PREF_IS_NOTIFICATIONS_ENABLED"
		private const val DEFAULT_STRING_VALUE = ""
	}
}