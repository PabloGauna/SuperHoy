package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tienda {
	private Map<Integer, Item> items;
	
	public Tienda() {
		items = new HashMap<Integer, Item>();
		items.put(100, new Item(100, "Leche", 20f, ""));
		items.put(101,new Item(101, "Harina", 10f, ""));
		items.put(102,new Item(102, "Yogurt", 25f, ""));
	}

	public Map<Integer, Item> getItems() {
		return items;
	}

	public Item getItem(int id) {
		return items.get(id);
	}
}
