package models;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
	private List<Item> items;
	
	public Tienda() {
		items = new ArrayList<Item>();
		items.add(new Item("Leche", 20f, ""));
		items.add(new Item("Harina", 10f, ""));
		items.add(new Item("Yogurt", 25f, ""));
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
