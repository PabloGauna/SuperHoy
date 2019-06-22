package models;

import java.util.HashMap;
import java.util.Map;

public class Carrito {
	private Map<Integer, ItemCarrito> items;
	
	public Carrito() {
		super();
		items = new HashMap<Integer, ItemCarrito>();
	}

	public void agregarItem(Item item) {
		ItemCarrito ic;
		if ((ic = items.get(item.getId())) == null)
		{
			ItemCarrito nuevoItemCarrito = new ItemCarrito(item.getId(), item.getDescripcion(), item.getPrecio(), item.getFoto(), 1);			
			items.put(nuevoItemCarrito.getId(), nuevoItemCarrito);
		}
		else {
			ic.setCantidad(ic.getCantidad() + 1);
		}
	}
	
	public void removerItem(Item item) {
		ItemCarrito ic = items.get(item.getId());
		
		if (ic.getCantidad() > 1) {
			ic.setCantidad(ic.getCantidad() - 1);
		}
		else {
			items.remove(item.getId());
		}
	}
}
