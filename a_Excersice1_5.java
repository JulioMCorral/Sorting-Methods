/*Julio M. Corral
jmcorral2@miners.utep.edu
T-Th *10:30 to 11:50
09/10/10
Assignment#1, 
Teacher: Olac Fuentes ---- TA:Jaime Nava
Exercice 1.5 of the textbook */

import java.util.Scanner;

public class a_Excersice1_5
{
    public static void main(String[] args)
    {
        //prompt the user to enter a number
        Scanner console=new Scanner(System.in);
        System.out.println("Type the number that you want in binary code: ");
        int decimal=console.nextInt();
        
        //calling the method to convert the number to binary 
        String binnumber=methodToBinary(decimal);
        
        //calling the method to count the number of ones
        int bincode=binary(decimal);    
        
        //print the final result
        System.out.println("The binary number of " + decimal + " is " + binnumber);
        System.out.println("This binary number has: "+bincode+ " ones");
    }
    
    
    public static String methodToBinary(int n)
    {
        //interpreting the binary codes as a string
        String result;
        
        //base case
        if(n==0)   
        {
            result="0";
        }
        //second base case
        else if (n==1)
        {
            result="1";
        }
        else
     
            //recursive statment to make the convertion  
        {
            result=methodToBinary(n/2);
     
            //compare the remainder 
            //and set the result to the correct values
            if(n%2==0)
            {
                result=result+"0";
            }
            else
            {
                result=result+"1";
            }
        }
        //final result
        return result;
    }
  
    //method which counts how many ones have the binary code
    public static Integer binary(int n)
    {
        //base case 0
        if(n==0)
            return 0;
        //return statment if the number is even
        else if(n%2==0)
            return binary(n/2);
        else
            //if not, the number is odd and starts a recursive statment
            //plus 1
            return 1+binary(n/2);
    }
}