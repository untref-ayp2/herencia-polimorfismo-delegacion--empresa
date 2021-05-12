package ar.edu.untref.ayp2.polimorfismo.empresa;

public class EmpleadePorMes extends EmpleadeAbstracte {

	public EmpleadePorMes(String nombre, Planta planta, boolean tienePareja, int cantHijes, int antiguedad) {
		super(nombre, Categoria.SIN_CATEGORIA, planta, Remuneracion.POR_MES, tienePareja, cantHijes, antiguedad);
	}

}
