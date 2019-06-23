package models;

import java.util.HashMap;
import java.util.Map;

public class Carrito {
	private Map<Integer, ItemCarrito> items;
	
	public Carrito() {
		super();
		items = new HashMap<Integer, ItemCarrito>();
	}
	
	public Map<Integer, ItemCarrito> getItems() {
		return items;
	}

	public void agregarItem(Item item) {
		ItemCarrito ic;
		int id = item.getId();
		
		if ((ic = items.get(id)) == null)
		{
			ItemCarrito nuevoItemCarrito = new ItemCarrito(id, item.getDescripcion(), item.getPrecio(), item.getFoto(), 1);			
			items.put(id, nuevoItemCarrito);
		}
		else {
			ic.setCantidad(ic.getCantidad() + 1);
		}
	}
	
	public void removerItem(Item item) {
		ItemCarrito ic;
		int id = item.getId();	
		
		if ((ic = items.get(id)) != null) {
		
			if (ic.getCantidad() > 1) {
				ic.setCantidad(ic.getCantidad() - 1);
			}
			else {
				items.remove(item.getId());
			}
		}
	}
	
	public int getCantidadItems() {
		int cantidad = 0;
		
		for (ItemCarrito i : items.values()) {
			cantidad += i.getCantidad();
		}
		
		return cantidad;
	}

	public float getImporteTotal() {
		float total = 0;
		
		for (ItemCarrito i : items.values()) {
			total += i.getPrecio() * i.getCantidad();
		}
		
		return total;
	}
}
