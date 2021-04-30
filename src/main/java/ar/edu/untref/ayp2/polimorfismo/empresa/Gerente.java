package ar.edu.untref.ayp2.polimorfismo.empresa;

public class Gerente extends EmpleadeAbstracte {

	public Gerente(String nombre, String planta) {
		super(nombre, Categoria.GERENTE, planta);
	}

}
