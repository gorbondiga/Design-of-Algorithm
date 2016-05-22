package ProgramacionDinamica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class creardatos {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce el nombre del archivo:");
		String name = sc.next();
		
		System.out.print("Numero de tipos de depositos:");
		int n = sc.nextInt();
		
		System.out.print("Numero de miles de litros:");
		int l = sc.nextInt();
		sc.close();
		
		File archivo = new File(name);
		FileWriter fichero = null;
        PrintWriter pw = null;
		
		if(!archivo.exists()) {
			try
	        {
	            fichero = new FileWriter(name);
	            pw = new PrintWriter(fichero);
	            
	            pw.println(n);
				pw.println(l);
				for(int i=1; i <= n; i++) {
					for(int j=1; j <= l; j++) {
						int aux = (int)Math.floor(Math.random()*j + 1);
						pw.print(aux+" ");
					}
					pw.println();
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
