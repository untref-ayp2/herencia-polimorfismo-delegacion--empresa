package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Empleade extends EmpleadeAbstracte {

	public Empleade(String nombre, Planta planta, Jornada jornada) {
		super(nombre, Categoria.SIN_CATEGORIA, planta, jornada);
	}

	@Override
	public String toString() {
		String catPyJ = String.join(", ", categoria.toString(), planta.toString(), obtJornada().toString());
		catPyJ = "(" + catPyJ + ")";
		return String.join(" ", nombre, catPyJ);
	}

}
