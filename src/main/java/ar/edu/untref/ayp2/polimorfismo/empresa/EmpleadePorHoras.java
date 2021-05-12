package ar.edu.untref.ayp2.polimorfismo.empresa;

public class EmpleadePorHoras extends EmpleadeAbstracte {

	private double horasTrabajadas;

	public EmpleadePorHoras(String nombre, Planta planta, boolean tienePareja, int cantHijes, int antiguedad,
			double horasTrabajadas) {
		super(nombre, Categoria.SIN_CATEGORIA, planta, Jornada.PARCIAL, tienePareja, cantHijes, antiguedad);
		this.horasTrabajadas = horasTrabajadas;
	}

	@Override
	public double obtSalarioBasico() {
		return Math.min(super.obtSalarioBasico(), super.obtSalarioBasico() / 3 + horasTrabajadas * obtValorHora());
	}

}
