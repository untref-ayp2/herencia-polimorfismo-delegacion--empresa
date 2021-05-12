package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Gerente extends EmpleadeAbstracte {

	private static final double ASIGNACION_POR_SUBALTERNOS = 2000.0;

	public Gerente(String nombre, boolean tienePareja, int cantHijes, int antiguedad) {
		super(nombre, Categoria.GERENTE, Planta.PERMANENTE, Remuneracion.POR_MES, tienePareja, cantHijes, antiguedad);
	}

	@Override
	public String toString() {
		String atributos = String.join(", ", categoria.toString(), planta.toString());
		atributos = "(" + atributos + ")";
		return String.join(" ", nombre, atributos);
	}

	@Override
	public double obtSueldo() {
		return super.obtSueldo() + ASIGNACION_POR_SUBALTERNOS;
	}

}
