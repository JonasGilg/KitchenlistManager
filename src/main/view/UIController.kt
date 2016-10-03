package main.view

import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import main.control.Controller
import main.model.Log
import main.model.Person
import main.model.Product
import java.util.*

class UIController(val window: Stage) {
	private val fxmlLoader = FXMLLoader()

	val persons = FXCollections.observableArrayList<Person>()!!
	val products = FXCollections.observableArrayList<Product>()!!
	val log = Log()

	val controller = Controller(persons, products, log)

	val mainSceneController = MainSceneController(this)

	init {
		val root = loadFXML<BorderPane>("i18n.main", "/fxml/mainScene.fxml", mainSceneController)
		initWindow(root)
	}

	internal fun <T> loadFXML(resources: String, location: String, controller: Any): T {
		fxmlLoader.resources = ResourceBundle.getBundle(resources)
		fxmlLoader.location = javaClass.getResource(location)
		fxmlLoader.setRoot(null)
		fxmlLoader.setController(controller)
		return fxmlLoader.load<T>()
	}

	private fun initWindow(root: BorderPane) {
		window.title = "K\u00fcchenliste"

		window.setOnCloseRequest {
			mainSceneController.closeApplicationEvent(ActionEvent())
			it.consume()
		}

		val scene = Scene(root, root.prefWidth, root.prefHeight)

		window.scene = scene
		window.minWidth = root.prefWidth + 20
		window.minHeight = root.prefHeight + 40
	}

	fun show() = window.show()
}