package ar.edu.untref.ayp2.polimorfismo.empresa;

public enum Jornada {
	COMPLETA("Jornada Completa"), PARCIAL("Media Jornada");

	private String descripcion;

	private Jornada(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}
}
