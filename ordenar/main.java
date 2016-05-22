package ordenar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class main {
	static int m = 300;
	static int[] lista = new int[100000000];
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Fichero: ");
		File file = new File(in.next());
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		int n = Integer.parseInt(s);
		int[] array = new int[n];
		for (int i =0; i<n;i++){
			
			s = br.readLine();
			array[i] = Integer.parseInt(s);
		}
		s = br.readLine();
		int m = Integer.parseInt(s);
		
		System.out.println("1.SelectionSort");
		System.out.println("2.InsertionSort");
		System.out.println("3.MergeSort");
		System.out.println("4.QuickSort");
		System.out.println("5.HeapSort");
		int option = in.nextInt();
		switch(option){
		case 1:
			long tiempo_inicio = System.nanoTime();
			array = selectionSort.SelectionSort(array);
			long tiempo = (System.nanoTime() - tiempo_inicio);
			System.out.println("Tiempo =  "+ tiempo);
			System.out.println("Resultado =");
			for(int i =0; i<m;i++){System.out.println(array[i]);}
			break;
			
		case 2:
			long tiempo_inicio2 = System.nanoTime();
			array = insertionSort.InsertionSort(array);
			long tiempo2 = (System.nanoTime() - tiempo_inicio2);
			System.out.println("Tiempo =  "+ tiempo2);
			System.out.println("Resultado =");
			for(int i =0; i<m;i++){System.out.println(array[i]);}
			break;
			
		case 3:
			long tiempo_inicio3 = System.nanoTime();
			int[] tempMergArr = new int[n]; 
			MergerSort.mergesort(array);
			long tiempo3 = (System.nanoTime() - tiempo_inicio3);
			System.out.println("Tiempo =  "+ tiempo3);
			System.out.println("Resultado =");
			for(int i =0; i<m;i++){System.out.println(array[i]);}
			break;
			
		case 4:
			long tiempo_inicio4 = System.nanoTime();
			shuffleArray(array);
			QuickSort.quicksort(array, 0, n-1);
			long tiempo4 = (System.nanoTime() - tiempo_inicio4);
			System.out.println("Tiempo =  "+ tiempo4);
			System.out.println("Resultado =");
			for(int i =0; i<m;i++){System.out.println(array[i]);}
			break;
		
		case 5:
			long tiempo_inicio5 = System.nanoTime();
			int arr[] = new int[m];
			 Heap.heaps(array, m);
			 long tiempo5 = (System.nanoTime() - tiempo_inicio5);
			 System.out.println("Tiempo =  "+ tiempo5);
				System.out.println("Resultado =");
				for(int i =0; i<m;i++){System.out.println(arr[i]);}
				break;
		}
		
	}
	
	
	
	
	static void shuffleArray(int[] ar)
	  {
	    // If running on Java 6 or older, use `new Random()` on RHS here
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
}

