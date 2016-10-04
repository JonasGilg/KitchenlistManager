package main.model

import javafx.beans.property.DoubleProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

data class Person(val firstName: StringProperty = SimpleStringProperty("", "firstName"),
				  val lastName: StringProperty = SimpleStringProperty("", "lastName"),
				  val balance: DoubleProperty = SimpleDoubleProperty(0.0, "balance"),
				  val log: Log = Log()) {

	fun getFirstName() = firstName.value
	fun getLastName() = lastName.value
	fun getBalance() = balance.value

	fun setFirstName(firstName: String) = this.firstName.set(firstName)
	fun setLastName(lastName: String) = this.lastName.set(lastName)

	fun firstNameProperty() = firstName
	fun lastNameProperty() = lastName
	fun balanceProperty() = balance
}
