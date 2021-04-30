package ar.edu.untref.ayp2.polimorfismo.empresa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class EmpresaTest {

	@Test
	public void empresaTest() {
		assertTrue(true);
	}

	@Test
	public void deboPoderCrearUnaEmpresaSinEmpleados() {
		Empresa miEmpresa = new Empresa();
		assertNotNull(miEmpresa);
	}

	@Test
	public void deboPoderMostrarUnaEmpresaSinEmpleados() {
		Empresa miEmpresa = new Empresa();
		String mostrar = "Cantidad de Empleados: 0.";

		assertEquals(mostrar, miEmpresa.toString());
	}

	// Acá empieza el verdadero trabajo
	@Test
	public void deboPoderMostrarUnaEmpresaConUnEmpleadoSinCategoriaDePlantaPermanente() {
		Empresa miEmpresa = new Empresa();
		Empleado miEmpleado = new Empleado("Juan De Los Palotes", "Sin Categoría", "Planta Permanente");
		miEmpresa.contratar(miEmpleado);
		String mostrar = "Cantidad de Empleados: 1." + "\n"
				+ "1. Juan De Los Palotes (Sin Categoría, Planta Permanente)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

}
