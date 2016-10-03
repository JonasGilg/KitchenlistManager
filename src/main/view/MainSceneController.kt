package main.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
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
	private lateinit var resources: ResourceBundle

	@FXML
	private lateinit var root: BorderPane

	@FXML
	private lateinit var menuBarEditUndo: MenuItem

	@FXML
	private lateinit var menuBarEditRedo: MenuItem

	@FXML
	private lateinit var menuBarEditNewPerson: MenuItem

	@FXML
	private lateinit var menuBarEditNewProduct: MenuItem

	@FXML
	private lateinit var toolBarNotes: Button

	@FXML
	private lateinit var toolBarLoginLogout: Button

	@FXML
	private lateinit var toolBarUndo: Button

	@FXML
	private lateinit var toolBarRedo: Button

	@FXML
	private lateinit var toolBarLog: Button

	@FXML
	private lateinit var toolBarNewPerson: Button

	@FXML
	private lateinit var toolBarNewProduct: Button

	@FXML
	private lateinit var toolBarStock: Button

	@FXML
	private lateinit var toolBarFinances: Button

	@FXML
	private lateinit var personTable: TableView<Person>

	@FXML
	private lateinit var personTableLastNameColumn: TableColumn<Person, String>

	@FXML
	private lateinit var personTableFirstNameColumn: TableColumn<Person, String>

	@FXML
	private lateinit var personTableBalanceColumn: TableColumn<Person, Double>

	@FXML
	private lateinit var buttonBarDetails: Button

	@FXML
	private lateinit var buttonBarInfo: Label

	@FXML
	private lateinit var buttonBarDiscard: Button

	@FXML
	private lateinit var buttonBarBuy: Button

	@FXML
	private lateinit var productTable: TableView<*>

	@FXML
	private lateinit var productTableProductColumn: TableColumn<*, *>

	@FXML
	private lateinit var productTablePriceColumn: TableColumn<*, *>

	@FXML
	private lateinit var productTableAmountColumn: TableColumn<*, *>

	@FXML
	fun buyCartEvent(event: ActionEvent) {
		println("buying")
	}

	@FXML
	fun closeApplicationEvent(event: ActionEvent) {
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
		if (uiController.controller.isLoggedIn.value) {
			toolBarLoginLogout.text = resources.getString("toolBar.login")
			uiController.controller.isLoggedIn.value = false
		} else {
			val loginController = LoginController()
			uiController.loadFXML<Any>("i18n.login", "/fxml/login.fxml", loginController)
			loginController.showAndWait()

			if (loginController.loginSuccess) {
				toolBarLoginLogout.text = resources.getString("toolBar.logout")
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
		toolBarLog.disableProperty().bind(uiController.controller.isLoggedIn.not())
		toolBarNewPerson.disableProperty().bind(uiController.controller.isLoggedIn.not())
		toolBarNewProduct.disableProperty().bind(uiController.controller.isLoggedIn.not())
		toolBarLog.disableProperty().bind(uiController.controller.isLoggedIn.not())
		toolBarFinances.disableProperty().bind(uiController.controller.isLoggedIn.not())
		toolBarStock.disableProperty().bind(uiController.controller.isLoggedIn.not())
		menuBarEditNewPerson.disableProperty().bind(uiController.controller.isLoggedIn.not())
		menuBarEditNewProduct.disableProperty().bind(uiController.controller.isLoggedIn.not())

		personTableFirstNameColumn.cellValueFactory = PropertyValueFactory<Person, String>("firstName")
		personTableLastNameColumn.cellValueFactory = PropertyValueFactory<Person, String>("lastName")
		personTableBalanceColumn.cellValueFactory = PropertyValueFactory<Person, Double>("balance")
		personTable.items = uiController.persons

		initNotesPopOver()
	}

	private fun initNotesPopOver() {
		popUp.arrowLocation = PopOver.ArrowLocation.TOP_RIGHT
		popUp.fadeInDuration = Duration(300.0)
		popUp.fadeOutDuration = Duration(300.0)
		popUp.isDetachable = true
		popUp.title = resources.getString("toolBar.notes")
		textArea.prefHeight = 500.0
		textArea.font = Font.font(18.0)
		textArea.isWrapText = true
	}
}
