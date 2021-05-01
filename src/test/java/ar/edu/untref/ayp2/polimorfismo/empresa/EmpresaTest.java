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

		// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
		// al test son más legibles.
		// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
		boolean conPareja = true;
		boolean sinPareja = false;

		// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
		// para crear nuevos tests.
		int dosHijes = 2;

		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.PERMANENTE, Jornada.COMPLETA,
				conPareja, dosHijes);
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

		// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
		// al test son más legibles.
		// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
		boolean conPareja = true;
		boolean sinPareja = false;

		// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
		// para crear nuevos tests.
		int dosHijes = 2;
		int sinHijes = 0;

		EmpleadeAbstracte miEmpleade = new Gerente("Ana De la Cumbre", sinPareja, sinHijes);
		miEmpresa.contratar(miEmpleade);
		String mostrar = "Cantidad de Empleades: 1." + "\n" + "1. Ana De la Cumbre (Gerente, Planta Permanente)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

	// Test de regresión: verificamos que todos los demás casos posibles lo sean
	@Test
	public void deboPoderMostrarUnaEmpresaConUnEmpleadeSinCategoriaContratadoJornadaCompleta() {
		Empresa miEmpresa = new Empresa();

		// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
		// al test son más legibles.
		// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
		boolean conPareja = true;
		boolean sinPareja = false;

		// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
		// para crear nuevos tests.
		int dosHijes = 2;

		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA, Jornada.COMPLETA,
				sinPareja, dosHijes);
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

		// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
		// al test son más legibles.
		// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
		boolean conPareja = true;
		boolean sinPareja = false;

		// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
		// para crear nuevos tests.
		int dosHijes = 2;

		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA, Jornada.PARCIAL,
				sinPareja, dosHijes);
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

		// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
		// al test son más legibles.
		// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
		boolean conPareja = true;
		boolean sinPareja = false;

		// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
		// para crear nuevos tests.
		int dosHijes = 2;

		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.PERMANENTE, Jornada.PARCIAL,
				sinPareja, dosHijes);
		miEmpresa.contratar(miEmpleade);
		String mostrar = "Cantidad de Empleades: 1." + "\n"
				+ "1. Juan De Los Palotes (Sin Categoría, Planta Permanente, Media Jornada)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

	// Comenzamos con la validación de datos...
	@Test
	public void categoriaDeEmpleadeSoloPuedeSerSinCantegoria() {

		// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
		// al test son más legibles.
		// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
		boolean conPareja = true;
		boolean sinPareja = false;

		// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
		// para crear nuevos tests.
		int dosHijes = 2;

		EmpleadeAbstracte empleadeValideSinCategoria = new Empleade("Juan De Los Palotes", Planta.PERMANENTE,
				Jornada.COMPLETA, sinPareja, dosHijes);

		assertEquals(Categoria.SIN_CATEGORIA, empleadeValideSinCategoria.obtCategoria());
	}

	// Comenzamos con la validación de datos...
	@Test
	public void categoriaDeGerenteSoloPuedeSerGerente() {

		// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
		// al test son más legibles.
		// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
		boolean conPareja = true;
		boolean sinPareja = false;

		// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
		// para crear nuevos tests.
		int dosHijes = 2;
		int sinHijes = 0;

		EmpleadeAbstracte empleadeValideGerente = new Gerente("Ana De la Cumbre", sinPareja, sinHijes);

		assertEquals(Categoria.GERENTE, empleadeValideGerente.obtCategoria());
	}

	// Validación de datos (bis)
	@Test
	public void plantaDeGerenteSoloPuedeSerPermanente() {

		// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
		// al test son más legibles.
		// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
		boolean conPareja = true;
		boolean sinPareja = false;

		// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
		// para crear nuevos tests.
		int dosHijes = 2;
		int sinHijes = 0;

		EmpleadeAbstracte empleadeValideGerente = new Gerente("Ana De la Cumbre", conPareja, sinHijes);

		assertEquals(Planta.PERMANENTE, empleadeValideGerente.obtPlanta());
	}

	// Validación de datos (bis)
	@Test
	public void plantaDeEmpleadeSoloPuedeSerPermanenteOTemporaria() {

		// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
		// al test son más legibles.
		// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
		boolean conPareja = true;
		boolean sinPareja = false;

		// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
		// para crear nuevos tests.
		int dosHijes = 2;

		EmpleadeAbstracte empleadeValideSinCategoriaPermanente = new Empleade("Juan De Los Palotes", Planta.PERMANENTE,
				Jornada.COMPLETA, conPareja, dosHijes);
		EmpleadeAbstracte empleadeValideSinCategoriaTemporarie = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA,
				Jornada.COMPLETA, conPareja, dosHijes);

		// La siguiente línea da error de compilación
		// assertEquals(Planta.OTRA, empleadeValideSinCategoriaTemporarie.obtPlanta());

		assertEquals(Planta.PERMANENTE, empleadeValideSinCategoriaPermanente.obtPlanta());
		assertEquals(Planta.TEMPORARIA, empleadeValideSinCategoriaTemporarie.obtPlanta());

	}

	// Validación de datos (bis)
	@Test
	public void jornadaDeEmpleadePuedeSerSoloCompletaOParcial() {

		// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
		// al test son más legibles.
		// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
		boolean conPareja = true;
		boolean sinPareja = false;

		// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
		// para crear nuevos tests.
		int dosHijes = 2;

		EmpleadeAbstracte empleadeValideSinCategoriaPermanente = new Empleade("Juan De Los Palotes", Planta.PERMANENTE,
				Jornada.COMPLETA, conPareja, dosHijes);
		EmpleadeAbstracte empleadeValideSinCategoriaTemporarie = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA,
				Jornada.PARCIAL, sinPareja, dosHijes);

		// La siguiente línea da error de compilación
		// assertEquals(Jornada.NI, empleadeValideSinCategoriaPermanente.obtJornada());

		assertEquals(Jornada.COMPLETA, empleadeValideSinCategoriaPermanente.obtJornada());
		assertEquals(Jornada.PARCIAL, empleadeValideSinCategoriaTemporarie.obtJornada());
	}

	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaTemporariaTiempoCompletoConParejaDosHijes() {

		Empresa miEmpresa = new Empresa();

		// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
		// al test son más legibles.
		// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
		boolean conPareja = true;
		boolean sinPareja = false;

		// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
		// para crear nuevos tests.
		int dosHijes = 2;

		// Luego, simplemente leyendo esta línea tenemos una idea de exactamente qué
		// estamos probando.
		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaDosHijes = new Empleade(
				"Juan De Los Palotes", Planta.TEMPORARIA, Jornada.COMPLETA, conPareja, dosHijes);
		miEmpresa.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaDosHijes);

		// El Cálculo para Empleade Planta Temporaria Jornada Completa:
		// Sueldo Básico + Salario Familiar

		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// En este caso, 1500 = 1000.0 + 200.0 * 2 + 100.0

		assertEquals(1500, miEmpresa.obtTotalDeSueldos());
	}

	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaTemporariaTiempoCompletoSinParejaDosHijes() {

		Empresa miEmpresa = new Empresa();

		// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
		// al test son más legibles.
		// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
		boolean conPareja = true;
		boolean sinPareja = false;

		// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
		// para crear nuevos tests.
		int dosHijes = 2;

		// Luego, simplemente leyendo esta línea tenemos una idea de exactamente qué
		// estamos probando.
		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaDosHijes = new Empleade(
				"Juan De Los Palotes", Planta.TEMPORARIA, Jornada.COMPLETA, sinPareja, dosHijes);
		miEmpresa.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaDosHijes);

		// El Cálculo para Empleade Planta Temporaria Jornada Completa:
		// Sueldo Básico + Salario Familiar

		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// En este caso, 1400 = 1000.0 + 200.0 * 2

		assertEquals(1400, miEmpresa.obtTotalDeSueldos());
	}

}
