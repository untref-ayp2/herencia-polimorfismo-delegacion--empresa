package ar.edu.untref.ayp2.polimorfismo.empresa;

public abstract class EmpleadeAbstracte {

	protected String nombre;
	protected Categoria categoria;
	protected String planta;

	public EmpleadeAbstracte(String nombre, Categoria categoria, String planta) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.planta = planta;
	}

	@Override
	public String toString() {
		String catyP = String.join(", ", categoria.toString(), planta);
		catyP = "(" + catyP + ")";
		return String.join(" ", nombre, catyP);
	}

	public Categoria obtCategoria() {
		return categoria;
	}

}
