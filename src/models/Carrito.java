package models;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private List<Item> items;
	
	public Carrito() {
		super();
		items = new ArrayList<Item>();
	}

	public List<Item> getItems() {
		return items;
	}
}
