package ColaDeProcesos;

import java.util.Comparator;

public class OrdenadorProcesosArribo implements Comparator<Proceso> {

	@Override
	public int compare(Proceso p1, Proceso p2) {
		return Long.compare(p1.getT_arribo(), p2.getT_arribo());

	}
}
