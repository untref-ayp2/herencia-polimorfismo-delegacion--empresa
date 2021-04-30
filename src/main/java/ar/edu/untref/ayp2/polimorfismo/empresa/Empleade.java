package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Empleade extends EmpleadeAbstracte {
	private String jornada;

	public Empleade(String nombre, Planta planta, String jornada) {
		super(nombre, Categoria.SIN_CATEGORIA, planta);
		this.jornada = jornada;
	}

	@Override
	public String toString() {
		String catPyJ = String.join(", ", categoria.toString(), planta.toString(), jornada);
		catPyJ = "(" + catPyJ + ")";
		return String.join(" ", nombre, catPyJ);
	}

}
