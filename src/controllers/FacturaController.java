package controllers;
import models.ItemCarrito;
import models.MainModel;
import views.FacturaView;

public class FacturaController {
	public FacturaController(FacturaView view, MainModel model) {
		String facturaText = "";
		
		for(ItemCarrito item : model.carrito.getItems().values()) {
			facturaText += item.getDescripcion() + "........" + item.getPrecio() + "\n";
		}
		
		view.setFacturaText(facturaText);
		
		view.setVisible(true);
	}
}
