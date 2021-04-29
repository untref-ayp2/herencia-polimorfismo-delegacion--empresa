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
	public void deboPoderMostrarUnaEmpresaConUnEmpleadoSinCategoriaDePlantaPermanenteJornadaCompleta() {
		Empresa miEmpresa = new Empresa();
		Empleado miEmpleado = new SinCategoria("Juan De Los Palotes", "Sin Categoría", "Planta Permanente",
				"Jornada Completa");
		miEmpresa.contratar(miEmpleado);
		String mostrar = "Cantidad de Empleados: 1." + "\n"
				+ "1. Juan De Los Palotes (Sin Categoría, Planta Permanente, Jornada Completa)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

	// Test de regresión: verificamos que todos los demás casos posibles lo sean
	@Test
	public void deboPoderMostrarUnaEmpresaConUnGerenteDePlantaPermanente() {
		Empresa miEmpresa = new Empresa();
		Empleado miEmpleado = new Gerente("Ana De la Cumbre", "Gerente", "Planta Permanente");
		miEmpresa.contratar(miEmpleado);
		String mostrar = "Cantidad de Empleados: 1." + "\n" + "1. Ana De la Cumbre (Gerente, Planta Permanente)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

	// Test de regresión: verificamos que todos los demás casos posibles lo sean
	@Test
	public void deboPoderMostrarUnaEmpresaConUnEmpleadoSinCategoriaContratadoJornadaCompleta() {
		Empresa miEmpresa = new Empresa();
		Empleado miEmpleado = new SinCategoria("Juan De Los Palotes", "Sin Categoría", "Contratado",
				"Jornada Completa");
		miEmpresa.contratar(miEmpleado);
		String mostrar = "Cantidad de Empleados: 1." + "\n"
				+ "1. Juan De Los Palotes (Sin Categoría, Contratado, Jornada Completa)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

	// Test de regresión (bis): verificamos que todos los nuevos casos posibles lo
	// sean
	@Test
	public void deboPoderMostrarUnaEmpresaConUnEmpleadoSinCategoriaContratadoMediaJornada() {
		Empresa miEmpresa = new Empresa();
		Empleado miEmpleado = new SinCategoria("Juan De Los Palotes", "Sin Categoría", "Contratado", "Media Jornada");
		miEmpresa.contratar(miEmpleado);
		String mostrar = "Cantidad de Empleados: 1." + "\n"
				+ "1. Juan De Los Palotes (Sin Categoría, Contratado, Media Jornada)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

	// Test de regresión (bis): verificamos que todos los nuevos casos posibles lo
	// sean
	@Test
	public void deboPoderMostrarUnaEmpresaConUnEmpleadoSinCategoriaDePlantaPermanenteMediaJornada() {
		Empresa miEmpresa = new Empresa();
		Empleado miEmpleado = new SinCategoria("Juan De Los Palotes", "Sin Categoría", "Planta Permanente",
				"Media Jornada");
		miEmpresa.contratar(miEmpleado);
		String mostrar = "Cantidad de Empleados: 1." + "\n"
				+ "1. Juan De Los Palotes (Sin Categoría, Planta Permanente, Media Jornada)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

}
