package Empresa;

public class Gerente extends PlantaPermanente {

	public Gerente(String nombre, String apellido, int cantDeHijos, boolean poseeConyugue, int antiguedad, double hsTrabajadas) {

		super(nombre, apellido, cantDeHijos, poseeConyugue, antiguedad, hsTrabajadas);
		super.tipoDeEmpleo += "Gerente";
	}

	@Override
	public String toString() {
		return "nombre:" + nombre + ", apellido:" + apellido + ", tipoDeEmpleo:" + tipoDeEmpleo + ".";
	}

	@Override
	public double liquidarSueldo() {
		return super.calcularAntiguedad()+ super.calcularSalarioFamilia() + super.SueldoBasicoUR + 2000;
	}
}