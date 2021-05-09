
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Agenda {
	private ArrayList<Persona> contactos;
	private BufferedReader lector;

	public Agenda() {
		contactos = new ArrayList<Persona>();
	}

	public void agregarContacto(String pNombre, String pApellido, String pMail) {
		Persona contacto = new Persona(pNombre, pApellido, pMail);
		contactos.add(contacto);
		
	}

	/**
	 * Borra un contacto de la agenda
	 * 
	 * @param pApellido Apellido del contacto a borrar
	 * @throws ContactoInexistenteEx si no se encuentra el apellido buscado
	 */
	public void borrarContacto(String pApellido) throws ContactoInexistenteEx {
		int indice;

		indice = this.buscarContacto(pApellido);
		contactos.remove(indice);
	}

	/**
	 * Busca un contacto por apellido
	 * 
	 * @param pApellido apellido del contacto buscado
	 * @return devuelve la primera aparición del apellido buscado
	 * @throws ContactoInexistenteEx si no existe ningún contacto con el apellido
	 *                               buscado
	 */
	private int buscarContacto(String pApellido) throws ContactoInexistenteEx {
		int i = 0;
		for (Persona contacto : contactos) {
			if (contacto.getApellido().equals(pApellido)) {
				return i;
			}
			i++;
		}

		throw new ContactoInexistenteEx(pApellido);
	}

	/**
	 * Muestra por pantalla todos los contactos de la Agenda Nota: no está bueno
	 * que un método muestre por pantalla los datos pero por ahora hasta que
	 * tengamos iteradores elegimos hacerlo de esta manera para no devolver todo el
	 * arreglo de contactos
	 */
	public void mostrarTodosLosContactos() {
		int i = 0;
		for (Persona contacto : contactos) {
			System.out.println(i + ":\t" + contacto);
			i++;
		}
		System.out.println("\nTotal: " + i + " contactos\n");
	}

	/**
	 * Carga todos los contactos que puede en al agenda. El formato del archivo de
	 * entrada es el siguiente: Una línea por cada contacto, y en cada linea
	 * separado por coma y etiquetados los datos del contacto. Ej nombre: Juan,
	 * apellido: Perez, mail: jperez@gmail.com
	 * 
	 * @param pArchivo nombre del archivo (path absoluto o relativo a la carpeta src
	 *                 del proyecto
	 * @throws IOException
	 */
	public void cargarArchivo(String pArchivo) throws IOException {
		try {
			this.lector = new BufferedReader(new FileReader(pArchivo));
			String contacto;

			while ((contacto = lector.readLine()) != null) {
				this.detectarLineasInvalidas(contacto);

			}

		} catch (FileNotFoundException e) {
			System.out.print("Archivo no encontrado, se generara uno al guardar:" + pArchivo
					+ "\n Ingrese nuevos contactos!!");
		}
	}

	private boolean detectarLineasInvalidas(String linea) {
		try {
			String[] datos = linea.split(" ");
			if (datos.length == 6) {
				agregarContacto(datos[1], datos[3], datos[5]);
			} else
				throw new ContactoConCaracteresInvalidosException("Contacto invalido");

			return true;
		} catch (ContactoConCaracteresInvalidosException e) {
			return false;
		}
	}

	/**
	 * Guarda la agenda completa en disco, en el archivo especificado como
	 * parámetro Con el siguiente formato. Una línea por contacto, con los datos
	 * etiquetados nombre: Juan, apellido: Perez, mail: jperez@gmail.com
	 * 
	 * @param pArchivo nombre del archivo (path absoluto o relativo a la carpeta src
	 *                 del proyecto
	 * @throws IOException 
	 */
	public void guardarAgenda(String pArchivo) throws IOException {
		FileWriter fw =new FileWriter(pArchivo);
		String agenda="";
		for (Persona contacto : contactos) {
			agenda += contacto;
			
		}
		fw.write("Agenda: \n" + agenda);
		fw.close();
	}
}
