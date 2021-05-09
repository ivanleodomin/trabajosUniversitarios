package ColaDeProcesos;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SistemaOperativo {
	/**
	 * cola priorizadda por prioridad, a igual prioridad, prioriza por tiempo de
	 * arribo.
	 */
	private PriorityQueue<Proceso> colaProcesos = new PriorityQueue<Proceso>();
	/**
	 * cola priorizadda por tiempo de arribo.
	 */
	private PriorityQueue<Proceso> colaArribo;
	/**
	 * lista de procesos que fueron terminados de procesar.
	 */
	private ArrayList<Proceso> procesosSalida;
	private long tiempoProcesador;
	private Procesador procesador;

	/**
	 * @param colaArribo cola prorizada por tiempo de arribo
	 */
	public SistemaOperativo(PriorityQueue<Proceso> colaArribo) {
		this.tiempoProcesador = 0;
		this.colaArribo = colaArribo;
		this.procesosSalida = new ArrayList<Proceso>();
		this.procesador = new Procesador(procesosSalida);
	}

	/**
	 * Se ejecuta la simulación durante el tiempo pasado como parmetro, en cada
	 * ciclo, se desencola los procesos de la colaArribo segun si el tiempo de
	 * arribo coincide con el tiempoProcesador y se encola en colaProcesos solo si
	 * el proceso no esta terminado. Tambien si el procesador esta libre comienza a
	 * procesar un proceso de la colaProcesos, que esos procesos son ingresados por
	 * tiempo de arribo pero dentro de esta cola se ordenan por prioridad por lo
	 * cual ese va a ser el criterio por el cual se ejecuten. El procesador procesa
	 * en cada ciclo el proceso que tiene asignado.
	 * 
	 * @param tiempo duración de la simulación
	 */
	public void simular(long tiempo) {

		for (; tiempoProcesador <= tiempo; tiempoProcesador++) {

			agregarAColaProcesos();

			if (procesador.getStatus() == Procesador.Estado.LIBRE) {

				if (!colaProcesos.isEmpty()) {
					procesador.procesar(colaProcesos.poll());
				}

			}
			procesador.pulsoClock();

		}
	}

	/*
	 * Agrega el proceso a colaPrioridad si el proceso no esta finalizado y si son
	 * iguales a tiempo de procesador. Tambien saca de la cola los procesos que ya
	 * estan finalizados asi puede usar los que estan debajo de el.
	 * 
	 */
	public void agregarAColaProcesos() {
		if (!colaArribo.isEmpty() && colaArribo.peek().get_estado() == Proceso.Estado.FINALIZADO)
			colaArribo.poll();

		while (!colaArribo.isEmpty() && (colaArribo.peek().getT_arribo() == tiempoProcesador)
				&& (colaArribo.peek().get_estado() != Proceso.Estado.FINALIZADO)) {
			colaProcesos.add(colaArribo.poll());
		}

	}

	public ArrayList<Proceso> listarProcesosSalida() {
		return procesosSalida;
	}

}
