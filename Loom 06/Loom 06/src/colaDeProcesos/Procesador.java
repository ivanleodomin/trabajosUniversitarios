package colaDeProcesos;

import java.util.ArrayList;

public class Procesador {
	public enum Estado {
		LIBRE, OCUPADO
	};

	private long t_ejecucion;
	private Proceso procesoActual;
	private ArrayList<Proceso> finalizados;
	private Estado status;
	/**
	 * @param ejecutados lista de procesos que fueron terminados de procesar.
	 */
	public Procesador(ArrayList<Proceso> ejecutados) {
		this.status = Procesador.Estado.LIBRE;
		this.finalizados = ejecutados;
	}

	public Estado getStatus() {
		return status;
	}
	/**
	 * Asigna un proceso al procesador y 
	 * marca al procesador como ocupado
	 * @param: proceso a ser ejecutado por el procesador
	 */
	public void procesar(Proceso p) {
		t_ejecucion = p.getT_ejecucion();
		procesoActual = p;
		status = Procesador.Estado.OCUPADO;
	}
	/**
	 * Disminuye el tiempo de ejecución del proceso,
	 * si el proceso se termina de ejecutar y lo agrega a la lista de finalizados
	 * y libera el procesador
	 */
	public void pulsoClock() {
		if (status == Procesador.Estado.OCUPADO) {
			t_ejecucion--;
			if (t_ejecucion == 0) {
				procesoActual.setStatus(Proceso.Estado.FINALIZADO);
				finalizados.add(procesoActual);
				procesoActual = null;
				status = Procesador.Estado.LIBRE;
			}
		}
	}
}
