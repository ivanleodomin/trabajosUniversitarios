package ColaDeProcesos;

public class Proceso implements Comparable<Proceso> {

	public enum Estado {
		LISTO, FINALIZADO
	}

	private String nombre;
	private long t_arribo; // tiempo de arribo
	private long t_ejecucion; // tiempo de ejecucion
	private int prioridad;
	private Estado status;

	public Proceso(String nombre, long t_arribo, long t_ejecucion, int prioridad) {
		this.nombre = nombre;
		this.t_arribo = t_arribo;
		this.t_ejecucion = t_ejecucion;
		this.prioridad = prioridad;

	}

	/*
	 * post: retorna el tiempo de ejecucion
	 */
	public long getT_ejecucion() {
		this.status = Proceso.Estado.LISTO;
		return t_ejecucion;
	}

	/*
	 * post: retorna el tiempo de ejecucion
	 */
	public Estado get_estado() {
		return status;
	}

	/*
	 * post: retorna el tiempo de arribo
	 */
	public long getT_arribo() {
		return t_arribo;
	}

	/*
	 * post: se le asigna el estado del proceso
	 */
	public void setStatus(Estado status) {
		this.status = status;
	}

	/*
	 * compara por prioridad, si poseen la misma por tiempo de arribo
	 */

	@Override
	public int compareTo(Proceso otroProceso) {
		if (this.prioridad != otroProceso.prioridad)
			return Integer.compare(this.prioridad, otroProceso.prioridad);
		else if (this.getT_arribo() != otroProceso.getT_arribo())
			return Long.compare(this.getT_arribo(), otroProceso.getT_arribo());
		else
			return 0;

	}

	//Use el to string para poder visualizar mejor los test en consola
	@Override
	public String toString() {
		return nombre;
	}

}
