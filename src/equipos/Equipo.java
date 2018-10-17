package equipos;

public class Equipo {
	String resp_en_comun;
	int cant_integrantes;
	int afinidad;
	public Equipo(String respuestas, int cant_integrantes) {
		this.resp_en_comun = respuestas;
		this.cant_integrantes = cant_integrantes;
		this.afinidad = cant_integrantes * resp_en_comun.length() * resp_en_comun.length();
	}
	
	

}
