package com.example.sharedprefs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedprefs.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

	private lateinit var binding: ActivitySecondBinding
	private lateinit var prefs: Preferences

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivitySecondBinding.inflate(layoutInflater)
		setContentView(binding.root)
		prefs = Preferences(this)

		binding.apply {
			tvSavedData.text = prefs.getSavedText()
			tvNotificationsState.text = prefs.getNotificationsEnableState().toString()
		}
	}

	companion object {
		fun start(context: Context) {
			context.startActivity(Intent(context, SecondActivity::class.java))
		}
	}
}