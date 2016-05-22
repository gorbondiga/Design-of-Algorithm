package Bactrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class mainB {

	public static void main(String[] args) throws FileNotFoundException {
		int[] pesos;
		int[] pagos;
		int N;// numero de solicitantes
		int T;// peso maximo a transportar
		int P;// plazas ofertadas
		
		int arbol;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Introducir nombre del fichero: 'fichero.txt'");
		String file = s.next();
		
        Scanner sc = new Scanner(new File(file));
        P = sc.nextInt();
        T = sc.nextInt();
        N = sc.nextInt();
        
        pesos = new int[N];
        pagos = new int[N];
        
        int i=0;
        while(i < N) {
        	pagos[i] = sc.nextInt();
        	pesos[i] = sc.nextInt();
        	i++;
        }
        
        System.out.println("Introducir backtrack a utilizar, modelo de arbol binario o n-ario: (0/1)");
        arbol = s.nextInt();
        
        Backtrack back = new Backtrack(P, T, pagos, pesos, N);
        
        int[] result = new int[P];
        for(int x=0; x < P;x++)
        	result[x] = -1;
        
        long tiempo_inicio, tiempo;
        
        if(arbol == 0) {
        	tiempo_inicio = System.nanoTime();
        	back.backtrack_if(0, result, 0, 0, 0);
        	tiempo = (System.nanoTime() - tiempo_inicio);
        } else {
        	tiempo_inicio = System.nanoTime();
        	back.backtrack_n(0, result, 0, 0, 0);
        	tiempo = (System.nanoTime() - tiempo_inicio);
        }
        	
        s.close();
        sc.close();
        
        
		
       /* DATOS DE SALIDA */
        System.out.println("Viajeros que iran a la antartida: ");
        System.out.println(back.Plazas);
        
       	back.printSol();
        
        System.out.println("Beneficio obtenido: ");
        System.out.println(back.ganancias);
        
        System.out.println("Ensayos creados: ");
        System.out.println(back.count);
        
        System.out.println("--------------------");
        tiempo = (long) (tiempo * 1e-9);
        System.out.println("Tiempo en segundos =  "+ tiempo);
        System.out.println("Tiempo en minutos =  "+ (float)(tiempo / 60));
    }
}