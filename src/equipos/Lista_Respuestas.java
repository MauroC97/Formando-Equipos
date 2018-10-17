package equipos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lista_Respuestas {
	int preguntas,colaboradores;
	String [] respuestas;
	String input,output;
	Equipo max_afinidad;
	
	public Lista_Respuestas(String input, String output) {
		this.input = input;
		this.output = output;
		max_afinidad = new Equipo("a",0);
	}
	
	public void obtener_respuestas() throws IOException {
		Scanner sc = new Scanner(new File(input));
		int i;
		this.preguntas=sc.nextInt();
		this.colaboradores=sc.nextInt();
		this.respuestas = new String [this.colaboradores];
		for (i=0;i<this.colaboradores;i++)
			this.respuestas[i]=sc.nextLine();
		
		sc.close();
	}
	
	public void encontrar_equipo() {
		
		
	}
	
	public void generar_arch_salida() throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(output));
		pw.println(max_afinidad.afinidad);
		pw.println(max_afinidad.resp_en_comun);
		pw.close();
	}
}
