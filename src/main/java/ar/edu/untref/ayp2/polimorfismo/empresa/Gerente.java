package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Gerente extends EmpleadeAbstracte {

	private static final double ASIGNACION_POR_SUBALTERNOS = 2000.0;

	public Gerente(String nombre, boolean tienePareja, int cantHijes, int antiguedad) {
		super(nombre, Categoria.GERENTE, Planta.PERMANENTE, Jornada.COMPLETA, tienePareja, cantHijes, antiguedad);
	}

	@Override
	public String toString() {
		String catyP = String.join(", ", categoria.toString(), planta.toString());
		catyP = "(" + catyP + ")";
		return String.join(" ", nombre, catyP);
	}

	@Override
	public double obtSueldo() {
		return super.obtSueldo() + ASIGNACION_POR_SUBALTERNOS;
	}

}
