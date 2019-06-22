package models;

public class Item {
	private String descripcion;
	private float precio;
	private String foto;

	public Item(String itemDescripcion, float itemPrecio, String itemFoto) {
		super();
		
		descripcion = itemDescripcion;
		precio = itemPrecio;
		foto = itemFoto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
}
