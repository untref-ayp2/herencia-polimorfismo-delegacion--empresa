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
	public void deboPoderCrearUnaEmpresaSinEmpleades() {
		Empresa miEmpresa = new Empresa();
		assertNotNull(miEmpresa);
	}

	@Test
	public void deboPoderMostrarUnaEmpresaSinEmpleades() {
		Empresa miEmpresa = new Empresa();
		String mostrar = "Cantidad de Empleades: 0.";

		assertEquals(mostrar, miEmpresa.toString());
	}

	// Acá empieza el verdadero trabajo
	@Test
	public void deboPoderMostrarUnaEmpresaConUnEmpleadeSinCategoriaDePlantaPermanenteJornadaCompleta() {
		Empresa miEmpresa = new Empresa();
		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.PERMANENTE, Jornada.COMPLETA);
		miEmpresa.contratar(miEmpleade);
		String mostrar = "Cantidad de Empleades: 1." + "\n"
				+ "1. Juan De Los Palotes (Sin Categoría, Planta Permanente, Jornada Completa)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

	// Test de regresión: verificamos que todos los demás casos posibles lo sean
	@Test
	public void deboPoderMostrarUnaEmpresaConUnGerenteDePlantaPermanente() {
		Empresa miEmpresa = new Empresa();
		EmpleadeAbstracte miEmpleade = new Gerente("Ana De la Cumbre");
		miEmpresa.contratar(miEmpleade);
		String mostrar = "Cantidad de Empleades: 1." + "\n" + "1. Ana De la Cumbre (Gerente, Planta Permanente)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

	// Test de regresión: verificamos que todos los demás casos posibles lo sean
	@Test
	public void deboPoderMostrarUnaEmpresaConUnEmpleadeSinCategoriaContratadoJornadaCompleta() {
		Empresa miEmpresa = new Empresa();
		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA, Jornada.COMPLETA);
		miEmpresa.contratar(miEmpleade);
		String mostrar = "Cantidad de Empleades: 1." + "\n"
				+ "1. Juan De Los Palotes (Sin Categoría, Planta Temporaria, Jornada Completa)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

	// Test de regresión (bis): verificamos que todos los nuevos casos posibles lo
	// sean
	@Test
	public void deboPoderMostrarUnaEmpresaConUnEmpleadeSinCategoriaContratadoMediaJornada() {
		Empresa miEmpresa = new Empresa();
		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA, Jornada.PARCIAL);
		miEmpresa.contratar(miEmpleade);
		String mostrar = "Cantidad de Empleades: 1." + "\n"
				+ "1. Juan De Los Palotes (Sin Categoría, Planta Temporaria, Media Jornada)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

	// Test de regresión (bis): verificamos que todos los nuevos casos posibles lo
	// sean
	@Test
	public void deboPoderMostrarUnaEmpresaConUnEmpleadeSinCategoriaDePlantaPermanenteMediaJornada() {
		Empresa miEmpresa = new Empresa();
		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.PERMANENTE, Jornada.PARCIAL);
		miEmpresa.contratar(miEmpleade);
		String mostrar = "Cantidad de Empleades: 1." + "\n"
				+ "1. Juan De Los Palotes (Sin Categoría, Planta Permanente, Media Jornada)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

	// Comenzamos con la validación de datos...
	@Test
	public void categoriaDeEmpleadeSoloPuedeSerSinCantegoria() {

		EmpleadeAbstracte empleadeValideSinCategoria = new Empleade("Juan De Los Palotes", Planta.PERMANENTE,
				Jornada.COMPLETA);

		assertEquals(Categoria.SIN_CATEGORIA, empleadeValideSinCategoria.obtCategoria());
	}

	// Comenzamos con la validación de datos...
	@Test
	public void categoriaDeGerenteSoloPuedeSerGerente() {

		EmpleadeAbstracte empleadeValideGerente = new Gerente("Ana De la Cumbre");

		assertEquals(Categoria.GERENTE, empleadeValideGerente.obtCategoria());
	}

	// Validación de datos (bis)
	@Test
	public void plantaDeGerenteSoloPuedeSerPermanente() {

		EmpleadeAbstracte empleadeValideGerente = new Gerente("Ana De la Cumbre");

		assertEquals(Planta.PERMANENTE, empleadeValideGerente.obtPlanta());
	}

	// Validación de datos (bis)
	@Test
	public void plantaDeEmpleadeSoloPuedeSerPermanenteOTemporaria() {

		EmpleadeAbstracte empleadeValideSinCategoriaPermanente = new Empleade("Juan De Los Palotes", Planta.PERMANENTE,
				Jornada.COMPLETA);
		EmpleadeAbstracte empleadeValideSinCategoriaTemporarie = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA,
				Jornada.COMPLETA);

		// La siguiente línea da error de compilación
		// assertEquals(Planta.OTRA, empleadeValideSinCategoriaTemporarie.obtPlanta());

		assertEquals(Planta.PERMANENTE, empleadeValideSinCategoriaPermanente.obtPlanta());
		assertEquals(Planta.TEMPORARIA, empleadeValideSinCategoriaTemporarie.obtPlanta());

	}

	// Validación de datos (bis)
	@Test
	public void jornadaDeEmpleadePuedeSerSoloCompletaOParcial() {

		EmpleadeAbstracte empleadeValideSinCategoriaPermanente = new Empleade("Juan De Los Palotes", Planta.PERMANENTE,
				Jornada.COMPLETA);
		EmpleadeAbstracte empleadeValideSinCategoriaTemporarie = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA,
				Jornada.PARCIAL);

		// La siguiente línea da error de compilación
		// assertEquals(Jornada.NI, empleadeValideSinCategoriaPermanente.obtJornada());

		assertEquals(Jornada.COMPLETA, empleadeValideSinCategoriaPermanente.obtJornada());
		assertEquals(Jornada.PARCIAL, empleadeValideSinCategoriaTemporarie.obtJornada());
	}

}
