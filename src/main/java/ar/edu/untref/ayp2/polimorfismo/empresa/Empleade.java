package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Empleade extends EmpleadeAbstracte {

	public Empleade(String nombre, Planta planta, Jornada jornada, boolean tienePareja, int cantHijes, int antiguedad) {
		super(nombre, Categoria.SIN_CATEGORIA, planta, jornada, tienePareja, cantHijes, antiguedad);
	}

	@Override
	public String toString() {
		String catPyJ = String.join(", ", categoria.toString(), planta.toString(), obtJornada().toString());
		catPyJ = "(" + catPyJ + ")";
		return String.join(" ", nombre, catPyJ);
	}

}
