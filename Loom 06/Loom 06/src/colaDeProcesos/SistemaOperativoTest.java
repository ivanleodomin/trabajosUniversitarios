package colaDeProcesos;

import java.util.ArrayList;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

public class SistemaOperativoTest {

	@Test
	public void todosLosProcesosSonAtendidos() {
		Proceso p0 = new Proceso("P0", 0, 5, 4);
		Proceso p1 = new Proceso("P1", 1, 3, 2);
		Proceso p2 = new Proceso("P2", 2, 8, 5);
		Proceso p3 = new Proceso("P3", 3, 2, 1);
		Proceso p4 = new Proceso("P4", 4, 3, 2);

		PriorityQueue<Proceso> colaArribo = new PriorityQueue<Proceso>(new OrdenadorProcesosArribo());
		colaArribo.add(p1);
		colaArribo.add(p2);
		colaArribo.add(p3);
		colaArribo.add(p4);
		colaArribo.add(p0);
		
		Proceso p = colaArribo.peek();
		
		ArrayList<Proceso> procesosSalida = new ArrayList<Proceso>();
		procesosSalida.add(p0);
		procesosSalida.add(p1);
		procesosSalida.add(p2);
		procesosSalida.add(p3);
		procesosSalida.add(p4);

		SistemaOperativo so = new SistemaOperativo(colaArribo);
		so.simular(25);
		Assert.assertEquals(procesosSalida, so.listarProcesosSalida());

	}

	@Test
	public void unPorcesoNoEsAtendidoPorEstarFinalizado() {
		Proceso p0 = new Proceso("P0", 0, 5, 4);
		Proceso p1 = new Proceso("P1", 1, 3, 2);
		Proceso p2 = new Proceso("P2", 2, 8, 5);
		Proceso p3 = new Proceso("P3", 3, 2, 1);
		Proceso p4 = new Proceso("P4", 4, 3, 2);
		Proceso p5 = new Proceso("P5", 0, 3, 2);
		p5.setStatus(Proceso.Estado.FINALIZADO);

		PriorityQueue<Proceso> colaArribo = new PriorityQueue<Proceso>(new OrdenadorProcesosArribo());
		colaArribo.add(p0);
		colaArribo.add(p1);
		colaArribo.add(p2);
		colaArribo.add(p3);
		colaArribo.add(p4);
		colaArribo.add(p5);

		ArrayList<Proceso> procesosSalida = new ArrayList<Proceso>();
		procesosSalida.add(p3);
		procesosSalida.add(p1);
		procesosSalida.add(p4);
		procesosSalida.add(p0);
		procesosSalida.add(p2);

		SistemaOperativo so = new SistemaOperativo(colaArribo);
		so.simular(25);
		Assert.assertEquals(procesosSalida, so.listarProcesosSalida());

	}
	
	@Test
	public void arribosAlMismoTiempo() {
		Proceso p0 = new Proceso("P0", 0, 5, 4);
		Proceso p1 = new Proceso("P1", 0, 5, 2);
		Proceso p2 = new Proceso("P2", 0, 5, 5);
		Proceso p3 = new Proceso("P3", 0, 5, 2);
		Proceso p4 = new Proceso("P4", 0, 5, 3);
		

		PriorityQueue<Proceso> colaArribo = new PriorityQueue<Proceso>(new OrdenadorProcesosArribo());
		colaArribo.add(p0);
		colaArribo.add(p1);
		colaArribo.add(p2);
		colaArribo.add(p3);
		colaArribo.add(p4);

		ArrayList<Proceso> procesosSalida = new ArrayList<Proceso>();
		procesosSalida.add(p3);
		procesosSalida.add(p1);
		procesosSalida.add(p4);
		procesosSalida.add(p0);
		procesosSalida.add(p2);

		SistemaOperativo so = new SistemaOperativo(colaArribo);
		so.simular(25);
		
		Assert.assertEquals(procesosSalida, so.listarProcesosSalida());
	}

		@Test
		public void arribosDistanciados() {
			Proceso p0 = new Proceso("P0", 40, 5, 1);
			Proceso p1 = new Proceso("P1", 30, 5, 2);
			Proceso p2 = new Proceso("P2", 20, 5, 3);
			Proceso p3 = new Proceso("P3", 10, 5, 4);
			Proceso p4 = new Proceso("P4", 0, 5, 5);
			

			PriorityQueue<Proceso> colaArribo = new PriorityQueue<Proceso>(new OrdenadorProcesosArribo());
			colaArribo.add(p0);
			colaArribo.add(p1);
			colaArribo.add(p2);
			colaArribo.add(p3);
			colaArribo.add(p4);

			ArrayList<Proceso> procesosSalida = new ArrayList<Proceso>();
			procesosSalida.add(p4);
			procesosSalida.add(p3);
			procesosSalida.add(p2);
			procesosSalida.add(p1);
			procesosSalida.add(p0);

			SistemaOperativo so = new SistemaOperativo(colaArribo);
			so.simular(50);
			
			Assert.assertEquals(procesosSalida, so.listarProcesosSalida());
	}
		
		public void simulacionPausada() {
			Proceso p0 = new Proceso("P0", 40, 5, 1);
			Proceso p1 = new Proceso("P1", 30, 5, 2);
			Proceso p2 = new Proceso("P2", 20, 5, 3);
			Proceso p3 = new Proceso("P3", 10, 5, 4);
			Proceso p4 = new Proceso("P4", 0, 5, 5);
			

			PriorityQueue<Proceso> colaArribo = new PriorityQueue<Proceso>(new OrdenadorProcesosArribo());
			colaArribo.add(p0);
			colaArribo.add(p1);
			colaArribo.add(p2);
			colaArribo.add(p3);
			colaArribo.add(p4);

			ArrayList<Proceso> procesosSalida = new ArrayList<Proceso>();
			procesosSalida.add(p4);
			procesosSalida.add(p3);
			

			SistemaOperativo so = new SistemaOperativo(colaArribo);
			so.simular(22);
			
			Assert.assertEquals(procesosSalida, so.listarProcesosSalida());
			
			procesosSalida.add(p2);
			procesosSalida.add(p1);
			procesosSalida.add(p0);
			
			so.simular(50);
			Assert.assertEquals(procesosSalida, so.listarProcesosSalida());
	}
	
}
