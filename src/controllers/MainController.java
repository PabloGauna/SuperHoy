package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Item;
import models.MainModel;
import views.FacturaView;
import views.MainView;

public class MainController {
	private MainView view;
	private MainModel model;	

	public MainController(MainView mainView, MainModel mainModel) {
		super();
		view = mainView;
		model = mainModel;
		
		view.adddFinalizarCompraActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				FacturaView facturaView = new FacturaView();
				FacturaController facturaController = new FacturaController(facturaView);
			}	
		});
		
		
		view.ActualizarItemsTable(model);
	}

	public void agregarItemAlCarrito(int itemId) {
		Item item = model.tienda.getItem(itemId);
		model.carrito.agregarItem(item);
		
		view.ActualizarBarraDeCarrito(model);
	}

	public void eliminarItemDelCarrito(int itemId) {
		Item item = model.tienda.getItem(itemId);
		model.carrito.removerItem(item);
		
		view.ActualizarBarraDeCarrito(model);
	}
}
