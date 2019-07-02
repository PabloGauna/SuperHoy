package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import models.Item;
import models.MainModel;

class ModelTest {
	MainModel model = new MainModel();

	@Test
	void AgregarItemAlCarrito() {
		model = new MainModel();
		
		model.carrito.agregarItem(new Item(101, "Leche", 25, ""));
		model.carrito.agregarItem(new Item(102, "Queso", 15, ""));
		
		assertEquals(40, model.carrito.getImporteTotal());
		assertEquals(2, model.carrito.getCantidadItems());
	}
	
	@Test
	void EliminarItemDelCarrito() {
		model = new MainModel();
		
		Item itemLeche = new Item(101, "Leche", 25, "");
		Item itemQueso = new Item(102, "Queso", 15, "");
			
		model.carrito.agregarItem(itemLeche);
		model.carrito.agregarItem(itemQueso);
		
		model.carrito.removerItem(itemLeche);
		
		assertEquals(15, model.carrito.getImporteTotal());
		assertEquals(1, model.carrito.getCantidadItems());
	}

}
