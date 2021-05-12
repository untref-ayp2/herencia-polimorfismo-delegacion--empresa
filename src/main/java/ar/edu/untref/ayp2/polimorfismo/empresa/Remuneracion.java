package ar.edu.untref.ayp2.polimorfismo.empresa;

public enum Remuneracion {
	POR_MES("Por Mes"), POR_HORAS("Por Horas");

	private String descripcion;

	private Remuneracion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}

}
