package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Empleade extends EmpleadeAbstracte {

	public Empleade(String nombre, Planta planta, boolean tienePareja, int cantHijes, int antiguedad) {
		super(nombre, Categoria.SIN_CATEGORIA, planta, Jornada.COMPLETA, tienePareja, cantHijes, antiguedad);
	}

}
