package Empresa;

import org.junit.Test;
import org.junit.Assert;

public class Empleado_Test {

	@Test
	public void toStringTest() {
		Empleado empleado = new Gerente("Albraro", "Juares", 0, false, 0, 0);
		Assert.assertEquals("nombre:Albraro, apellido:Juares, tipoDeEmpleo:Planta permantente. Gerente.",
				empleado.toString());
	}

	@Test(expected = Error.class)
	public void noSePuedeInicializarUnEmpleadoSinNombre() {
		Empleado empleado = new Gerente(" ", " ", 0, false, 0, 0);
		empleado.toString();
	}

	@Test
	public void liquidarSueldoGerenteTests() {
		Empleado empleado2 = new Gerente("Aitor", "Tilla", 3, true, 1, 3232);

		Assert.assertEquals("nombre:Aitor, apellido:Tilla, tipoDeEmpleo:Planta permantente. Gerente. Sueldo: 3800.0",
				empleado2.getSueldo());

	}

	@Test
	public void liquidarSueldoEmpleadoPlantaPermanenteTiempoCompletoTests() {
		Empleado empleado = new PermanenteCompleto("Alan", "Brito", 2, false, 7, 1);

		Assert.assertEquals(
				"nombre:Alan, apellido:Brito, tipoDeEmpleo:Planta permantente. Tiempo completo. Sueldo: 2100.0",
				empleado.getSueldo());

	}

	@Test
	public void liquidarSueldoEmpleadoPlantaPermanenteTiempoParcialTests() {
		Empleado empleado = new PermanenteParcial("Alejandro", "Perez", 8, false, 25, 150);

		Assert.assertEquals(
				"nombre:Alejandro, apellido:Perez, tipoDeEmpleo:Planta permantente. Tiempo parcial. Sueldo: 4600.0",
				empleado.getSueldo());

	}

	@Test
	public void liquidarSueldoEmpleadoPlantaTemporarioTiempoCompletoTests() {
		Empleado empleado = new TemporarioCompleto("Alan", "Brito", 2, false, 7, 100);

		Assert.assertEquals(
				"nombre:Alan, apellido:Brito, tipoDeEmpleo:Planta temporaria. Tiempo completo. Sueldo: 1400.0",
				empleado.getSueldo());

	}

	@Test
	public void liquidarSueldoEmpleadoPlantaTemporarioTiempoParcialTests() {
		Empleado empleado = new TemporarioParcial("Alejandro", "Perez", 8, false, 25, 150);

		Assert.assertEquals(
				"nombre:Alejandro, apellido:Perez, tipoDeEmpleo:Planta temporaria. Tiempo parcial. Sueldo: 2600.0",
				empleado.getSueldo());

	}
}
