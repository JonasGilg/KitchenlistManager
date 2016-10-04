package main.model

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import java.text.SimpleDateFormat
import java.util.Calendar

data class Log(val log: ObservableList<String> = FXCollections.observableArrayList<String>()) {

	fun append(entry: String) {
		log.add("${DATE_FORMAT.format(CALENDAR.time)} $entry")
	}

	companion object {
		private val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
		private val CALENDAR = Calendar.getInstance()
	}
}
