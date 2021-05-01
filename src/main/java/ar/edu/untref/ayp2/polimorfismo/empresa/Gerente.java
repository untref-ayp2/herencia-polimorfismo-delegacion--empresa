package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Gerente extends EmpleadeAbstracte {

	public Gerente(String nombre, boolean tienePareja, int cantHijes) {
		super(nombre, Categoria.GERENTE, Planta.PERMANENTE, Jornada.COMPLETA, tienePareja, cantHijes);
	}

	@Override
	public String toString() {
		String catyP = String.join(", ", categoria.toString(), planta.toString());
		catyP = "(" + catyP + ")";
		return String.join(" ", nombre, catyP);
	}

}
