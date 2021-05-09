package colaDeProcesos;

public class Proceso implements Comparable<Proceso> {

	public enum Estado {
		EN_EJECUCION, FINALIZADO
	}

	private String nombre;
	private long t_arribo; // tiempo de arribo
	private long t_ejecucion; // tiempo de ejecucion
	private int prioridad;
	private Estado status;

	public Proceso(String nombre, int t_arribo, int t_ejecucion, int prioridad) {
		this.nombre = nombre;
		this.t_arribo = t_arribo;
		this.t_ejecucion = t_ejecucion;
		this.prioridad = prioridad;

	}

	/*
	 * post: retorna el tiempo de ejecucion
	 */
	public long getT_ejecucion() {
		this.status = Proceso.Estado.EN_EJECUCION;
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
		if (prioridad < otroProceso.prioridad) {
			return -1;
		} else if (prioridad > otroProceso.prioridad)
			return 1;
		else
			return Long.compare(t_arribo, otroProceso.getT_arribo());
	}

}
