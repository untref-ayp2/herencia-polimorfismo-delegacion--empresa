package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Empleade extends EmpleadeAbstracte {

	public Empleade(String nombre, Planta planta, Jornada jornada, boolean tienePareja, int cantHijes) {
		super(nombre, Categoria.SIN_CATEGORIA, planta, jornada, tienePareja, cantHijes);
	}

	@Override
	public String toString() {
		String catPyJ = String.join(", ", categoria.toString(), planta.toString(), obtJornada().toString());
		catPyJ = "(" + catPyJ + ")";
		return String.join(" ", nombre, catPyJ);
	}

}
