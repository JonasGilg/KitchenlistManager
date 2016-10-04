package de.kitchenlist

import javafx.application.Application
import javafx.stage.Stage
import de.kitchenlist.view.UIController

class Main : Application() {

	override fun start(primaryStage: Stage) {
		val uiController = UIController(primaryStage)
		uiController.show()
	}
}

fun main(args: Array<String>) = Application.launch(Main::class.java, *args)