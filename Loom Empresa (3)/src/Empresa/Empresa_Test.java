package Empresa;

import org.junit.Test;
import org.junit.Assert;

public class Empresa_Test {

	@Test(expected = Error.class)
	public void noSePuedeCrearUnaListaConValoresMenoresA2() {
		Empresa empresa = new Empresa(1);
	}

	@Test
	public void cearUnaEmpresaCon2GerentesY3EmpleadosPermanentesHorarioCOmpleto() {
		
		Empresa empresa = new Empresa(5);
		empresa.addGerente("Horacio", "Suares", 0, false, 0);
		empresa.addGerente("Pedro", "Lomos", 1, false, 3);
		empresa.addPermanente_Completo("Susana", "Pereyra", 0, false, 0);
		empresa.addPermanente_Completo("Maria", "Rosa", 0, false, 0);
		empresa.addPermanente_Completo("Juan", "Alas", 3, true, 5);
		Assert.assertEquals(
				"Lista de Empleados: \n" + "nombre:Horacio, apellido:Suares, tipoDeEmpleo:Planta permantente. Gerente\n"
						+ "nombre:Pedro, apellido:Lomos, tipoDeEmpleo:Planta permantente. Gerente\n"
						+ "nombre:Susana, apellido:Pereyra, tipoDeEmpleo:Planta permantente. Tiempo completo\n"
						+ "nombre:Maria, apellido:Rosa, tipoDeEmpleo:Planta permantente. Tiempo completo\n"
						+ "nombre:Juan, apellido:Alas, tipoDeEmpleo:Planta permantente. Tiempo completo\n",
				empresa.getListado());
	}

	
	@Test
	public void NoSeRompeSiLaListaTieneEspaciosVacios() {
		
		Empresa empresa = new Empresa(5);
		empresa.addGerente("Horacio", "Suares", 0, false, 0);
		empresa.addGerente("Pedro", "Lomos", 1, false, 3);
		empresa.addPermanente_Completo("Susana", "Pereyra", 0, false, 0);
		empresa.addPermanente_Completo("Maria", "Rosa", 0, false, 0);
		empresa.addPermanente_Completo("Juan", "Alas", 3, true, 5);
		Assert.assertEquals(
				"Lista de Empleados: \n" + "nombre:Horacio, apellido:Suares, tipoDeEmpleo:Planta permantente. Gerente\n"
						+ "nombre:Pedro, apellido:Lomos, tipoDeEmpleo:Planta permantente. Gerente\n"
						+ "nombre:Susana, apellido:Pereyra, tipoDeEmpleo:Planta permantente. Tiempo completo\n"
						+ "nombre:Maria, apellido:Rosa, tipoDeEmpleo:Planta permantente. Tiempo completo\n"
						+ "nombre:Juan, apellido:Alas, tipoDeEmpleo:Planta permantente. Tiempo completo\n",
				empresa.getListado());
	}
	
	@Test
	public void liquidarSueldoTest() {
		
		Empresa empresa = new Empresa(5);
		empresa.addGerente("Horacio", "Suares", 0, false, 0);
		empresa.addGerente("Pedro", "Lomos", 1, false, 3);
		empresa.addPermanente_Completo("Susana", "Pereyra", 0, false, 0);
		empresa.addPermanente_Completo("Maria", "Rosa", 0, false, 0);
		empresa.addPermanente_Completo("Juan", "Alas", 3, true, 5);
		Assert.assertEquals(
				"Liquidacion de sueldos: \n" + 
				"nombre:Horacio, apellido:Suares, tipoDeEmpleo:Planta permantente. Gerente. Sueldo: 3000.0\n" + 
				"nombre:Pedro, apellido:Lomos, tipoDeEmpleo:Planta permantente. Gerente. Sueldo: 3300.0\n" + 
				"nombre:Susana, apellido:Pereyra, tipoDeEmpleo:Planta permantente. Tiempo completo. Sueldo: 1600.0\n" + 
				"nombre:Maria, apellido:Rosa, tipoDeEmpleo:Planta permantente. Tiempo completo. Sueldo: 1900.0\n" + 
				"nombre:Juan, apellido:Alas, tipoDeEmpleo:Planta permantente. Tiempo completo. Sueldo: 2200.0\n",
				empresa.liquidarSueldos());
	}
}
