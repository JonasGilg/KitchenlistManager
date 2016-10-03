package main

import javafx.application.Application
import javafx.stage.Stage
import main.view.UIController

class Main : Application() {

	override fun start(primaryStage: Stage) {
		val uiController = UIController(primaryStage)
		uiController.show()
	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			launch(Main::class.java, *args)
		}
	}
}
