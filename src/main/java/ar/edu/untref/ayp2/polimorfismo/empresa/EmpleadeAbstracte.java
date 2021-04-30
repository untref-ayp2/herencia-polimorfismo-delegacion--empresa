package ar.edu.untref.ayp2.polimorfismo.empresa;

public abstract class EmpleadeAbstracte {

	protected String nombre;
	protected Categoria categoria;
	protected Planta planta;

	public EmpleadeAbstracte(String nombre, Categoria categoria, Planta planta) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.planta = planta;
	}

	@Override
	public String toString() {
		String catyP = String.join(", ", categoria.toString(), planta.toString());
		catyP = "(" + catyP + ")";
		return String.join(" ", nombre, catyP);
	}

	public Categoria obtCategoria() {
		return categoria;
	}

	public Planta obtPlanta() {
		return planta;
	}

}
