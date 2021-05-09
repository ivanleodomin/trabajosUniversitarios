package Empresa;

public class TemporarioCompleto extends PlantaTemporaria {

	public TemporarioCompleto(String nombre, String apellido, int cantDeHijos, boolean poseeConyugue, int antiguedad,
			double hsTrabajadas) {
		super(nombre, apellido, cantDeHijos, poseeConyugue, antiguedad, hsTrabajadas);
		super.tipoDeEmpleo += "Tiempo completo.";
	}

	@Override
	public String toString() {
		return "nombre:" + nombre + ", apellido:" + apellido + ", tipoDeEmpleo:" + tipoDeEmpleo;
	}

	@Override
	public double liquidarSueldo() {

		return super.SueldoBasicoUR + super.calcularSalarioFamilia();

	}
}
