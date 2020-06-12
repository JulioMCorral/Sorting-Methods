/*This class is represents a divide and conquer
 *  method which is represented using BinarySearch
 *  in a sorted array
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


import java.io.*;
import java.util.Scanner;

public class DivideAndConquer
{
    public static void main(String [] args)
        
    {
        Scanner console=new Scanner(System.in);
        
        //enter the number that you want to search
        System.out.println("Enter a number that you want to search in the array: ");
        int searchItem=console.nextInt();
        
        //set the length of the array to lenght
        System.out.print("Enter the size of the array: ");
        int length=console.nextInt();
        
        int []list=new int[length];
        //prompt the user to enter ordered numbers
        System.out.println("enter ordered numbers to fill the array: ");
        for(int i=0;i<length;i++)
        {
            //travers the array and fill the index with values
            list[i]=console.nextInt();
            
        }
        
        //binSearch is the reasult of the method BinarySearch
        int binSearch=binarySearch(list, searchItem, length);
        //-1 means that the number to be searched does not stored on list
        if(binSearch==-1)
        {
            System.out.println("Sorry, the number "+searchItem+" was not found");
        }
        //the number is on the list
        else
        {
            System.out.println("The number "+searchItem+" was found");
        }
    }
    
    
    /*Method binarySearch which search in the array the number selected
     * 
     * param  --> int searchItem: represents the number to search
     * param  --> int [] list: passing the sorted array
     * param  --> int lenght: size of the current array
     * 
     * @return  --> int: return a positive integer if the number is
     *                   found, or a -1 if the number is not found
     */
    public static int binarySearch(int [] list, int searchItem, int length)
    {
        
        int first=0;
        
        int last=length-1;
        
        int mid=-1;
        boolean found=false;
        
        while(first<=last&& !found)
        {
         
            mid=(first+last)/2;
            if(list[mid]==searchItem)
                found=true;
            else if(list[mid]>searchItem)
                last=mid-1;
            else
                first=mid+1;
        }
        
        if(found)
            return mid;
        else
            return -1;
    }
}
