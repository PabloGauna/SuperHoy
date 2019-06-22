package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Item;
import models.MainModel;
import vendor.ButtonColumn;
import views.MainView;

public class MainController {
	private MainView view;
	private MainModel model;	

	public MainController(MainView mainView, MainModel mainModel) {
		super();
		view = mainView;
		model = mainModel;
		
		view.ActualizarItemsTable(model);
	}

	public void agregarItemAlCarrito(int itemId) {
		Item item = model.tienda.getItem(itemId);
		model.carrito.agregarItem(item);
	}

	public void eliminarItemDelCarrito(int itemId) {
		Item item = model.tienda.getItem(itemId);
		model.carrito.removerItem(item);
	}
}
