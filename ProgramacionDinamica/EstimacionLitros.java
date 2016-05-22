package ProgramacionDinamica;


public class EstimacionLitros {
    private static int[][] result;
    private static int[] solucion;

    public EstimacionLitros(int l, int n) {
    	result = new int[n+1][l+1];
    	solucion = new int[n+1];
    	
    	for(int h=0; h <= n; h++) {
    		solucion[h] = 0;
    		for(int j=0; j <=l; j++)
    			result[h][j] = 0;
    	}
    }

    public void Est(int[][] M, int[][] P, int N, int L) {

        for(int i= 0; i <= N; i++) {
            M[i][0] = 0;
        }
        for(int k = 1; k <= L; k++) {
            M[1][k] = P[1][k];
            result[1][k] = k;
        }

        for(int i=2; i <= N; i++)
        	for(int k=1; k <= L; k++) {
        		M[i][k] = M[i-1][k];
        		int count = 0;
        		for(int x=1; x <= k; x++) {
                	if(M[i][k] >
                		(M[i-1][k-x] + P[i][x])) {
                		M[i][k] = M[i-1][k-x] + P[i][x];
                		count = x;
                	}
                }
        		if(count != 0)
        			result[i][k] = count;
        	}
    }

    public int[] getResultado(int N, int L) {
    	if(N == 0) {
    		return solucion;
		} else if (result[N][L] == 0) {
			solucion[N] = 0;
			return getResultado(N - 1, L);
		} else {
			int aux = result[N][L];
			solucion[N] = aux;
			return getResultado(N - 1, L - aux);
		}
    }

}
