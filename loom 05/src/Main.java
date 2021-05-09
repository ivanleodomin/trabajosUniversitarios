import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class Main {

	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException, ContactoInexistenteEx{

		Agenda agenda = new Agenda();
		System.out.print("ingrese ruta del archivo \n");
		agenda.cargarArchivo(in.readLine());
		boolean proceso = true;
		while(proceso) {
			System.out.print("Que deseas hacer? (Colocar numero de la operacion) \n" 
					+"1. Nuevo contacto\n"
					+"2. Mostrar agenda\n"
					+"3. Borrar contacto\n"
					+"4. Guardar archivo y salir\n");	
			int operacion = Integer.parseInt(in.readLine());
			
			if(operacion == 4) {
				System.out.print("Direccion en la cual guardar: \n");
				agenda.guardarAgenda(in.readLine());
				proceso = false;
				System.out.print("Hemos terminado, Adios!");
			}else if(operacion > 4 || operacion < 1)
				System.out.print("Numero de operacion invalida");
			else
				operar(operacion, agenda);
			
		}
		
							

	}

	private static void operar(int operacion, Agenda agenda) throws IOException, ContactoInexistenteEx {
		if(operacion == 1) 
			agregar(agenda);
		else if(operacion == 2)
			agenda.mostrarTodosLosContactos();
		else if(operacion == 3) {
			borrar(agenda);
		}
		
	}

	private static void borrar(Agenda agenda) {
		System.out.print("Ingrese apellido del contacto:\n");
		try {
			agenda.borrarContacto(in.readLine());
		} catch (ContactoInexistenteEx | IOException e) {
			System.out.print("No se pudo eliminar el contacto porque: "+ e+ "\n");
		}
	}

	private static void agregar(Agenda agenda) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("ingrese nombre: ");
		String nombre = in.readLine();
		System.out.print("ingrese apellido: ");
		String apellido = in.readLine();
		System.out.print("ingrese correo: ");
		String mail = in.readLine();
		agenda.agregarContacto(nombre, apellido, mail);
		System.out.print("Ingresado correctamente!\n");
		
	}


}
