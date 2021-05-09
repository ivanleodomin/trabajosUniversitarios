package Empresa;

public class Empresa {

	private Empleado[] empleados;
	private int posicion = 0;

	/*
	 * empleados es un arreglo unidimencional de tipo Empleado el cual contendra la
	 * informacion de los empleados pertenecientes a la empresa
	 * 
	 * pre: cantidad de empleados asegura que la lista no sea creada con valores
	 * negativos o menores que 2
	 */
	public Empresa(int cantidadDeEmpleados) {
		if (cantidadDeEmpleados < 2) {
			throw new Error("¡Se debe contar con 2 empleados o mas!");
		}
		this.empleados = new Empleado[cantidadDeEmpleados];
	}

	/*
	 * post: Se obtiene el listado de elementos dentro del arreglo
	 */
	public String getListado() {
		String listado = "Lista de Empleados: \n";

		for (int i = 0; i < posicion; i++) {
			listado += empleados[i].toString() + "\n";
		}
		return listado;
	}

	/*
	 * post: agrega un nuevo empleado de planta permanente tiempo parcial en la
	 * ultima posicion disponible
	 */
	public void addPermanente_Parcial(String nombre, String apellido, int cantDeHijos, boolean poseeConyugue,
			int antiguedad) {
		this.empleados[this.posicion] = new PermanenteParcial(nombre, apellido, posicion, false, posicion, antiguedad);
		this.posicion++;
	}

	/*
	 * post: agrega un nuevo empleado de planta permanente tiempo completo en la
	 * ultima posicion disponible
	 */
	public void addPermanente_Completo(String nombre, String apellido, int cantDeHijos, boolean poseeConyugue,
			int antiguedad) {
		this.empleados[this.posicion] = new PermanenteCompleto(nombre, apellido, posicion, false, posicion, antiguedad);
		this.posicion++;
	}

	/*
	 * post: agrega un nuevo gerente en la ultima posicion disponible
	 */
	public void addGerente(String nombre, String apellido, int cantDeHijos, boolean poseeConyugue, int antiguedad) {
		this.empleados[this.posicion] = new Gerente(nombre, apellido, posicion, false, posicion, antiguedad);
		this.posicion++;
	}

	/*
	 * post: agrega un nuevo empleado de planta temporaria tiempo parcial en la
	 * ultima posicion disponible
	 */
	public void addTemporario_Parcial(String nombre, String apellido, int cantDeHijos, boolean poseeConyugue,
			int antiguedad) {
		this.empleados[this.posicion] = new TemporarioParcial(nombre, apellido, posicion, false, posicion, antiguedad);
		this.posicion++;
	}

	/*
	 * post: agrega un nuevo empleado de planta temporaria tiempo completo en la
	 * ultima posicion disponible
	 */
	public void addTemporario_Completo(String nombre, String apellido, int cantDeHijos, boolean poseeConyugue,
			int antiguedad) {
		this.empleados[this.posicion] = new TemporarioCompleto(nombre, apellido, posicion, false, posicion, antiguedad);
		this.posicion++;
	}

	/*
	 * post: Liquida los sueldos de todos los empleados de la empresa y los enlista
	 * junto a sus nombres y puesto
	 * 
	 */
	public String liquidarSueldos() {
		String listado = "Liquidacion de sueldos: \n";
		for (int i = 0; i < empleados.length; i++) {
			listado += empleados[i].getSueldo() + "\n";
		}
		return listado;
	}

	/*
	 * post: cambia el sueldo basico
	 */
	public void cambiarSueldoBasico(int nuevo) {

		for (int i = 0; i < empleados.length; i++) {
			empleados[i].cambiarSueldoBasico(nuevo);
		}
	}
}
