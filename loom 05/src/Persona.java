
public class Persona {

	private String nombre;
	private String apellido;
	private String mail;

	public Persona(String pNombre, String pApellido, String pMail) {
		try {
			controlDeEntrada(pNombre, pApellido, pMail);

			// Elimino las comas

			setNombre(pNombre.replaceAll(",", ""));
			setApellido(pApellido.replaceAll(",", ""));
			setMail(pMail.replaceAll(",", ""));

		} catch (ContactoConCaracteresInvalidosException e) {
			System.out.print("No pudimos agregar el contacto '" + pApellido + "', ya que: " + e + "\n");
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

	public void setApellido(String pApellido) {
		this.apellido = pApellido;
	}

	public void setMail(String pMail) {
		this.mail = pMail;
	}

	@Override
	public String toString() {

		return "nombre: " + getNombre() + ", apellido: " + getApellido() + ", mail: " + getMail() + "\n";

	}

	private void controlDeEntrada(String pNombre, String pApellido, String pMail)
			throws ContactoConCaracteresInvalidosException {

		if (pNombre == null || pNombre == "")
			throw new ContactoConCaracteresInvalidosException("Nombre invalido\n");
		if (pApellido == null || pApellido == "")
			throw new ContactoConCaracteresInvalidosException("Apellido invalido\n");
		if (!this.mailValido(pMail))
			throw new ContactoConCaracteresInvalidosException("Correo invalido\n");

	}

	private boolean mailValido(String mail) {
		boolean punto = false;
		boolean arroba = false;
		for (int i = 0; i < mail.length(); i++) {
			if (mail.charAt(i) == '@')
				arroba = true;
			if (mail.charAt(i) == '.')
				punto = true;
		}
		return (arroba && punto && (mail.length() > 7));
	}

}
