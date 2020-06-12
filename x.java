
import java.util.Scanner;

public class x {
 /*Julio M. Corral
 jmcorral2@miners.utep.edu
 MWF *10:30 to 11:20
 04/20/10
 Assignment#10, Jaime Nava
 Heap Sort*/

 //Quick sort also divides the list, but this algoritm select a
 //pivot (often the first number of each list and sublist)
 //then we will place the number less than the pivot to the left
 //and these numbers greater than the pivot to the rigth
 
     public static void main (String [] args)
     {
      Scanner console = new Scanner(System.in);
         //a list of unorder numbers
         
         //set size to the length of the list
      System.out.println("Type the size of the array: ");   
      int arraysize=console.nextInt();
         final int max=arraysize;
         int []list={4,7,1,5,2,3,9,80,67,45,34,23,12,87,65,43,21,66,203,182,123,234,222,111,13,40};
         
         

         int first=0;
         int second=0;
         int last=0;
         
         //call for the methods on QuickSortAlgorithm
      
      
         
         System.out.println("Type the k-th largest element of the current array: ");
         int elem=console.nextInt();
         
         
         partition(list, first, last);
         swap(list, first, second);
         modifiedQuickSort(list, first, last,elem);
         modifiedQuickSelect(list, max);
        
         
         printQuick(list,max,elem);
         
     }
  
     //method partition which identify and return the pivot
     public static int partition(int [] list, int first, int last)
     {
         int pivot;
         int smallIndex;
         //call swap method
         swap(list, first, (first+last)/2);
         pivot=list[first];
         smallIndex=first;
         
         for(int index=first+1;index<=last;index++)
         {
             //swap if the index is less than the current pivot
             if(list[index]<pivot)
             {
                 smallIndex++;
                 swap(list, smallIndex, index);
             }
         }
         //call swap method and return the samll index
         swap(list, first, smallIndex);
         return smallIndex;
     }
     
     
     
     public static void swap(int [] list, int first, int second)
     {
         //creating temp to set the value of the first index without erease it
         int temp;
         temp=list[first];
         list[first]=list[second];
         list[second]=temp;
     }
     
  
     public static int modifiedQuickSort(int[] list, int left, int right, int kth)
     {
     int i = left;


     //right side scan
     int j = right;
     
     //there are at least two elements to sort
     if(right-left >= 1)
     {
      
     //set the pivot as the first element in the partition
     int pivot = list[left];

     //while right and left have not met
     while(j > i)
     {

     //from the begining, look for the first
     while (list[i] <= pivot && i <= right && j > i)
     {
     i++;
     }

     //from the right, look for the first
     while(list[j] > pivot && j >= left && j >= i)
     {
     j--;
     }
     //swap if right is less than left

     if (j >i)
     {

     swap(list, i, j);
     }
     }

     //swap the last element in the left partition with pivot

     swap(list, left, j);

     //pivot is in correct place

     //return kth instantly if kth is the first
     if (kth == j) 
     {

     return list[j]; 
     } 
     //if less than pivot, recursive call to the left of pivot
     else if (kth < j) 
     {

     return modifiedQuickSort(list, left, j - 1, kth);

     } 
     else 
     {

     // recursion call, to the right of pivot

     return modifiedQuickSort(list, j + 1, right, kth);
     }
     }

     //if there is only one element in the partition, return it
     else
     {

     return list[j];
     }


     } 
     
     public static int modifiedQuickSelect(int list[], int k)
     {

     return modifiedQuickSort(list, 0, list.length - 1, list.length - k);

     } 
     
   
     
     
     //print the sorted list
    
     public static void printQuick(int[] list, int size, int elem)
     {
      
      int i;
         for( i=0; i < size;i++)
          System.out.println(list[i]);
         int kht=elem-1; 
         
         System.out.println(); 
         System.out.println("The k-th largest element " +elem+" in the array is "+list[kht]);
     }     
     }
 

