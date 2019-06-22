package models;

public class MainModel {
	public Tienda tienda;
	public Carrito carrito;

	public MainModel() {
		super();
		
		tienda = new Tienda();
		carrito = new Carrito();
	}
}
