package main.model

import javafx.beans.property.DoubleProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

data class Product(val name: StringProperty = SimpleStringProperty("", "name"),
				   val price: DoubleProperty = SimpleDoubleProperty(0.0, "price")) {
}