package ar.edu.untref.ayp2.polimorfismo.empresa;

public abstract class EmpleadeAbstracte {

	private static final double SALARIO_BASICO_NOMINAL = 1000.0;
	private static final double ASIGNACION_PAREJA = 100.0;
	private static final double ASIGNACION_HIJO = 200.0;
	private static final double ANTIGUEDAD_ANUAL = 100.0;
	private static final double MAX_POR_ANTIGUEDAD = 2000.0;
	private static final double VALOR_HORA = 10.0;

	protected String nombre;
	protected Categoria categoria;
	protected Planta planta;
	protected Remuneracion remuneracion;
	protected boolean tienePareja;
	protected int cantHijes;
	protected int antiguedad;

	public EmpleadeAbstracte(String nombre, Categoria categoria, Planta planta, Remuneracion jornada, boolean tienePareja,
			int cantHijes, int antiguedad) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.planta = planta;
		this.remuneracion = jornada;
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

	public Remuneracion obtRemuneracion() {
		return remuneracion;
	}

	@Override
	public String toString() {
		String atributos = String.join(", ", categoria.toString(), planta.toString(), remuneracion.toString());
		atributos = "(" + atributos + ")";
		return String.join(" ", nombre, atributos);
	}

	protected double obtSueldo() {
		return obtSalarioBasico() + obtSalarioFamiliar() + obtAsigPorAntiguedad();
	}

	protected double obtSalarioBasico() {
		return SALARIO_BASICO_NOMINAL;
	}

	protected double obtAsigPorAntiguedad() {
		return Math.min(MAX_POR_ANTIGUEDAD, antiguedad * ANTIGUEDAD_ANUAL);
	}

	protected double obtSalarioFamiliar() {
		return (ASIGNACION_HIJO * cantHijes) + (tienePareja ? ASIGNACION_PAREJA : 0.0);
	}

	protected double obtValorHora() {
		return VALOR_HORA;
	}

}
