import java.util.Random;
import java.util.Scanner;


public class ComputerInformationHighway {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        
        int size = in.nextInt();
        int unsorted[] = new int[size];
        
        for(int i = 0; i < size; i++) {
            unsorted[i] = r.nextInt(1000000);
        }
        
        mergeSort(unsorted, 0, unsorted.length-1);
        search(unsorted, 0, unsorted.length, 50);
    }
    
    public static void search(int[] array, int min, int max, int value) {
        
        if(max > min) {
            int mid = (min + max)/2;

            if(array[mid] == value)
                System.out.printf("%d\t%d\n", mid, array[mid]);
            else if(array[mid] > value)
                search(array, min, mid, value);
            else
                search(array, mid+1, max, value);
        }
    }
    
    public static void swap(int[] array, int x, int y) {
        if(x < array.length && y < array.length) {
            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
    }
    
    public static void bubbleSort(int[] unsorted) {
        for(int k = 0; k < unsorted.length; k++) 
            for(int j = 0; j < unsorted.length - k - 1; j++) 
                if(unsorted[j] > unsorted[j+1])
                    swap(unsorted, j, j+1);
    }
    
    public static void merge(int[] unsorted, int start, int mid, int end) {
        //Left instance of list
        int[] lList = new int[mid - start + 2];
        for(int i = start; i < mid+1; i++)
            lList[i - start] = unsorted[i]; 
        
        lList[mid - start + 1] = Integer.MAX_VALUE;
        
        //Right instance of list
        int[] rList = new int[end - mid + 1];
        for(int i = mid + 1; i < end + 1; i++)
            rList[i - mid  - 1] = unsorted[i]; 
        
        rList[end - mid] = Integer.MAX_VALUE;
        
        //Merge two lists onto old array.
        int i = 0, j = 0;
        for(int k = start; k < end + 1; k++) {
            if(lList[i] < rList[j])
                unsorted[k] = lList[i++];
            else
                unsorted[k] = rList[j++];
        }
    }
    
    public static void mergeSort(int[] unsorted, int start, int end) {
        if(start < end) {
             int mid = (start + end)/2;
             mergeSort(unsorted, start, mid);
             mergeSort(unsorted, mid + 1, end);
             merge(unsorted, start, mid, end);
        }
    }
}