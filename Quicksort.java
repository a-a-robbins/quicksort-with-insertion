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
      
         arr[i] = rand.nextInt(); 
         
      }
   
   }
   
   public static void quicksort(int[] arr, int cutoff) {
      
      quicksort(arr, 0, arr.length-1, cutoff); 
      
   }

   private static void quicksort(int arr[], int low, int high, int cutoff) {
         
            if (((high-low) <= cutoff) && ((high-low) > 0)) {
               insertionSort(arr, low, high);
               
            }
            
            else {
               if(low < high){
                  int pivot = partition(arr, low, high);
                  quicksort(arr, low, pivot - 1, cutoff);
                  quicksort(arr, pivot + 1, high, cutoff);
               }
               
               
            }
         }
      
   

   private static int partition(int arr[], int low, int high) {
   
      int pivot = arr[high];
      int i = low-1;
      
      for (int j = low; j <= high -1; j++){
         if(arr[j] <= pivot){
            i = i + 1;
            //swap arr[i] with arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
         }
      }
      int temp = arr[i+1];
      arr[i+1] = arr[high];
      arr[high] = temp;
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

      int size = 8000000;
      int[] arr = new int[size]; 
      
       
      for(int cutoff = 0; cutoff <= 200; cutoff += 20){
         int totalTime = 0;
         for(int i = 1; i <= 20; i++){
            long time = 0;
            generateArray(arr);
            long start = System.currentTimeMillis();
            quicksort(arr, cutoff);
            time += System.currentTimeMillis() - start;
            totalTime += time;
            System.out.println("time:" + time);
         }
         int averageTime = totalTime/20;
         System.out.println("Cutoff: " + cutoff  + "\t Time: " + averageTime);
      }
   }
}