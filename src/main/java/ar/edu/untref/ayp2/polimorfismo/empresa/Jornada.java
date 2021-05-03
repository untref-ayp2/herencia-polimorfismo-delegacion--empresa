package ar.edu.untref.ayp2.polimorfismo.empresa;

public enum Jornada {
	COMPLETA("Jornada Completa") {
		@Override
		public double calcularSalarioBasicoEfectivo(double salarioBasicoNominal) {
			return salarioBasicoNominal;
		}
	},
	PARCIAL("Media Jornada") {
		@Override
		public double calcularSalarioBasicoEfectivo(double salarioBasicoNominal) {
			return Math.min(salarioBasicoNominal, salarioBasicoNominal / 3);
		}
	};

	private String descripcion;

	private Jornada(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}

	abstract public double calcularSalarioBasicoEfectivo(double salarioBasicoNominal);
}
