package ordenar;

public class Heap<E extends Comparable<E>> {

    private int A[];
    private int ultimo;
    private int capacity;

    public Heap() {
        A = new int[11];
        ultimo = 0;
        capacity = 10;
    }

    public Heap(int cap) {
        A = new int[cap + 1];
        ultimo = 0;
        capacity = cap;
    }

    public int min() {
        if (ultimo == 0) {
        	return  A[1];
        }
		return -1;
    }

    private int compare(Object x, Object y) {
        return ((E) x).compareTo((E) y);
    }

    public void insert(int e) {
        if (!(ultimo == capacity)){
            
            ultimo++;
            A[ultimo] = e;
            flotar();
        }       
    }

    public int removeMin() {
        if (ultimo!=0){
            int min = min();
            A[1] = A[ultimo];
            ultimo--;
            hundir();
            return min;
        }
		return -1;
    }

    private void hundir(){
        int index = 1;
        while (true){
            int child = index*2;
            if (child > ultimo)
                break;
            if (child + 1 <= ultimo){
                child = findMin(child, child + 1);
            }
            if (compare(A[index],A[child]) <= 0 )
                break;
            intercambio(index,child);
            index = child;
        }
    }

    private void flotar(){
        int index = ultimo;
        while (index > 1){
            int parent = index / 2;
            if (compare(A[index], A[parent]) >= 0)
                break;
            intercambio(index,parent);
            index = parent;
        }       
    }

  
    private void intercambio(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private int findMin(int leftChild, int rightChild) {
        if (compare(A[leftChild], A[rightChild]) <= 0)
            return leftChild;
        else
            return rightChild;
    }
    
    public static void heaps(int array[], int m) {
    	Heap<Integer> h = new Heap<>(array.length);
    	for(int i = 0;i < array.length; i++)
    		h.insert(array[i]);
    	for(int i =0; i < m;i++)
    		array[i] = h.removeMin();
    }
}