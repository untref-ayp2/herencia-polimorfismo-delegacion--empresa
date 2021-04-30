package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Gerente extends EmpleadeAbstracte {

	public Gerente(String nombre) {
		super(nombre, Categoria.GERENTE, Planta.PERMANENTE);
	}

}
