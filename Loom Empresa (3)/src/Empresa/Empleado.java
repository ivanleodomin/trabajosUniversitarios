package Empresa;

public class Empleado {

	protected String nombre;
	protected String apellido;
	protected String tipoDeEmpleo;
	protected double SueldoBasicoUR = 1000;
	protected int cantDeHijos;
	protected boolean conyugue;
	protected int antiguedad;
	protected double hsTrabajadas;

	public Empleado(String nombre, String apellido, int cantDeHijos, boolean poseeConyugue, int antiguedad,
			double hsTrabajadas) {
		if (nombre == " " || apellido == " " || cantDeHijos < 0 || antiguedad < 0 || hsTrabajadas < 0)
			throw new Error("Ningun campo puede quedarse vacio");
		else {
			this.nombre = nombre;
			this.apellido = apellido;
			this.cantDeHijos = cantDeHijos;
			this.conyugue = poseeConyugue;
			this.antiguedad = antiguedad;
			this.hsTrabajadas = hsTrabajadas;

		}
	}


	/*
	 *  implementado en subclases
	 */
	public double liquidarSueldo() {

		return -1;
	}

	/*
	 * post: obtiene el los datos del empleado mas sus sueldo
	 */
	public String getSueldo() {
		return this.toString() + " Sueldo: " + liquidarSueldo();

	}

	@Override
	public String toString() {
		return "nombre:" + nombre + ", apellido:" + apellido + ", tipoDeEmpleo:" + tipoDeEmpleo;
	}

	/*
	 * post: calcula el salario familiar del empleado en caso de tener hijos y/o conyugues
	 */
	protected double calcularSalarioFamilia() {
		int familiar = 200 * this.cantDeHijos;
		if (this.conyugue)
			familiar += 100;

		return familiar;
	}

	/*
	 * post: calcula el valor de las hs trabajadas
	 */
	public double calcularHs() {
		double calculo = this.SueldoBasicoUR / 3 + this.hsTrabajadas * 10;
		if (((this.SueldoBasicoUR / 3) + this.hsTrabajadas * 10) > 1000) {
			calculo = 1000;
		}
		return calculo;
	}

	/*
	 *  post: calcula la antiguedad del empleado
	 */
	public int calcularAntiguedad() {
		if (this.antiguedad <= 20)
			return this.antiguedad * 100;
		else
			return 2000;
	}

	/*
	 *  post: cambia el sueldo basico 
	 */
	public void cambiarSueldoBasico(int sueldoBasicoUR) {
		this.SueldoBasicoUR = sueldoBasicoUR;
	}
}