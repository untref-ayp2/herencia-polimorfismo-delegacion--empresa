package ar.edu.untref.ayp2.polimorfismo.empresa;

public enum Planta {
	PERMANENTE("Planta Permanente"), TEMPORARIA("Planta Temporaria");

	private String descripcion;

	private Planta(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}
}
