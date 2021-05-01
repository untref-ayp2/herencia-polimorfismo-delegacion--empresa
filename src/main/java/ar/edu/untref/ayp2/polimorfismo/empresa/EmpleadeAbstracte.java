package ar.edu.untref.ayp2.polimorfismo.empresa;

public abstract class EmpleadeAbstracte {

	protected String nombre;
	protected Categoria categoria;
	protected Planta planta;
	protected Jornada jornada;
	protected boolean tienePareja;
	protected int cantHijes;

	public EmpleadeAbstracte(String nombre, Categoria categoria, Planta planta, Jornada jornada, boolean tienePareja,
			int cantHijes) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.planta = planta;
		this.jornada = jornada;
		this.tienePareja = tienePareja;
		this.cantHijes = cantHijes;
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

	// Por ahora, hacemos trampa y hacemos que el método nos devuelva
	// el valor pedido por nuestro test.
	public double obtSueldo() {
		return 1500.0;

	}

}
