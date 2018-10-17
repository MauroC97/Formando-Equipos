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
			this.respuestas[i]=sc.next();
		
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
				comb_respuestas=this.respuestas[j-1].substring(0, i);
				apariciones=1;
				if(!comb_respuestas.equals(max_afinidad.resp_en_comun))
				{
					for (k=j+1;k<this.colaboradores+1;k++)
					{
						if(comb_respuestas.equals(this.respuestas[k-1].substring(0, i)))
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
		this.obtener_respuestas();
		this.encontrar_equipo();
		pw.println(max_afinidad.afinidad);
		pw.println(max_afinidad.resp_en_comun);
	//	pw.println(max_afinidad.cant_integrantes);
		pw.close();
	}
	
	public static void main(String[] args) throws IOException {
		Lista_Respuestas ls = new Lista_Respuestas("test/in/00_enunciado.in", "test/out/00_enunciado.out");
		ls.generar_arch_salida();
		Lista_Respuestas ls2 = new Lista_Respuestas("test/in/01_empate.in", "test/out/01_empate.out");
		ls2.generar_arch_salida();
		Lista_Respuestas ls3 = new Lista_Respuestas("test/in/02_pierde_eq_mas_grande.in", "test/out/02_pierde_eq_mas_grande.out");
		ls3.generar_arch_salida();
		Lista_Respuestas ls4 = new Lista_Respuestas("test/in/03_gana_mas_numeroso.in", "test/out/03_gana_mas_numeroso.out");
		ls4.generar_arch_salida();
		
	}
}

