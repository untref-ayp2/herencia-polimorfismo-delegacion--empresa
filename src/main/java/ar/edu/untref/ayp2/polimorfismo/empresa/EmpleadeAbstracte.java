package ar.edu.untref.ayp2.polimorfismo.empresa;

public abstract class EmpleadeAbstracte {

	private static final double ASIGNACION_PAREJA = 100.0;
	private static final double ASIGNACION_HIJO = 200.0;
	private static final double ANTIGUEDAD_ANUAL = 100.0;
	private static final double MAX_POR_ANTIGUEDAD = 2000.0;

	protected String nombre;
	protected Categoria categoria;
	protected Planta planta;
	protected Jornada jornada;
	protected boolean tienePareja;
	protected int cantHijes;
	protected int antiguedad;

	public EmpleadeAbstracte(String nombre, Categoria categoria, Planta planta, Jornada jornada, boolean tienePareja,
			int cantHijes, int antiguedad) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.planta = planta;
		this.jornada = jornada;
		this.tienePareja = tienePareja;
		this.cantHijes = cantHijes;
		this.antiguedad = antiguedad;
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

	protected double obtSueldo() {
		return obtSalarioBasico() + obtSalarioFamiliar() + obtAsigPorAntiguedad();
	}

	protected double obtSalarioBasico() {
		return jornada.obtSalarioBasico();
	}

	protected double obtAsigPorAntiguedad() {
		return Math.min(MAX_POR_ANTIGUEDAD, antiguedad * ANTIGUEDAD_ANUAL);
	}

	protected double obtSalarioFamiliar() {
		return (ASIGNACION_HIJO * cantHijes) + (tienePareja ? ASIGNACION_PAREJA : 0.0);
	}

}
