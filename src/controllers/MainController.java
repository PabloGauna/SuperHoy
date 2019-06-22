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
	private MainView mainView;
	private MainModel mainModel;	

	public MainController(MainView view, MainModel model) {
		super();
		mainView = view;
		mainModel = model;
		
		view.ActualizarItemsTable(model);
	}
}
