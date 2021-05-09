package Empresa;

public abstract class PlantaPermanente extends Empleado{
	
	
	public PlantaPermanente(String nombre, String apellido, int cantDeHijos, boolean poseeConyugue, int antiguedad, double hsTrabajadas) {
		super(nombre, apellido, cantDeHijos, poseeConyugue, antiguedad, hsTrabajadas);
		super.tipoDeEmpleo = "Planta permantente. ";
	}

}
