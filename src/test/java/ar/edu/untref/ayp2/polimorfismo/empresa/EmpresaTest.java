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

	// Este valor pasa el límite: el resultado de usarlo en nuestro cálculo
	// debería ser igual al que surge de usar el valor anterior.
	// Luego, es trivial transformar esta propiedad en un test.
	private static final int ANTIGUEDAD_37 = 37;

	// HORAS TRABAJADAS
	//
	// Estos valores son para el cómputo de Empleados por Hora
	private static final double SIN_HORAS_TRABAJADAS = 0.0;
	private static final double CON_1_HORA_TRABAJADA = 1.0;

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

		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.PERMANENTE, CON_PAREJA, DOS_HIJES,
				SIN_ANTIGUEDAD);
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

		EmpleadeAbstracte miEmpleade = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA, SIN_PAREJA, DOS_HIJES,
				SIN_ANTIGUEDAD);
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

		EmpleadeAbstracte miEmpleade = new EmpleadePorHoras("Juan De Los Palotes", Planta.TEMPORARIA, SIN_PAREJA,
				DOS_HIJES, SIN_ANTIGUEDAD, SIN_HORAS_TRABAJADAS);
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

		EmpleadeAbstracte miEmpleade = new EmpleadePorHoras("Juan De Los Palotes", Planta.PERMANENTE, SIN_PAREJA,
				DOS_HIJES, SIN_ANTIGUEDAD, SIN_HORAS_TRABAJADAS);
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
				SIN_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);

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
				CON_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);
		EmpleadeAbstracte empleadeValideSinCategoriaTemporarie = new Empleade("Juan De Los Palotes", Planta.TEMPORARIA,
				CON_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);

		// La siguiente línea da error de compilación
		// assertEquals(Planta.OTRA, empleadeValideSinCategoriaTemporarie.obtPlanta());

		assertEquals(Planta.PERMANENTE, empleadeValideSinCategoriaPermanente.obtPlanta());
		assertEquals(Planta.TEMPORARIA, empleadeValideSinCategoriaTemporarie.obtPlanta());

	}

	// Validación de datos (bis)
	@Test
	public void jornadaDeEmpleadePuedeSerSoloCompleta() {

		EmpleadeAbstracte empleadeValideSinCategoriaPermanente = new Empleade("Juan De Los Palotes", Planta.PERMANENTE,
				SIN_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);

		// La siguiente línea da error de compilación
		// assertEquals(Jornada.NI, empleadeValideSinCategoriaPermanente.obtJornada());

		assertEquals(Jornada.COMPLETA, empleadeValideSinCategoriaPermanente.obtJornada());
	}

	// Validación de datos (tris)
	@Test
	public void jornadaDeEmpleadePorHorasPuedeSerSoloParcial() {

		EmpleadeAbstracte empleadeValideSinCategoriaTemporarie = new EmpleadePorHoras("Juan De Los Palotes",
				Planta.TEMPORARIA, SIN_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD, SIN_HORAS_TRABAJADAS);

		// La siguiente línea da error de compilación
		// assertEquals(Jornada.NI, empleadeValideSinCategoriaPermanente.obtJornada());

		assertEquals(Jornada.PARCIAL, empleadeValideSinCategoriaTemporarie.obtJornada());
	}

	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaTemporariaTiempoCompletoConParejaDosHijes() {

		Empresa miEmpresa = new Empresa();

		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaDosHijes = new Empleade(
				"Juan De Los Palotes", Planta.TEMPORARIA, CON_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);
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
				Planta.TEMPORARIA, SIN_PAREJA, UN_HIJE, SIN_ANTIGUEDAD);
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
				"Juan De Los Palotes", Planta.TEMPORARIA, SIN_PAREJA, DOS_HIJES, SIN_ANTIGUEDAD);
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
				"Juan De Los Palotes", Planta.TEMPORARIA, SIN_PAREJA, TRES_HIJES, SIN_ANTIGUEDAD);
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
				"Juan De Los Palotes", Planta.TEMPORARIA, SIN_PAREJA, SIN_HIJES, SIN_ANTIGUEDAD);
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
				"Juan De Los Palotes", Planta.TEMPORARIA, CON_PAREJA, SIN_HIJES, SIN_ANTIGUEDAD);
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
				"Juan De Los Palotes", Planta.PERMANENTE, CON_PAREJA, SIN_HIJES, ANTIGUEDAD_1);
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
				"Juan De Los Palotes", Planta.PERMANENTE, CON_PAREJA, SIN_HIJES, ANTIGUEDAD_13);
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
				"Juan De Los Palotes", Planta.PERMANENTE, CON_PAREJA, SIN_HIJES, ANTIGUEDAD_20);
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

	// Probando el máximo computable de antigüedad...
	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaPermanenteTiempoCompletoConParejaSinHijesConAntiguedad37() {

		Empresa miEmpresa1 = new Empresa();
		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijesConAntiguedad20 = new Empleade(
				"Juan De Los Palotes", Planta.PERMANENTE, CON_PAREJA, SIN_HIJES, ANTIGUEDAD_20);
		miEmpresa1.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijesConAntiguedad20);

		Empresa miEmpresa2 = new Empresa();
		EmpleadeAbstracte miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijesConAntiguedad37 = new Empleade(
				"Juan De Los Palotes", Planta.PERMANENTE, CON_PAREJA, SIN_HIJES, ANTIGUEDAD_37);
		miEmpresa2.contratar(miEmpleadePlantaTemporariaJornadaCompletaConParejaSinHijesConAntiguedad37);

		// El Cálculo para Empleade Planta Permanente Jornada Completa:
		// Sueldo Básico + Salario Familiar + Antigüedad

		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// Antigüedad: 100 * Año, max: 2000.
		// Si A > 20, el resultado debería ser igual a si A == 20.

		assertEquals(miEmpresa1.obtTotalDeSueldos(), miEmpresa2.obtTotalDeSueldos());
	}

	// Agregamos soporte para Gerentes
	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUneGerenteConParejaSinHijesSinAntiguedad() {

		Empresa miEmpresa = new Empresa();
		EmpleadeAbstracte miGerenteConParejaSinHijesSinAntiguedad = new Gerente("Ana De la Cumbre", CON_PAREJA,
				SIN_HIJES, SIN_ANTIGUEDAD);
		miEmpresa.contratar(miGerenteConParejaSinHijesSinAntiguedad);

		// El Cálculo para Gerente:
		// Sueldo Básico + Salario Familiar + Antigüedad + Asig. por Personal a Cargo
		//
		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// Antigüedad: 100 * Año, max: 2000.
		// Asig. por Personal a Cargo: 2000 (fijo)
		// En este caso, para A == 0,
		// 3100 = 1000 + 100.0 + 0.0 + 2000.0

		assertEquals(3100, miEmpresa.obtTotalDeSueldos());
	}

	// Test de regresión: probamos con el máximo posible de antigüedad
	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUneGerenteConParejaSinHijesConAntiguedad20() {

		Empresa miEmpresa = new Empresa();
		EmpleadeAbstracte miGerenteConParejaSinHijesConAntiguedad20 = new Gerente("Ana De la Cumbre", CON_PAREJA,
				SIN_HIJES, ANTIGUEDAD_20);
		miEmpresa.contratar(miGerenteConParejaSinHijesConAntiguedad20);

		// El Cálculo para Gerente:
		// Sueldo Básico + Salario Familiar + Antigüedad + Asig. por Personal a Cargo
		//
		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// Antigüedad: 100 * Año, max: 2000.
		// Asig. por Personal a Cargo: 2000 (fijo)
		// En este caso, para A == 20,
		// 5100 = 1000 + 100.0 + (20 * 100.0) + 2000.0

		assertEquals(5100, miEmpresa.obtTotalDeSueldos());
	}

	// Test de regresión: probamos sobrepasar el máximo posible de antigüedad
	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUneGerenteConParejaSinHijesConAntiguedad37() {

		Empresa miEmpresa1 = new Empresa();
		EmpleadeAbstracte miGerenteConParejaSinHijesConAntiguedad20 = new Gerente("Ana De la Cumbre", CON_PAREJA,
				SIN_HIJES, ANTIGUEDAD_20);
		miEmpresa1.contratar(miGerenteConParejaSinHijesConAntiguedad20);

		Empresa miEmpresa2 = new Empresa();
		EmpleadeAbstracte miGerenteConParejaSinHijesConAntiguedad37 = new Gerente("Ana De la Cumbre", CON_PAREJA,
				SIN_HIJES, ANTIGUEDAD_37);
		miEmpresa2.contratar(miGerenteConParejaSinHijesConAntiguedad37);

		// El Cálculo para Gerente:
		// Sueldo Básico + Salario Familiar + Antigüedad + Asig. por Personal a Cargo
		//
		// Sueldo Básico = 1000.0
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// Antigüedad: 100 * Año, max: 2000.
		// Asig. por Personal a Cargo: 2000 (fijo)
		// Si A > 20, el resultado debería ser igual a si A == 20.

		assertEquals(miEmpresa1.obtTotalDeSueldos(), miEmpresa2.obtTotalDeSueldos());
	}

	// Agregamos soporte para Jornada Parcial (por ahora, sin horas extra)
	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaPermanenteTiempoParcialConParejaSinHijesConAntiguedad13SinHorasTrabajadas() {

		Empresa miEmpresa = new Empresa();
		EmpleadeAbstracte miEmpleadePlantaPermanenteTiempoParcialConParejaSinHijesConAntiguedad13SinHorasTrabajadas = new EmpleadePorHoras(
				"Juanito Espuma", Planta.PERMANENTE, CON_PAREJA, SIN_HIJES, ANTIGUEDAD_13, SIN_HORAS_TRABAJADAS);
		miEmpresa.contratar(miEmpleadePlantaPermanenteTiempoParcialConParejaSinHijesConAntiguedad13SinHorasTrabajadas);

		// El Cálculo para Tiempo Parcial:
		// Sueldo Básico' + Salario Familiar + Antigüedad
		//
		// Sueldo Básico' = min[1000, 1/3 *1000 + (horas_trabajadas * 10)]
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// Antigüedad: min [2000, 100 * Año)
		// Valor de la Hora Trabajada: 10
		// En nuestro caso,
		// HT = 0;
		// A = 13,
		// SF = 100
		//
		// Luego,
		// S = SB' + SF + A
		// S = min(SB, 1/3 SB + HT*H) + SF + min(ANTIG_MAX, AA*A)
		// S = min(1000, 1/3*1000 + 0*10) + 100 + min(2000, 100*13)
		// S = min(1000, 333.333) + 100 + min(2000, 1300)
		// S = 333.333 + 100 + 1300
		// S = 1733.333
		assertEquals(1733.3333333333333, miEmpresa.obtTotalDeSueldos());
	}

	// Agregamos soporte para Jornada Parcial (ahora, con horas extra)
	@Test
	public void laEmpresaDebePoderObtenerElSueldoDeUnPlantaPermanenteTiempoParcialConParejaSinHijesConAntiguedad13Con1HoraTrabajada() {

		Empresa miEmpresa = new Empresa();
		EmpleadeAbstracte miEmpleadePlantaPermanenteTiempoParcialConParejaSinHijesConAntiguedad13Con1HoraTrabajada = new EmpleadePorHoras(
				"Juanito Espuma", Planta.PERMANENTE, CON_PAREJA, SIN_HIJES, ANTIGUEDAD_13, CON_1_HORA_TRABAJADA);
		miEmpresa.contratar(miEmpleadePlantaPermanenteTiempoParcialConParejaSinHijesConAntiguedad13Con1HoraTrabajada);

		// El Cálculo para Tiempo Parcial:
		// Sueldo Básico' + Salario Familiar + Antigüedad
		//
		// Sueldo Básico' = min[SB, 1/3 *SB + (HT * H)]
		// Salario Familar = 200.0 * hije + 100.0 si tiene pareja registrada
		// Antigüedad: min [2000, AA * A)
		// Asig. Antigüedad AA: 100
		// Valor de la Hora Trabajada H: 10
		// En nuestro caso,
		// HT = 1; (cantidad de horas trabajadas)
		// A = 13,
		// SF = 100
		//
		// Luego,
		// S = SB' + SF + A
		// S = min(SB, 1/3 SB + HT*H) + SF + min(ANTIG_MAX, AA*A)
		// S = min(1000, 1/3*1000 + 1*10) + 100 + min(2000, 100*13)
		// S = min(1000, 333.333 + 10) + 100 + min(2000, 1300)
		// S = 343.333 + 100 + 1300
		// S = 1743.333
		assertEquals(1743.3333333333333, miEmpresa.obtTotalDeSueldos());
	}

}
