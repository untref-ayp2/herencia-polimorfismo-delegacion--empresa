package ar.edu.untref.ayp2.polimorfismo.empresa;

import java.util.LinkedList;

public class Empresa {

	private LinkedList<EmpleadeAbstracte> empleados = new LinkedList<>();

	@Override
	public String toString() {
		String todo = "Cantidad de Empleades: " + empleados.size() + ".";

		for (EmpleadeAbstracte e : empleados) {
			todo = todo + "\n" + (empleados.indexOf(e) + 1) + ". " + e.toString();
		}

		return todo;
	}

	public boolean equals(Empresa otra) {
		return this.toString().equals(otra.toString());

	}

	// delegamos la responsabilidad de contratar a 'empleados'
	public void contratar(EmpleadeAbstracte miEmpleado) {
		empleados.add(miEmpleado);
	}

	public double obtTotalDeSueldos() {
		double sum = 0.0;
		for (EmpleadeAbstracte e : empleados)
			sum = sum + e.obtSueldo();
		return sum;
	}

}
