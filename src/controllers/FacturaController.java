package controllers;
import models.ItemCarrito;
import models.MainModel;
import views.FacturaView;

public class FacturaController {
	public FacturaController(FacturaView view, MainModel model) {
		String facturaText = "";
		
		for(ItemCarrito item : model.carrito.getItems().values()) {
			int cantidad = item.getCantidad();
			float precio = item.getPrecio();
			
			facturaText += cantidad + " x " + item.getDescripcion() + " ( " + precio + " ) " + "............................................" + cantidad * precio + "\n";
		}
		
		facturaText += "\n\n";
		
		facturaText += "Total " + model.carrito.getCantidadItems() + " items :" + model.carrito.getImporteTotal();
		
		view.setFacturaText(facturaText);
		
		view.setVisible(true);
	}
}
