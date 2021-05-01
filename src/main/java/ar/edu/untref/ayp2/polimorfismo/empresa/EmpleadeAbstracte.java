package ar.edu.untref.ayp2.polimorfismo.empresa;

public abstract class EmpleadeAbstracte {

	protected String nombre;
	protected Categoria categoria;
	protected Planta planta;
	protected Jornada jornada;

	public EmpleadeAbstracte(String nombre, Categoria categoria, Planta planta, Jornada jornada) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.planta = planta;
		this.jornada = jornada;
	}

	public Categoria obtCategoria() {
		return categoria;
	}

	public Planta obtPlanta() {
		return planta;
	}

	public Jornada obtJornada() {
		return jornada;
	}

}
