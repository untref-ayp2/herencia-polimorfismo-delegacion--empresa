package ar.edu.untref.ayp2.polimorfismo.empresa;

public enum Categoria {
	GERENTE("Gerente"), SIN_CATEGORIA("Sin Categoría");

	private String descripcion;

	private Categoria(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}
}
