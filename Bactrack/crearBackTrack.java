package Bactrack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class crearBackTrack {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce el nombre del archivo:");
		String name = sc.next();
		
		System.out.print("Numero de personas apuntadas:");
		int n = sc.nextInt();
		
		System.out.print("Numero de plazas:");
		int p = sc.nextInt();
		
		System.out.print("Numero de peso maximo:");
		int t = sc.nextInt();
		
		sc.close();
		
		File archivo = new File(name);
		FileWriter fichero = null;
        PrintWriter pw = null;
		
		if(!archivo.exists()) {
			try
	        {
	            fichero = new FileWriter(name);
	            pw = new PrintWriter(fichero);
	            
	            pw.println(p+" "+t+" "+n);
				for(int i=0; i < n; i++) {
					int aux = (int)Math.floor(Math.random()*(2*(t+t/2)) + 1);
					int aux2 = (int)Math.floor(Math.random()*(t+t/2) + 1);
					pw.println(aux+" "+aux2);
				}
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
		}		
	}
	
}
