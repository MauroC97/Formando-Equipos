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
		
		int i,j,k;
		int apariciones;
		String comb_respuestas;
		Equipo eq_act;
		for(i=this.preguntas;i>0;i--)
		{
			for(j=1;j<this.colaboradores;j++)
			{
				comb_respuestas=this.respuestas[j-1].substring(0, i-1);
				apariciones=1;
				if(!comb_respuestas.equals(max_afinidad.resp_en_comun))
				{
					for (k=j;k<this.colaboradores;k++)
					{
						if(comb_respuestas.equals(this.respuestas[k-1]))
						apariciones++;
					}
				}
				if(apariciones>1)//una sola persona no es equipo
				{
					eq_act= new Equipo(comb_respuestas,apariciones);
					this.max_afinidad= (this.max_afinidad.afinidad>eq_act.afinidad)?this.max_afinidad:eq_act;
					
				}
			}
		}
		
	}
	
	public void generar_arch_salida() throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(output));
		pw.println(max_afinidad.afinidad);
		pw.println(max_afinidad.resp_en_comun);
		pw.close();
	}
}
