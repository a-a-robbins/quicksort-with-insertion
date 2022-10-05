// Quicksort with Insertion Sort
// COSC 330 - Algorithms
// Ashley Robbins & Trong Bao
// Sep 28 2022

import java.util.Random; 
import java.util.Arrays; 

class Quicksort {

   private static Random rand = new Random(); 
   
   private static void generateArray(int[] arr) {
   
      for(int i = 0; i < arr.length; i++) {
      
         arr[i] = rand.nextInt(100); //DON'T FORGET TO CHANGE ME!!
         
      }
   
   }
   
   private void swap(int i, int j) {
   
      int temp = i;
      i = j;
      j = temp;
      
   }
   
   public static void quicksort(int[] arr, int cutoff) {
      
      quicksort(arr, 0, arr.length-1, cutoff); 
      
   }

   private static void quicksort(int arr[], int low, int high, int cutoff) {
   		
            if (arr.length <= cutoff) {
   				insertionSort(arr, low, high);
   			}
            
   			else {
   				int pivot = partition(arr, low, high);
   
   					quicksort(arr, low, pivot - 1, cutoff);
   				
   					quicksort(arr, pivot + 1, high, cutoff);
   				
   			}
   		}
   	
   

	private static int partition(int arr[], int low, int high) {
   
		int pivot = arr[high];
		int i = low-1;
		int j = low;

		while (i <= high) {
			if (arr[i] > pivot)
				i++;
			else {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
            //FIXME: Trong, can you figure out why this doesn't work? I copied it from lecture code...
            //swap(arr[i], arr[j]);
				i++;
				j++;
			}
		}
		return i + 1;
	}
   
   	private static void insertionSort(int arr[], int left, int right) {
   
		for (int i = left + 1; i <= right; i++) {
      
         int key = arr[i]; 
         int j = i - 1; 
	
            while(j >= 0 && arr[j] > key) {
            
               arr[j + 1] = arr[j]; 
               j = j - 1; 
               
				}
            
            arr[j + 1] = key; 
			}
	}

		public static void main(String[] args) {

		int size = 9; //this will go in the for loop like our last program
      int cutoff = 10; 
      
      int[] arr = new int[size]; 
      
      generateArray(arr); 

      //TEST//
      System.out.print("generated array arr: "); 
      for(int i = 0; i < arr.length-1; i++) {
         System.out.print(arr[i] + ", "); 
      }
      System.out.println(arr[arr.length-1]); 
      //END//

		quicksort(arr, cutoff);
      
      //TEST
      System.out.print("sorted array arr: "); 
      for(int i = 0; i < arr.length-1; i++) {
         System.out.print(arr[i] + ", "); 
      }
      System.out.println(arr[arr.length-1]); 
      //END//

	}
}



