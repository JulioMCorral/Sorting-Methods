/*Julio M. Corral
 jmcorral2@miners.utep.edu
 M-W *9:00 to 10:20
 02/21/12
 Assignment#1, 
 Teacher: Heather D. Pfeiffer ---- TA:Maria G. Jimenez
 Selection Sort and find the k-ht largest element)*/

import java.util.Scanner;
import java.util.Random;

public class SelectionSort
{
    public static void main (String [] args)
        
    {
        //prompt the user to enter the size of the array
        Scanner console = new Scanner(System.in);
        long start,end;
        
        
        //prompt the user to enter the size of her array
        System.out.println("Type the size of your array: ");
        int arraysize=console.nextInt();
        
        //set a maximun size of the array
        final int max=arraysize;
        //random numbers which maximum array size is 1000000
        int []list=randomWalkArray(1000000);
        

        //print and compute selection sort the sorted list
        start=System.nanoTime();
        selectionSort(list, max);
        end=System.nanoTime();
        
        //ask for the user the k-th larges element in the current array
        System.out.println("Type the k-th largest element of your array: ");
        int elem=console.nextInt();
        
        //substranting the number to whet which number is the larges in a certain index
        int kht=arraysize-elem;
        System.out.println("The k-th largest element "+elem+" in your array is "+list[kht]);
        
        //printing how long it takes in nano seconds
        System.out.println("It takes: " + (end-start)+" nano seconds");
        
    }
    
    //method which contains the algorithm to set the middle number
    //of the array list
    private static int minLocation(int [] list, int first, int last)
    {
        int minIndex=first;
        for(int location=first+1; location<=last;location++)
        {
            //identify the minimum number to be placed 
            //in the beginning of the array
            if(list[location]<list[minIndex])
                minIndex=location;
        }
        return minIndex;
    }
    
    //method which contains the algorithm to swap the first an a 
    //second element in the array
    private static void swap(int [] list, int first, int second)
    {
        //setting the values in an empty variable
        //to save it and do not lose track of it
        int temp;
        temp=list[first];
        list[first]=list[second];
        list[second]=temp;
    }
    
    //method which contains the algorithm Selection Sort
    public static void selectionSort(int [] list, int length)
    {
        Scanner console=new Scanner(System.in);
        
        //travers the array
        for(int index=0; index<length;index++)
        {
            //find the location, smallestIndex, of the smallest
            //element in list[index]
            int minIndex=minLocation(list, index, length-1);
            
            //swap the smallest element with list[index]
            swap(list, index, minIndex);
            
            //print the sorted list             
            System.out.println(list[index]);
            
        }
    }
    
    //method randomwalkarray that creats random numbers
    //"Provided by Olac Fuentes UTEP Web Site"
    public static int [] randomWalkArray(int n)
    {
        Random generator = new Random ();
        int [] randArray=new int[n];
        randArray[0]=0;
        
        for(int i=1;i<n;i++)
            randArray[i]=randArray[i-1] + generator.nextInt(101)-10;
        return randArray;
    }
    
    
}


