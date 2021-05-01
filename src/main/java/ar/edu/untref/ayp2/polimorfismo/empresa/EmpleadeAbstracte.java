package ar.edu.untref.ayp2.polimorfismo.empresa;

public abstract class EmpleadeAbstracte {

	private static final double ASIGNACION_PAREJA = 100.0;
	private static final double SALARIO_BASICO = 1000.0;
	private static final double ASIGNACION_HIJO = 200.0;

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

	public double obtSueldo() {
		return SALARIO_BASICO + obtSalarioFamiliar();
	}

	private double obtSalarioFamiliar() {
		return (ASIGNACION_HIJO * cantHijes) + (tienePareja ? ASIGNACION_PAREJA : 0.0);
	}

}
