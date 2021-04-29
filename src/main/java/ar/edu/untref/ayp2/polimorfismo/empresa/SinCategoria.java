package ar.edu.untref.ayp2.polimorfismo.empresa;

public class SinCategoria extends Empleado {
	private String jornada;

	public SinCategoria(String nombre, String categoria, String planta, String jornada) {
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
