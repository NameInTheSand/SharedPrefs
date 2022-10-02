package com.example.sharedprefs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedprefs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	private lateinit var prefs: Preferences

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		prefs = Preferences(this)
		binding.switchNotification.isChecked = prefs.getNotificationsEnableState()
		setupListeners()
	}

	private fun setupListeners() {
		binding.apply {
			btnOpenSecondActivity.setOnClickListener {
				SecondActivity.start(this@MainActivity)
			}
			btnSaveData.setOnClickListener {
				prefs.saveText(etPrefSaver.text.toString())
			}
			switchNotification.setOnCheckedChangeListener { _, isChecked: Boolean ->
				prefs.setNotificationsEnableState(isChecked)
			}
		}
	}
}