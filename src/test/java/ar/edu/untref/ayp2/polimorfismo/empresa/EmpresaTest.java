package ar.edu.untref.ayp2.polimorfismo.empresa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class EmpresaTest {

	// Al predefinir estos valores booleanos, los nombres de los parámetros enviados
	// al test son más legibles.
	// Además, pueden cambiarse muy fácilmente luego, en caso de refactorizar.
	private static final boolean SIN_PAREJA = false;
	private static final boolean CON_PAREJA = true;

	// Al predefinir algunos valores numéricos, es muy fácil cambiarles el valor
	// (y/o nombre) para crear nuevos tests.
	// Excepto el 0 y algún otro valor especial, todos los números son primos.
	// Esto es bueno para disminuir la posibilidad de repetir resultados.
	private static final int SIN_HIJES = 0;
	private static final int UN_HIJE = 1;
	private static final int DOS_HIJES = 2;
	private static final int TRES_HIJES = 3;

	// ANTIGÜEDAD
	//
	// Este valor nos sirve para que los tests anteriores sigan funcionando.
	private static final int SIN_ANTIGUEDAD = 0;

	// Este valor es el necesario para verificar el caso más simple posible.
	private static final int ANTIGUEDAD_1 = 1;

	// Este valor nos da un resultado menor al máximo computable por antigüedad.
	private static final int ANTIGUEDAD_13 = 13;

	// Este valor nos da un resultado igual al máximo computable por antigüedad.
	private static final int ANTIGUEDAD_20 = 20;

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

		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.PERMANENTE, Jornada.COMPLETA,
				CON_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);
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

		EmpleadeAbstracte miEmpleade = new Gerente("Ana De la Cumbre", SIN_PAREJA, SIN_HIJES, SIN_ANTIGUEDAD);
		miEmpresa.contratar(miEmpleade);
		String mostrar = "Cantidad de Empleades: 1." + "\n" + "1. Ana De la Cumbre (Gerente, Planta Permanente)";
		// System.out.println(miEmpresa.toString());
		assertEquals(mostrar, miEmpresa.toString());
	}

	// Test de regresión: verificamos que todos los demás casos posibles lo sean
	@Test
	public void deboPoderMostrarUnaEmpresaConUnEmpleadeSinCategoriaContratadoJornadaCompleta() {
		Empresa miEmpresa = new Empresa();

		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA, Jornada.COMPLETA,
				SIN_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);
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

		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA, Jornada.PARCIAL,
				SIN_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);
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

		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.PERMANENTE, Jornada.PARCIAL,
				SIN_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);
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
				Jornada.COMPLETA, SIN_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);

		assertEquals(Categoria.SIN_CATEGORIA, empleadeValideSinCategoria.obtCategoria());
	}

	// Comenzamos con la validación de datos...
	@Test
	public void categoriaDeGerenteSoloPuedeSerGerente() {

		EmpleadeAbstracte empleadeValideGerente = new Gerente("Ana De la Cumbre", SIN_PAREJA, SIN_HIJES,
				SIN_ANTIGUEDAD);

		assertEquals(Categoria.GERENTE, empleadeValideGerente.obtCategoria());
	}

	// Validación de datos (bis)
	@Test
	public void plantaDeGerenteSoloPuedeSerPermanente() {

		EmpleadeAbstracte empleadeValideGerente = new Gerente("Ana De la Cumbre", CON_PAREJA, SIN_HIJES,
				SIN_ANTIGUEDAD);

		assertEquals(Planta.PERMANENTE, empleadeValideGerente.obtPlanta());
	}

	// Validación de datos (bis)
	@Test
	public void plantaDeEmpleadeSoloPuedeSerPermanenteOTemporaria() {

		EmpleadeAbstracte empleadeValideSinCategoriaPermanente = new Empleade("Juan De Los Palotes", Planta.PERMANENTE,
				Jornada.COMPLETA, CON_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);
		EmpleadeAbstracte empleadeValideSinCategoriaTemporarie = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA,
				Jornada.COMPLETA, CON_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);

		// La siguiente línea da error de compilación
		// assertEquals(Planta.OTRA, empleadeValideSinCategoriaTemporarie.obtPlanta());

		assertEquals(Planta.PERMANENTE, empleadeValideSinCategoriaPermanente.obtPlanta());
		assertEquals(Planta.TEMPORARIA, empleadeValideSinCategoriaTemporarie.obtPlanta());

	}

	// Validación de datos (bis)
	@Test
	public void jornadaDeEmpleadePuedeSerSoloCompletaOParcial() {

		EmpleadeAbstracte empleadeValideSinCategoriaPermanente = new Empleade("Juan De Los Palotes", Planta.PERMANENTE,
				Jornada.COMPLETA, SIN_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);
		EmpleadeAbstracte empleadeValideSinCategoriaTemporarie = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA,
				Jornada.PARCIAL, SIN_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);

		// La siguiente línea da error de compilación
		// assertEquals(Jornada.NI, empleadeValideSinCategoriaPermanente.obtJornada());

		assertEquals(Jornada.COMPLETA, empleadeValideSinCategoriaPermanente.obtJornada());
		assertEquals(Jornada.PARCIAL, empleadeValideSinCategoriaTemporarie.obtJornada());
	}

	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaTemporariaTiempoCompletoConParejaDosHijes() {

		Empresa miEmpresa = new Empresa();

		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaDosHijes = new Empleade(
				"Juan De Los Palotes", Planta.TEMPORARIA, Jornada.COMPLETA, CON_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);
		miEmpresa.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaDosHijes);

		// El Cálculo para Empleade Planta Temporaria Jornada Completa:
		// Sueldo Básico + Salario Familiar

		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// En este caso, 1500 = 1000.0 + 200.0 * 2 + 100.0

		assertEquals(1500, miEmpresa.obtTotalDeSueldos());
	}

	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaTemporariaTiempoCompletoSinParejaUnHije() {

		Empresa miEmpresa = new Empresa();

		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaUnHije = new Empleade("Juan De Los Palotes",
				Planta.TEMPORARIA, Jornada.COMPLETA, SIN_PAREJA, UN_HIJE, SIN_ANTIGUEDAD);
		miEmpresa.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaUnHije);

		// El Cálculo para Empleade Planta Temporaria Jornada Completa:
		// Sueldo Básico + Salario Familiar

		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// En este caso, 1400 = 1000.0 + 200.0 * 1

		assertEquals(1200, miEmpresa.obtTotalDeSueldos());
	}

	// Test de regresión
	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaTemporariaTiempoCompletoSinParejaDosHijes() {

		Empresa miEmpresa = new Empresa();

		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaDosHijes = new Empleade(
				"Juan De Los Palotes", Planta.TEMPORARIA, Jornada.COMPLETA, SIN_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);
		miEmpresa.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaDosHijes);

		// El Cálculo para Empleade Planta Temporaria Jornada Completa:
		// Sueldo Básico + Salario Familiar

		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// En este caso, 1400 = 1000.0 + 200.0 * 2

		assertEquals(1400, miEmpresa.obtTotalDeSueldos());
	}

	// Test de regresión
	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaTemporariaTiempoCompletoSinParejaTresHijes() {

		Empresa miEmpresa = new Empresa();

		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaTresHijes = new Empleade(
				"Juan De Los Palotes", Planta.TEMPORARIA, Jornada.COMPLETA, SIN_PAREJA, TRES_HIJES, SIN_ANTIGUEDAD);
		miEmpresa.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaTresHijes);

		// El Cálculo para Empleade Planta Temporaria Jornada Completa:
		// Sueldo Básico + Salario Familiar

		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// En este caso, 1600 = 1000.0 + 200.0 * 3

		assertEquals(1600, miEmpresa.obtTotalDeSueldos());
	}

	// Test de regresión
	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaTemporariaTiempoCompletoSinParejaSinHijes() {

		Empresa miEmpresa = new Empresa();

		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijes = new Empleade(
				"Juan De Los Palotes", Planta.TEMPORARIA, Jornada.COMPLETA, SIN_PAREJA, SIN_HIJES, SIN_ANTIGUEDAD);
		miEmpresa.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijes);

		// El Cálculo para Empleade Planta Temporaria Jornada Completa:
		// Sueldo Básico + Salario Familiar

		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// En este caso, 1000 = 1000.0

		assertEquals(1000, miEmpresa.obtTotalDeSueldos());
	}

	// Test de regresión
	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaTemporariaTiempoCompletoConParejaSinHijes() {

		Empresa miEmpresa = new Empresa();
		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijes = new Empleade(
				"Juan De Los Palotes", Planta.TEMPORARIA, Jornada.COMPLETA, CON_PAREJA, SIN_HIJES, SIN_ANTIGUEDAD);
		miEmpresa.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijes);

		// El Cálculo para Empleade Planta Temporaria Jornada Completa:
		// Sueldo Básico + Salario Familiar

		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// En este caso, 1100 = 1000.0 + 100.0

		assertEquals(1100, miEmpresa.obtTotalDeSueldos());
	}

	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaPermanenteTiempoCompletoConParejaSinHijesConAntiguedad1() {

		Empresa miEmpresa = new Empresa();

		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijesConAntiguedad1 = new Empleade(
				"Juan De Los Palotes", Planta.PERMANENTE, Jornada.COMPLETA, CON_PAREJA, SIN_HIJES, ANTIGUEDAD_1);
		miEmpresa.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijesConAntiguedad1);

		// El Cálculo para Empleade Planta Permanente Jornada Completa:
		// Sueldo Básico + Salario Familiar + Antigüedad

		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// Antigüedad: 100 * Año, max: 2000.
		// Si A = 1,
		// En este caso, 1200 = 1000.0 + 100.0 + (100 * 1)

		assertEquals(1200, miEmpresa.obtTotalDeSueldos());
	}

	// Test de regresión
	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaPermanenteTiempoCompletoConParejaSinHijesConAntiguedad13() {

		Empresa miEmpresa = new Empresa();

		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijesConAntiguedad13 = new Empleade(
				"Juan De Los Palotes", Planta.PERMANENTE, Jornada.COMPLETA, CON_PAREJA, SIN_HIJES, ANTIGUEDAD_13);
		miEmpresa.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijesConAntiguedad13);

		// El Cálculo para Empleade Planta Permanente Jornada Completa:
		// Sueldo Básico + Salario Familiar + Antigüedad

		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// Antigüedad: 100 * Año, max: 2000.
		// Si A = 13,
		// En este caso, 2400 = 1000.0 + 100.0 + (100 * 13)

		assertEquals(2400, miEmpresa.obtTotalDeSueldos());
	}

	// Test de regresión
	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaPermanenteTiempoCompletoConParejaSinHijesConAntiguedad20() {

		Empresa miEmpresa = new Empresa();

		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijesConAntiguedad20 = new Empleade(
				"Juan De Los Palotes", Planta.PERMANENTE, Jornada.COMPLETA, CON_PAREJA, SIN_HIJES, ANTIGUEDAD_20);
		miEmpresa.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijesConAntiguedad20);

		// El Cálculo para Empleade Planta Permanente Jornada Completa:
		// Sueldo Básico + Salario Familiar + Antigüedad

		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// Antigüedad: 100 * Año, max: 2000.
		// Si A = 20,
		// En este caso, 3100 = 1000.0 + 100.0 + (100 * 20)

		assertEquals(3100, miEmpresa.obtTotalDeSueldos());
	}

}
