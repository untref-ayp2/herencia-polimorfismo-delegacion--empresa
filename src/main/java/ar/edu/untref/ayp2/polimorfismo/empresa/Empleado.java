package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Empleado {

	protected String nombre;
	protected String categoria;
	protected String planta;

	public Empleado(String nombre, String categoria, String planta) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.planta = planta;
	}

	@Override
	public String toString() {
		String catyP = String.join(", ", categoria, planta);
		catyP = "(" + catyP + ")";
		return String.join(" ", nombre, catyP);
	}

}
