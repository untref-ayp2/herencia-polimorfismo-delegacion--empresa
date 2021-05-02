package ar.edu.untref.ayp2.polimorfismo.empresa;

public enum Jornada {
	COMPLETA("Jornada Completa") {
		@Override
		public double obtSalarioBasico() {
			return SALARIO_BASICO;
		}
	},
	PARCIAL("Media Jornada") {
		@Override
		public double obtSalarioBasico() {
			return Math.min(SALARIO_BASICO, SALARIO_BASICO / 3);
		}
	};

	private static final double SALARIO_BASICO = 1000.0;

	private String descripcion;

	private Jornada(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}

	abstract public double obtSalarioBasico();
}
