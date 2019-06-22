package models;

public class ItemCarrito extends Item {
	private int cantidad;

	public ItemCarrito(int itemId, String itemDescripcion, float itemPrecio, String itemFoto, int itemCantidad) {
		super(itemId, itemDescripcion, itemPrecio, itemFoto);
		
		cantidad = itemCantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
