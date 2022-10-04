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

	private static void insertionSort(int a[], int low, int high) {
   
		for (int i = low + 1; i <= high; i++) {
			for (int j = i - 1; j >= low; j--) {
				if (a[j] > a[j + 1]) {
					// Swap
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
				else
					break;
			}
		}
	}

	private static int partition(int arr[], int low,
								int high)
	{
		int pivot = arr[high];
		int i = low;
		int j = low;

		while (i <= high) {
			if (arr[i] > pivot)
				i++;
			else {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j++;
			}
		}
		return j - 1;
	}

	public static void quicksort(int arr[], int low,
									int high)
	{
		while (low < high) {
			// Check if array size on which we will be working is less than 10
			if (high - low < 10) {
				insertionSort(arr, low, high);
				break;
			}
			else {
				int pivot = partition(arr, low, high);

				// We will do recursion on small size
				// subarray So we can check pivot - low and
				// pivot - high

				if (pivot - low < pivot - high) {
					quicksort(arr, low, pivot - 1);
					low = pivot + 1;
				}
				else {
					quicksort(arr, pivot + 1, high);
					high = pivot - 1;
				}
			}
		}
	}

	public static void main(String[] args) {

		int size = 10; //this will go in the for loop like our last program
      
      int[] arr = new int[size]; 
      
      generateArray(arr); 

      //TEST//
      System.out.print("generated array arr: "); 
      for(int i = 0; i < arr.length-1; i++) {
         System.out.print(arr[i] + ", "); 
      }
      System.out.println(arr[arr.length-1]); 
      //END//

		quicksort(arr, 0, arr.length - 1);
      
      //TEST
      System.out.print("sorted array arr: "); 
      for(int i = 0; i < arr.length-1; i++) {
         System.out.print(arr[i] + ", "); 
      }
      System.out.println(arr[arr.length-1]); 
      //END//

	}
}



