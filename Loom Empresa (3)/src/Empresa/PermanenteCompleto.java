package Empresa;

public class PermanenteCompleto extends PlantaPermanente {

	public PermanenteCompleto(String nombre, String apellido, int cantDeHijos, boolean poseeConyugue, int antiguedad,
			double hsTrabajadas) {
		super(nombre, apellido, cantDeHijos, poseeConyugue, antiguedad, hsTrabajadas);
		super.tipoDeEmpleo += "Tiempo completo";
	}

	@Override
	public String toString() {
		return "nombre:" + nombre + ", apellido:" + apellido + ", tipoDeEmpleo:" + tipoDeEmpleo + ".";
	}

	@Override
	public double liquidarSueldo() {

		return super.SueldoBasicoUR + super.calcularAntiguedad() + super.calcularSalarioFamilia();

	}
}
