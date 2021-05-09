package Empresa;

public abstract class PlantaTemporaria extends Empleado {

	public PlantaTemporaria(String nombre, String apellido, int cantDeHijos, boolean poseeConyugue, int antiguedad, double hsTrabajadas)  {
		super(nombre, apellido, cantDeHijos, poseeConyugue, antiguedad, hsTrabajadas);
		super.tipoDeEmpleo = "Planta temporaria. ";
	}

}