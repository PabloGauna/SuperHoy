package models;

import java.util.List;

public class Carrito {
	private List<Item> items;
	
	public Carrito() {
		super();
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
