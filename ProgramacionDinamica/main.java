package ProgramacionDinamica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class main {

	public static void main(String[] args) throws FileNotFoundException {
		int[][] M = null;
		int[][] P = null;
		int N;
		int L;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Introducir nombre del fichero: 'fichero.txt'");
		String file = s.next();
		
        Scanner sc = new Scanner(new File(file));
        N = sc.nextInt();
        L = sc.nextInt();
        
        if(N > 101 || L > 501)
        	System.out.println("fichero erroneo, no cumple condiciones.");
        else {
        	P = new int[N+1][L+1];
        	M = new int[N+1][L+1];
        	
        	int i = 1;
            while(i <= N) {
            	for(int j=1; j <= L;j++)
            		P[i][j] = sc.nextInt();
            	i++;
            }
        }
        s.close();
        sc.close();
        
        long tiempo_inicio = System.nanoTime();
        EstimacionLitros e = new EstimacionLitros(L, N);
        e.Est(M, P, N, L);
        long tiempo = (System.nanoTime() - tiempo_inicio);
		
        System.out.println("Para "+L+" litros se llena en cada deposito ->");
        for(int w=1; w <= N; w++) {
        	System.out.println(w+"º "+e.getResultado(N,L)[w]+" litros");
        }
        
        System.out.println(M[N][L]);
        
        System.out.println("Tiempo en nanosegundos =  "+ tiempo);
		
    }
}
