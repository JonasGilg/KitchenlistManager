package de.kitchenlist.model

import javafx.collections.FXCollections
import javafx.collections.ObservableMap

data class Cart(val products: ObservableMap<Product, Int> = FXCollections.observableHashMap()) {}