package ordenar;

public class MergerSort {
	
	private static int[] array;
    private static int[] tempMergArr;
    private static int length;
	
	 public static void mergesort(int inputArr[]) {
	        array = inputArr;
	        length = inputArr.length;
	        tempMergArr = new int[length];
	        MergeSort(0, length - 1);
	    }
	 
	    private static void MergeSort(int lowerIndex, int higherIndex) {
	         
	        if (lowerIndex < higherIndex) {
	            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
	            MergeSort(lowerIndex, middle);
	            MergeSort(middle + 1, higherIndex);
	            merge(lowerIndex, middle, higherIndex);
	        }
	    }
	 
	    private static void merge(int lowerIndex, int middle, int higherIndex) {
	 
	        for (int i = lowerIndex; i <= higherIndex; i++) {
	            tempMergArr[i] = array[i];
	        }
	        int i = lowerIndex;
	        int j = middle + 1;
	        int k = lowerIndex;
	        while (i <= middle && j <= higherIndex) {
	            if (tempMergArr[i] <= tempMergArr[j]) {
	                array[k] = tempMergArr[i];
	                i++;
	            } else {
	                array[k] = tempMergArr[j];
	                j++;
	            }
	            k++;
	        }
	        while (i <= middle) {
	            array[k] = tempMergArr[i];
	            k++;
	            i++;
	        }
	 
	    }
}