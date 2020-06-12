/*This class is represents a dynamic programming
 * using the algorithm of fibonacci number using loops
 * without recursion
 * 
 * Methods are as follows:
 * 
 *fibonacci: computes and returns the fibonacci number
 * 
 * @author    Julio Corral
 * @date      12/01/10
 * @professor Dr. Fuentes
 * @T.A.      Jaime Nava
 */


import java.util.*;

public class DynamicProgramming
{
    public static void main(String [] args)
    {
        Scanner console=new Scanner(System.in);
        
        System.out.print("Enter a positive random number: ");
        int number=console.nextInt();
        
        long start, end;
        start=System.nanoTime();
        int fibbNum=fibonacci(number);
        end=System.nanoTime();
        
        System.out.println("The fibonacci number of " +number
                               +" is " +fibbNum);
        System.out.println("time " + (end - start));
        
    }
    
     /*Method fibonacci to find the fibonacci number
     * 
     * param  --> int searchItem: represents the number to search
     * param  --> int [] list: passing the sorted array
     * param  --> int lenght: size of the current array
     * 
     * @return  --> int: return a positive integer if the number is
     *                   found, or a -1 if the number is not found
     */
    public static Integer fibonacci(int n)
    {
        int k=1;
        int result=0;
        int j;
        
        for(int i=0;i<n;i++)
        {
        
            j=k;
        
            k=result;
        
            result=j+result;
        }  
        
        return result;
        
    }   
}