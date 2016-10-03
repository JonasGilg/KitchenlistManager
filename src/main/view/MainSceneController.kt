package main.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.effect.DropShadow
import javafx.scene.layout.BorderPane
import javafx.scene.text.Font
import javafx.util.Duration
import main.model.Person
import org.controlsfx.control.PopOver
import java.util.*

class MainSceneController(val uiController: UIController) {
	private val textArea = TextArea()
	private val popUp = PopOver(textArea)

	@FXML
	private var resources: ResourceBundle? = null

	@FXML
	private var root: BorderPane? = null

	@FXML
	private var menuBarEditUndo: MenuItem? = null

	@FXML
	private var menuBarEditRedo: MenuItem? = null

	@FXML
	private var menuBarEditNewPerson: MenuItem? = null

	@FXML
	private var menuBarEditNewProduct: MenuItem? = null

	@FXML
	private var toolBarNotes: Button? = null

	@FXML
	private var toolBarLoginLogout: Button? = null

	@FXML
	private var toolBarUndo: Button? = null

	@FXML
	private var toolBarRedo: Button? = null

	@FXML
	private var toolBarLog: Button? = null

	@FXML
	private var toolBarNewPerson: Button? = null

	@FXML
	private var toolBarNewProduct: Button? = null

	@FXML
	private var toolBarStock: Button? = null

	@FXML
	private var toolBarFinances: Button? = null

	@FXML
	private var personTable: TableView<Person>? = null

	@FXML
	private var personTableLastNameColumn: TableColumn<Person, String>? = null

	@FXML
	private var personTableFirstNameColumn: TableColumn<Person, String>? = null

	@FXML
	private var personTableBalanceColumn: TableColumn<Person, Double>? = null

	@FXML
	private var buttonBarDetails: Button? = null

	@FXML
	private var buttonBarInfo: Label? = null

	@FXML
	private var buttonBarDiscard: Button? = null

	@FXML
	private var buttonBarBuy: Button? = null

	@FXML
	private var productTable: TableView<*>? = null

	@FXML
	private var productTableProductColumn: TableColumn<*, *>? = null

	@FXML
	private var productTablePriceColumn: TableColumn<*, *>? = null

	@FXML
	private var productTableAmountColumn: TableColumn<*, *>? = null

	@FXML
	fun buyCartEvent(event: ActionEvent) {
		println("buying")
	}

	@FXML
	fun closeApplicationEvent(event: ActionEvent?) {
		val alert = Alert(Alert.AlertType.CONFIRMATION, "Drücken sie abbrechen um zur Anwendung zurückzukehren oder " +
				"schließen um mit dem schließen fortzufahren.", ButtonType.CANCEL, ButtonType.YES)
		alert.headerText = "Wollen sie die Anwendung wirklich schließen?"
		alert.showAndWait()
		if (alert.result == ButtonType.YES) {
			//TODO save
			uiController.window.close()

			Thread.sleep(1000)
			System.exit(0) //if closing fails
		}
	}

	@FXML
	fun createNewPersonEvent(event: ActionEvent) {
		val newPersonController = NewPersonController()
		uiController.loadFXML<Any>("i18n.newPerson", "/fxml/newPerson.fxml", newPersonController)
		newPersonController.showAndWait()
	}

	@FXML
	fun createNewProductEvent(event: ActionEvent) {

	}

	@FXML
	fun discardCartEvent(event: ActionEvent) {

	}

	@FXML
	fun loginLogout(event: ActionEvent) {
		if (uiController.controller.isLoggedIn.value ?: false) {
			toolBarLoginLogout?.text = resources?.getString("toolBar.login")
			uiController.controller.isLoggedIn.value = false
		} else {
			val loginController = LoginController()
			uiController.loadFXML<Any>("i18n.login", "/fxml/login.fxml", loginController)
			loginController.showAndWait()

			if (loginController.loginSuccess) {
				toolBarLoginLogout?.text = resources?.getString("toolBar.logout")
				uiController.controller.isLoggedIn.value = true
			}
		}
	}

	@FXML
	fun undoEvent(event: ActionEvent) {

	}

	@FXML
	fun redoEvent(event: ActionEvent) {

	}

	@FXML
	fun showHelpEvent(event: ActionEvent) {

	}

	@FXML
	fun showLogEvent(event: ActionEvent) {

	}

	@FXML
	fun showPersonDetailsEvent(event: ActionEvent) {

	}

	@FXML
	fun showFinancesEvent(event: ActionEvent) {
	}

	@FXML
	fun showStockEvent(event: ActionEvent) {
	}

	@FXML
	fun toggleNotesEvent(event: ActionEvent) {
		if(popUp.isShowing)
			popUp.hide()
		else
			popUp.show(toolBarNotes)
	}

	@FXML
	fun initialize() {
		toolBarLog?.disableProperty()?.bind(uiController.controller.isLoggedIn.not())
		toolBarNewPerson?.disableProperty()?.bind(uiController.controller.isLoggedIn.not())
		toolBarNewProduct?.disableProperty()?.bind(uiController.controller.isLoggedIn.not())
		toolBarLog?.disableProperty()?.bind(uiController.controller.isLoggedIn.not())
		toolBarFinances?.disableProperty()?.bind(uiController.controller.isLoggedIn.not())
		toolBarStock?.disableProperty()?.bind(uiController.controller.isLoggedIn.not())
		menuBarEditNewPerson?.disableProperty()?.bind(uiController.controller.isLoggedIn.not())
		menuBarEditNewProduct?.disableProperty()?.bind(uiController.controller.isLoggedIn.not())

		personTableFirstNameColumn?.cellValueFactory = PropertyValueFactory<Person, String>("firstName")
		personTableLastNameColumn?.cellValueFactory = PropertyValueFactory<Person, String>("lastName")
		personTableBalanceColumn?.cellValueFactory = PropertyValueFactory<Person, Double>("balance")
		personTable?.items = uiController.persons

		initNotesPopOver()
	}

	private fun initNotesPopOver() {
		popUp.arrowLocation = PopOver.ArrowLocation.TOP_RIGHT
		popUp.fadeInDuration = Duration(300.0)
		popUp.fadeOutDuration = Duration(300.0)
		popUp.isDetachable = true
		popUp.title = resources?.getString("toolBar.notes")
		textArea.prefHeight = 500.0
		textArea.font = Font.font(18.0)
		textArea.isWrapText = true
	}
}
