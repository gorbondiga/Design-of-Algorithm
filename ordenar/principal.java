package ordenar;

import java.util.ArrayList;

public class principal {
	static int m = 300;
	
	public static void main(String[] args) {
		int[] n10 = new int[1000000];
		int[] n9 = new int[900000];
		int[] n8 = new int[800000];
		int[] n7 = new int[700000];
		int[] n6 = new int[600000];
		int[] n5 = new int[500000];
		int[] n4 = new int[400000];
		int[] n3 = new int[300000];
		int[] n2 = new int[200000];
		int[] n1 = new int[100000];
		
		
		for(int i=0; i < n10.length; i++) {
			int aux = (int) (Math.random()*700 + 1);
			n10[i] = aux;
			if (i < n9.length)
				n9[i] = aux;
			if (i < n8.length)
				n8[i] = aux;
			if (i < n7.length)
				n7[i] = aux;
			if (i < n6.length)
				n6[i] = aux;
			if (i < n5.length)
				n5[i] = aux;
			if (i < n4.length)
				n4[i] = aux;
			if (i < n3.length)
				n3[i] = aux;
			if (i < n2.length)
				n2[i] = aux;
			if (i < n1.length)
				n1[i] = aux;
		}
		
		ArrayList<int[]> lista = new ArrayList<int[]>();
		lista.add(n1); lista.add(n2); lista.add(n3); lista.add(n4);
		lista.add(n5); lista.add(n6); lista.add(n7); lista.add(n8);
		lista.add(n9); lista.add(n10);
		
		
		for(int j=0; j < lista.size();j++) {
			long TInicio = System.currentTimeMillis();
			//primer programa, selecction sort.
			//int[] aux = selectionSort.SelectionSort(lista.get(j));
			//int[] aux = insertionSort.InsertionSort(lista.get(j));
			//QuickSort.quicksort(lista.get(j), 0, lista.get(j).length-1);
			//MergerSort.mergesort(lista.get(j));
			/*Heap<Integer> hea = new Heap<Integer>(lista.get(j).length-1);
			for(int h=0;h < lista.get(j).length; h++)
				hea.insert(lista.get(j)[h]);
			*/
			//kprimeros.k_primeros(lista.get(j), 0, (lista.get(j).length-1)/2, lista.get(j).length-1);
			//lista.add(j, aux);
			for(int i=0;i < m; i++) {
				//System.out.println(hea.removeMin());
				//System.out.println(lista.get(j)[i]);
			}
			
			long TFin = System.currentTimeMillis();
			long time = (TFin - TInicio)/ 1000;
			System.out.println("n"+(j+1)+" tiempo en segundos MergeSort: "+ time);
		}

	}
}
