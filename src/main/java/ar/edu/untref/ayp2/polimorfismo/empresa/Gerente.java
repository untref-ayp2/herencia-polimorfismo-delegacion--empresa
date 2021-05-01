package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Gerente extends EmpleadeAbstracte {

	public Gerente(String nombre) {
		super(nombre, Categoria.GERENTE, Planta.PERMANENTE, Jornada.COMPLETA);
	}

	@Override
	public String toString() {
		String catyP = String.join(", ", categoria.toString(), planta.toString());
		catyP = "(" + catyP + ")";
		return String.join(" ", nombre, catyP);
	}

}
