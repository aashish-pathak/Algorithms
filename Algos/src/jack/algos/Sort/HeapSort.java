/*
 * Worst case: O(n logn)
 * */

package jack.algos.Sort;

import java.util.Scanner;

public class HeapSort {
    private static int N;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );        
        int n, i;    
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();    
        int arr[] = new int[ n ];
        System.out.println("\nEnter "+ n +" integer elements");
        for (i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        
        sort(arr);
        /* Print sorted Array */
        System.out.println("\nElements after sorting ");        
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");            
    }    
    
    /* Sort Function 
     * Complexity is n * O(maxheap) = n * log n
     *  = n logn
     * */
    public static void sort(int arr[]) {       
        heapify(arr);        
        for (int i = N; i > 0; i--) {
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
           // System.out.println("\nAfter i = " + i);
           // for(int kk=0; kk<arr.length; kk++)
           //	System.out.print(arr[kk] + " ");
        }
    }
    
    public static void heapify(int arr[]) {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);        
    }
    
    /*  Complexity of this functoin is log n
     * since there are 2 comparisons made at every level and there can be max log n levels,
     * complexity = 2 * log n = log n
     * */
    public static void maxheap(int arr[], int i) { 
        //int left = 2*i ;
        //int right = 2*i + 1;
        //since arr starting from index 0, children will be at follow. positions
        int left = 2*i + 1 ;
        int right = 2*i + 2;
        int maxIndex = i;
        if (left <= N && arr[left] > arr[i])
            maxIndex = left;
        if (right <= N && arr[right] > arr[maxIndex])        
            maxIndex = right;
        if (maxIndex != i) {
            swap(arr, i, maxIndex);
            maxheap(arr, maxIndex);
        }
    }
   
    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }
    
}
