package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Empleade extends EmpleadeAbstracte {
	private String jornada;

	public Empleade(String nombre, String categoria, String planta, String jornada) {
		super(nombre, categoria, planta);
		this.jornada = jornada;
	}

	@Override
	public String toString() {
		String catPyJ = String.join(", ", categoria, planta, jornada);
		catPyJ = "(" + catPyJ + ")";
		return String.join(" ", nombre, catPyJ);
	}

}
