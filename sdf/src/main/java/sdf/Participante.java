package sdf;

public class Participante {
	public String nombre;
	public String apellidos;
	public String correo;
	public Participante participanteTocado;
	public boolean esTocado;

	
	public Participante(String nombre, String apellidos, String correo,Participante participanteTocado, boolean esTocado) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.participanteTocado = participanteTocado;
		this.esTocado = esTocado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Participante getParticipanteTocado() {
		return participanteTocado;
	}

	public void setParticipanteTocado(Participante participanteTocado) {
		this.participanteTocado = participanteTocado;
	}

	public boolean getEsTocado() {
		return esTocado;
	}

	public void setEsTocado(boolean esTocado) {
		this.esTocado = esTocado;
	}
	
	
	
	
}
