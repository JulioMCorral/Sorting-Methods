/*This class is represents a randomize algorithm
 * using the quicksort which take a random pivot
 * 
 * Methods are as follows:
 * 
 * binarySearch: principal method which computes and find
 *               a selected number in a sorted array
 * 
 * 
 * @author    Julio Corral
 * @date      12/01/10
 * @professor Dr. Fuentes
 * @T.A.      Jaime Nava
 */

import java.util.Random;
import java.util.Scanner;

public class RandomizeAlgorithm
{
    
    
    public static void main (String [] args)
    {
        Scanner console = new Scanner(System.in);
        
        
        //prompt the user the type the size of the array
        System.out.println("Type the size of the array: ");   
        int arraysize=console.nextInt();
        final int max=arraysize;
        
        //numbers in the array        
        int []list={98,10,6,564,87,88,76,77,65,66,54,55,43,44,6,32,33,21,11,22,12,23,34,45,56,67,78,89,3,5,1,456,2,67,2};
        
        //random variable
        Random randomPivot=new Random();
        
        
        //the pivot will be picked in a random way
        int first=randomPivot.nextInt(max);
        
        //print the index and the number of the random pivot
        System.out.println("Pivot in index: "+first 
                               + "\nIndex Number: "+ list[first]);
        System.out.println();
        int second=0;
        int last=0;
        
        //call for the methods on QuickSortAlgorithm
        partition(list, first, last);
        swap(list, first, second);
        recQuickSort(list, first, last);
        quickSort(list, max);
        printQuick(list, max);  
        
        
    }
    
    /*Method partition which is taking a random pivot
     * 
     * param  --> int first: random pivot the is the first value
     * param  --> int [] list: passing the array
     * param  --> int last: the last number
     * 
     * @return  --> int: the smallest index
     * 
     */
    public static int partition(int [] list, int first, int last)
    {
        int pivot;
        int smallIndex;
        
        swap(list, first, (first+last)/2);
        pivot=list[first];
        smallIndex=first;
        
        
        for(int index=first+1;index<=last;index++)
        {
            
            if(list[index]<pivot)
            {
                smallIndex++;
                swap(list, smallIndex, index);
            }
        }
        
        swap(list, first, smallIndex);
        return smallIndex;
    }
    
    
    /*Method swap make the change in the sub arrays
     * 
     * param  --> int first: random pivot the is the first value
     * param  --> int [] list: passing the array
     * param  --> int last: the last number
     * 
     * @return  --> void type 
     * 
     */
    public static void swap(int [] list, int first, int second)
    {
        
        int temp;
        temp=list[first];
        list[first]=list[second];
        list[second]=temp;
    }
    
    /*Method recQuickSort which recall the other method to make
     *      the same task in each sub array
     * 
     * param  --> int first: random pivot the is the first value
     * param  --> int [] list: passing the array
     * param  --> int last: the last number
     * 
     * @return  --> int: the smallest index
     * 
     */
    public static void recQuickSort(int [] list, int first, int last)
    {
        if(first<last)
        {
            
            int pivotLocation=partition(list, first, last);
            
            recQuickSort(list, first, pivotLocation-1);
            
            recQuickSort(list, pivotLocation+1, last);
        }
    }
    
    /*Method quickSort which recal the method recQuickSort
     * 
     * param  --> int first: random pivot the is the first value
     * param  --> int [] list: passing the array
     * param  --> int last: the last number
     * 
     * @return  --> void type
     * 
     */
    public static void quickSort(int [] list, int length)
    { 
        recQuickSort(list, 0, length-1);
    }
    
    /*Method printQuick which prints the array sorted
     * 
     * param  --> int [] list: passing the array
     * param  --> int size: size of the array
     * 
     * @return  --> void type printing the numbers of the array
     * 
     */
    public static void printQuick(int[] list, int size)
    {
        
        int i;
        
        for( i=0; i < size;i++)
            
            System.out.println(list[i]);
        
    }
}

