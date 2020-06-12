/*Julio M. Corral
 jmcorral2@miners.utep.edu
 M-W *9:00 to 10:20
 02/21/12
 Assignment#1, 
 Teacher: Heather D. Pfeiffer ---- TA:Maria G. Jimenez
 Fibonacci Methods */

import java.util.Scanner;

public class FibonacciMethods
{
    public static void main(String [] args)
    {
        Scanner console=new Scanner(System.in);
        //creation of 2 variables to capture how long it takes to print the result in 
        //each method.
        long start,end;
        
        //prompt the user to enter a number
        System.out.println("Type the number that you want in Fibonacci");
        int number=console.nextInt(); 
        
        //inicialize the variables start and end to capture the time of this method
        //in nanoseconds.
        start=System.nanoTime();
        int recursive=recursionFib(number);
        end=System.nanoTime();
        
        System.out.println();
        //printing the results of Fibonacci 0(2^n)
        System.out.println("The fibonacci secuence with running time of 0(2^n): "+recursive
                               + " that ocurrs in " + (end-start) +" nanoseconds ("+ 
                           ((end-start)*0.000000001) + " seconds)");
        
        
        //capturing how longs it take in nanosecond using a running time of 0(n)
        start=System.nanoTime();
        int forLoop=iterationFib(number);
        end=System.nanoTime();
        
        System.out.println();
        //printing the results of Fibonacci 0(n)
        System.out.println("The fibonacci secuence with running time of 0(n):  "+forLoop
                               + " that ocurrs in " + (end-start) +" nanoseconds");
        
        //capturing how longs it take in nanosecond using a running time of 0(1)
        start=System.nanoTime();
        long closeForumla=formulaFib(number);
        end=System.nanoTime();
        
        System.out.println();
        //printing the results of Fibonacci 0(1), the close form solution
        System.out.println("The Fibonacci sequence with running time of 0(1):  "+closeForumla
                               + " that ocurrs in " + (end-start) +" nano seconds");
    }
    //the first method that make the operation recursively
    public static Integer recursionFib(int n)
    {
        //base case of the principle of fibonacci
        if(n<2)
        {
            return n;
        }
        else
        {
            //recursive call of the operation of fibonacci
            //recursion
            return recursionFib(n-1)+recursionFib(n-2);
        }
    }
    
    //second method that makes the operation using a for loop
    //also with a while loop works
    public static Integer iterationFib(int n)
    {
        int k=1;
        int result=0;
        int j;
        //inicialize a for loop with zero
        for(int i=0;i<n;i++)
        {
            //set j the value of 1
            j=k;
            //then k will be the vaule of result
            k=result;
            //finally result will add it self with the j value
            result=result+j;
        }  
        //final result
        return result;
        
    }
    
    //the third method which implies a close form solution 0(1)
    public static long formulaFib(int n)
    { 
        //translating the forumla of "wikipidia" to use the close form solution
        double x = Math.pow((1+Math.sqrt(5))/2, n);
        double y = Math.pow((1-Math.sqrt(5))/2, n);
        
        //the that requieres the close formula
        double finalFibb = 1 / Math.sqrt(5);
        
        
        //return the final result 
        return Math.round(finalFibb * (x - y));
    } 
}  