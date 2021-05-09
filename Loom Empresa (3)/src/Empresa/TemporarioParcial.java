package Empresa;

public class TemporarioParcial extends PlantaTemporaria {

	public TemporarioParcial(String nombre, String apellido, int cantDeHijos, boolean poseeConyugue, int antiguedad,
			double hsTrabajadas) {
		super(nombre, apellido, cantDeHijos, poseeConyugue, antiguedad, hsTrabajadas);
		super.tipoDeEmpleo += "Tiempo parcial.";
	}

	@Override
	public String toString() {
		return "nombre:" + nombre + ", apellido:" + apellido + ", tipoDeEmpleo:" + tipoDeEmpleo;
	}

	@Override
	public double liquidarSueldo() {
		return super.calcularHs() + super.calcularSalarioFamilia();

	}
}
