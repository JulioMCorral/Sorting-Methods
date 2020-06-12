/*This class is represents the backtracking which is represented
 * represented by a Sub Set Sum algorithm.
 * 
 * Methods are as follows:
 * 
 * SubSetSum: Public method which computes the opperations of 
 *            subsetsum
 * 
 * 
 * @author    Julio Corral
 * @date      12/01/10
 * @professor Dr. Fuentes
 * @T.A.      Jaime Nava
 */

import java.util.Scanner;

public class Backtracking
{
    public static void main(String[] args)
    {
        //create a input condition
        Scanner console=new Scanner(System.in);
        //type the size of an array 
        System.out.print("Enter the size of the array: ");
        int length=console.nextInt();
        //Type the goal in the backtracking
        System.out.print("Enter the goal: ");
        int goal=console.nextInt();
        //array size
        int []C=new int[length];
        //prompt the user enter the values in the array
        System.out.println("enter numbers to fill the array: ");
        for(int i=0;i<length;i++)
        {
            //each value in the data will be integer inside the array
            C[i]=console.nextInt();
            
        }
        //calling the method subsetsum
        boolean sss=subsetsum(C,0,goal);
        
        System.out.print(sss );
    }
    
    
    
    
    
    /*Method subsetsum that makes the operation which is related
     * to backtracking
     * param  --> int n: represents the corrent node
     * param  --> int [] set: passing the array with values
     * param  --> int goal: the target to find in the backtracking
     * @return  --> boolean: which represent if the array correspond
     *                       to a subsetsum
     * @return  --> int: the values of a subsetsum if the result returns "true"
     *                
     */
    public static boolean subsetsum(int[] set, int n, int goal)
    {
        if(goal==0)
            return true;
        if((goal<0)||(n>=set.length))
            return false;
        if(subsetsum(set, n+1, goal-set[n]))
        {
            System.out.println(set[n]);
            return true;
        }
        
        if(subsetsum(set,n+1,goal))
            return true;
        return false;
    }
    
}