package Bactrack;

public class Backtrack {
	int Plazas;
	private int Tmax;
	int[] result;
	int ganancias;
	private int[] pagos;
	private int[] pesos;
	private int N;
	int count
	;
	
	public Backtrack(int sitios, int peso, int[] p, int[] w, int n) {
		Tmax = peso;
		ganancias = 0;
		pesos = w;
		pagos = p;
		N = n;
		count = 0;
		
	}


//Backtrack SIN poda...arbol binario --->
//	public void backtrack_if(int k, int[] sol, int sitios, int peso, int g) {
//		if(k == N | sitios == 0) {
//			if(g > ganancias & peso <= Tmax) {
//				ganancias = g;
//				result = sol;
//			}
//		} else {
//			sol[k] = k;
//			backtrack_if(k+1, sol, sitios-1, peso + pesos[k], g + pagos[k]);
//			sol[k] = 0;
//			backtrack_if(k+1, sol, sitios, peso, g);
//		}	
//	}

	
//Backtrack CON poda...arbol binario --->
	public void backtrack_if(int k, int[] sol, int sitios, int peso, int g) {
		if (k == N) {
			if (g > ganancias & peso <= Tmax) {
				ganancias = g;
				Plazas = sitios;
				asigResult(sol);
			}
		} else {
			if(peso + pesos[k] > Tmax) {
				count++;
				backtrack_if(k+1, sol, sitios, peso, g);
			} else if(!lleno(sol)){
				int pos = anadir(sol, k);
				count++;
				backtrack_if(k+1, sol, sitios+1, peso + pesos[k], g + pagos[k]);
				quitar(sol, -1, pos);
				count++;
				backtrack_if(k+1, sol, sitios, peso, g);
			}
		}
	}
	
// Backtrack SIN poda...arbol n-ario --->
//	public void backtrack_n(int k, int[] sol, int sitios, int peso, int g) {
//		if(peso <= Tmax && g > ganancias) {
//			ganancias = g;
//			result = sol;
//		}
//		for(int i=0; i < N;i++) {
//			if(!esta(i, sol)) {
//				sol[k] = i;
//				backtrack_n(k+1, sol, sitios+1, peso+pesos[i], g+pagos[i]);
//				sol[k] = 0;
//			}
//		}
//	}
	
//Backtrack CON poda...arbol n-ario --->
	public void backtrack_n(int k, int[] sol, int sitios, int peso, int g) {
		if(peso <= Tmax && g > ganancias) {
			ganancias = g;
			Plazas = sitios;
			asigResult(sol);
		}
		int aux;
		if(k == 0)
			aux = 0;
		else
			aux = sol[k-1];
		
		for(int i=aux+1; i < N;i++)
			if(peso+pesos[i] <= Tmax && !lleno(sol)) {
				int pos = anadir(sol, i);
				count++;
				backtrack_n(k+1, sol, sitios+1, peso+pesos[i], g+pagos[i]);
				quitar(sol, -1, pos);
			}
	}
	
	
	public void asigResult(int[] v) {
		int[] aux = new int[v.length];
		for(int i=0; i < aux.length;i++)
			aux[i] = -1;
		for(int j=0; j < v.length;j++)
			if(v[j] != -1)
				aux[j] = v[j];
		result = aux;
	}
	
	public boolean lleno(int[] sol) {
		for(int j=0; j< sol.length;j++)
			if(sol[j] ==-1)
				return false;
		return true;
	}
	
	public int anadir(int[] sol, int i) {
		for(int j=0; j< sol.length;j++)
			if(sol[j] ==-1) {
				sol[j] = i;
				return j;
			}
		return -1;
	}
	
	public void quitar(int[] sol, int v, int pos) {
		sol[pos] = v;
	}
	
	public void printSol() {
		for(int i =0; i < result.length; i++)
			if(result[i] != -1) {
				System.out.println("Viajero "+(result[i]+1));
			}
	}
}