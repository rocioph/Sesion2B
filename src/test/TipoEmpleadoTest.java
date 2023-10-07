package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import emp.empleado;
class TipoEmpleadoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculoNominaBrutaEncargado() {
		empleado emp = new empleado();
		float nominaBruta = emp.calculoNominaBruta(empleado.TipoEmpleado.Encargado, 1500, 0);
		assertEquals(2700, nominaBruta);
		
	}
	
	@Test
	void testCalculoNominaBrutaVendedor() {
		empleado emp = new empleado();
		float nominaBruta = emp.calculoNominaBruta(empleado.TipoEmpleado.Vendedor, 1500, 0);
		assertEquals(2200, nominaBruta);
	}
	
	@Test
	void testCalculoNominaBrutaOtro() {
		empleado emp = new empleado();
		float nominaBruta = emp.calculoNominaBruta(empleado.TipoEmpleado.Otro, 1500, 0);
		assertEquals(0, nominaBruta);
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesNegativa() {
		empleado emp = new empleado();
		float nominaBruta = emp.calculoNominaBruta(empleado.TipoEmpleado.Vendedor, -900, 0);
		assertEquals(2000, nominaBruta);
	}
	
	@Test
	void CalculoNominaBrutaVentasMesMenor1000() {
		empleado emp = new empleado();
		float nominaBruta = emp.calculoNominaBruta(empleado.TipoEmpleado.Vendedor, 900, 0);
		assertEquals(2000, nominaBruta);
	}

	@Test
	void CalculoNominaBrutaVentasMesEntre1000y1500() {
		empleado emp = new empleado();
		float nominaBruta = emp.calculoNominaBruta(empleado.TipoEmpleado.Vendedor, 1100, 0);
		assertEquals(2100, nominaBruta);
	}

	@Test
	void CalculoNominaBrutaVentasMesMayor1500() {
		empleado emp = new empleado();
		float nominaBruta = emp.calculoNominaBruta(empleado.TipoEmpleado.Vendedor, 1600, 0);
		assertEquals(2200, nominaBruta);
	}

	@Test
	void CalculoNominaBrutaVentasHorasExtraPositivas() {
		empleado emp = new empleado();
		float nominaBruta = emp.calculoNominaBruta(empleado.TipoEmpleado.Vendedor, 900, 2);
		assertEquals(2060, nominaBruta);
	}

	@Test
	void CalculoNominaBrutaVentasHorasExtraNegativas() {
		empleado emp = new empleado();
		float nominaBruta = emp.calculoNominaBruta(empleado.TipoEmpleado.Vendedor, 900, -2);
		assertEquals(2000, nominaBruta);
	}
	
	@Test
	void testCalculoNominaNetaNegativa() {
		empleado emp = new empleado();
		float nominaNeta = emp.calculoNominaNeta(-1000);
		assertEquals(0, nominaNeta);
	}
	
	@Test
	void testCalculoNominaNetaMenos2100() {
		empleado emp = new empleado();
		float nominaNeta = emp.calculoNominaNeta(2000);
		assertEquals(2000, nominaNeta);
	}
	
	@Test
	void testCalculoNominaNetaEntre2100y2500() {
		empleado emp = new empleado();
		float nominaNeta = emp.calculoNominaNeta(2200);
		assertEquals(1870, nominaNeta);
	}
	
	@Test
	void testCalculoNominaNetaMayor2500() {
		empleado emp = new empleado();
		float nominaNeta = emp.calculoNominaNeta(2600);
		assertEquals(2132, nominaNeta);
	}
}
