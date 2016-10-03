package main.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.layout.VBox
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle
import org.controlsfx.control.textfield.CustomPasswordField
import org.controlsfx.control.textfield.CustomTextField
import java.net.URL
import java.util.*

class LoginController : Initializable {
	private val dialog = Stage(StageStyle.UTILITY)

	internal var loginSuccess = false

	@FXML
	private var root: VBox? = null

	@FXML
	private var nameField: CustomTextField? = null

	@FXML
	private var passwordField: CustomPasswordField? = null

	@FXML
	private fun loginEvent(event: ActionEvent) {
		if (nameField?.text == "admin" && passwordField?.text == "admin") {
			loginSuccess = true
			dialog.close()
		} else {
			if(!nameField?.styleClass?.contains("error")!! && !passwordField?.styleClass?.contains("error")!!) {
				nameField?.styleClass?.add("error")
				passwordField?.styleClass?.add("error")
			}
			passwordField?.clear()
		}
	}

	@FXML
	fun keyTyped(event: KeyEvent) {
		if(event.character != "\r") {
			nameField?.styleClass?.remove("error")
			passwordField?.styleClass?.remove("error")
		}
	}

	@FXML
	fun cancelEvent(event: ActionEvent) {
		dialog.close()
	}

	@FXML
	fun manageUsersEvent(event: ActionEvent) {
		//TODO
		System.err.println("Not implemented!")
	}

	fun showAndWait() {
		dialog.showAndWait()
	}

	override fun initialize(location: URL?, resources: ResourceBundle) {
		root?.stylesheets?.add("/css/textfield-red-border.css")
		dialog.title = resources.getString("title")
		dialog.initModality(Modality.APPLICATION_MODAL)
		dialog.scene = Scene(root)
	}
}
