/*Julio M. Corral
 jmcorral2@miners.utep.edu
 M-W *9:00 to 10:20
 02/21/12
 Assignment#1, 
 Teacher: Heather D. Pfeiffer ---- TA:Maria G. Jimenez
 Selection Sort and find the k-ht largest element)*/

import java.util.Random;
import java.util.Scanner;

public class QuickSelect 
{
    
    
    
    public static void main (String [] args)
    {
        Scanner console = new Scanner(System.in);
        
        //prompt the user the type the size of the array
        System.out.println("Type the size of the array: ");   
        int arraysize=console.nextInt();
        final int max=arraysize;
        int []list=randomWalkArray(10000000);
        
        
        long start, end;
        int first=0;
        
        int last=max;
        
        
        
        //ask the user to enter the k-th element
        System.out.println("Type the k-th largest element of the current array: ");
        int elem=console.nextInt();
        
        start=System.nanoTime();
        //calling the methods
        partition(list, first, last);
        arrayIndex(list, elem);
        swap(list, first, last);
        recQuickSelect(list, last ,elem);
        end=System.nanoTime();
        
        //printing the numbers
        printQuick(list,max,elem);
        
        System.out.println("It takes " +(end-start)+ " nanoseconds to find the " + elem + " largest" 
                               +" number in the array");
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
     
    //Method which helps to swap the sub array and sotere 
    //the data in a extra varaible
    public static void swap(int [] list, int first, int second)
    {
        //creating temp to set the value of the first index without erease it
        int temp;
        temp=list[first];
        list[first]=list[second];
        list[second]=temp;
    }
    
    
    //method subarray to identify how many elements are
    //betten the largest number and the k-th largest number
    public static int[] arrayIndex(int[]a, int element)
    {
        
        int [] myarray = new int [a.length-element];
        int size=myarray.length;
        //traers to the array size until gets the k-th element
        for(int i = 0, x = element; i < size; i++, x++)
            
            myarray[i] = a[x];
        return myarray;
    }   
    
    
    public static int recQuickSelect(int[] a, int size, int element)
    {
        int pivot = size - 1;
        //set pivot to the last number of the unserted array
        
        pivot = partition(a, size-1, pivot);
        int nextpivot = pivot + 1;
        //Loop to set numbers in the sub array
        if (element == nextpivot)
        { 
            return pivot;
        }
        //the element is less than the nextpivot
        if (element < nextpivot)
            //make a recursive call to the left side of the subarray until this will be sorted
            return recQuickSelect(a, nextpivot- 1, element);
        else
            //identify the right subarray
            return pivot + 1 + recQuickSelect(arrayIndex(a, pivot +1), size-nextpivot, element-nextpivot);
        
    } 
    
    
    
    
    //method to print the list
    public static void printQuick(int[] list, int size, int elem)
    {
        
        int i;
        //travers the sorted array
        for(i=1;i<size;i++)
            System.out.println(list[i]);
        //substract the k-th largest element
        int kth=elem-1; 
        System.out.println(); 
        System.out.println("The k-ht largest element " + elem + " in this array is " + list[(size-1)-kth]);
    }     
    
    
    //method randomwalkarray that creats random numbers
    //"Provided by Olac Fuentes UTEP Web Site"
    public static int [] randomWalkArray(int n)
    {
        Random generator = new Random ();
        int [] randArray=new int[n];
        randArray[0]=0;
        for(int i=1;i<n;i++)
            randArray[i]=randArray[i-1] + generator.nextInt(100)-2;
        return randArray;
    }
}
