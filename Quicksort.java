// Quicksort with Insertion Sort
// COSC 330 - Algorithms
// Ashley Robbins & Trong Bao
// Sep 28 2022

import java.util.Random; 
import java.util.Arrays; 

public class Quicksort {

   private static Random rand = new Random(); 
   
   private static void generateArray(int[] arr) {
   
      for(int i = 0; i < arr.length; i++) {
      
         arr[i] = rand.nextInt(100); //DON'T FORGET TO CHANGE ME!!
         
      }
   
   }

   public static void quicksort(int[] a) {
   
      int end = a.length-1; 
   
      quicksort(a, 0, end); 
      
   }
   
   private static void quicksort(int[] A, int start, int end) {
   
      if (start < end) {
         int mid = partition(A, start, end); 
         quicksort(A, start, mid-1); 
         quicksort(A, mid+1, end); 
      }
      
      //TEST//
      System.out.print("sorted array arr: "); 
      for(int i = 0; i < A.length-1; i++) {
         System.out.print(A[i] + ", "); 
      }
      System.out.println(A[A.length-1]); 
      //END//
   }
   
   private static int partition(int[] A, int start, int end) {
      
      int pivot = A[A.length-1];
      
      int i = A[start - 1]; 
      
      for(int j = start; j <= A.length-1; j++) {
         
         if(A[j] <= pivot) {
            
            i = i + 1; 
            //swap(A[i], A[j]); 
            int temp = A[i]; 
            A[i] = A[j]; 
            A[j] = temp; 
            
         }
         
         if(j == A.length-1) {
         
            //swap(A[i+1), pivot); 
            
            int temp = A[i+1]; 
            A[i+1] = pivot; 
            pivot = temp; 
         }
      
      } 
      
   
   
      //return 0; 
      return i + 1; 
   
   }
   
   //FIXME: I don't implement properly//
   private static void swap(int num1, int num2) {
   
      int temp = num1; 
      num1 = num2; 
      num2 = temp; 
   
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
      
  
      quicksort(arr, arr[0], arr[arr.length-1]); 


   }

}

