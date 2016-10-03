package main.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.Scene
import javafx.scene.input.KeyEvent
import javafx.scene.layout.VBox
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle
import org.controlsfx.control.textfield.CustomTextField

import java.net.URL
import java.util.ResourceBundle

class NewPersonController : Initializable {
	private val dialog = Stage(StageStyle.UTILITY)

	@FXML
	private var root: VBox? = null

	@FXML
	private var firstNameField: CustomTextField? = null

	@FXML
	private var lastNameField: CustomTextField? = null

	@FXML
	private var balanceField: CustomTextField? = null

	@FXML
	fun cancel(event: ActionEvent) {
		dialog.close()
	}

	@FXML
	fun createPerson(event: ActionEvent) {

	}

	@FXML
	fun update(event: KeyEvent) {

	}

	internal fun showAndWait() {
		dialog.showAndWait()
	}

	override fun initialize(location: URL, resources: ResourceBundle) {
		dialog.title = resources.getString("title")
		dialog.initModality(Modality.APPLICATION_MODAL)
		dialog.scene = Scene(root)
	}
}
