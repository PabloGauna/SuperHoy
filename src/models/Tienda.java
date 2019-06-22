package models;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
	private List<Item> items;
	
	public Tienda() {
		items = new ArrayList<Item>();
		items.add(new Item(100, "Leche", 20f, ""));
		items.add(new Item(101, "Harina", 10f, ""));
		items.add(new Item(102, "Yogurt", 25f, ""));
	}

	public List<Item> getItems() {
		return items;
	}
}
