/**
 * Class that will contain the main method and a example of BackTracking, in this case SubsetSum.
 * @author Alan
 * Professor: Olac Fuentes
 * TA: Jaime Nava
 *
 */

import java.util.Scanner;

public class BackTracking
{
	/**
	 * Main method that will call the SubSetSum method in order to implement it. Creates an array and asks for the goal
	 * to pass them as parameters.
	 */
	public static void main(String[] args)
	{
		//Ask the user for input
		Scanner console = new Scanner(System.in);
		System.out.println("Please, enter the size of the array");
		int length = console.nextInt();
		
		System.out.println("");
		
		System.out.println("What is the goal?");
		int goal = console.nextInt();
		
		int[] array = new int[length];
		System.out.println("");
		
		System.out.println("Please, fill the array with numbers of the array. Enter " + length + " numbers");

		//Fill array with numbers
		for(int i = 0; i < array.length; i++)
		{
			System.out.println("Number " + i);
			array[i] = console.nextInt();
			System.out.println(" ");
		}
		
		boolean sss = SubSetSum(array, 0, goal);
		
		System.out.println("The result is: " + sss);
	}
	
	/**
	 * Method that will implement the SubSetSum algorith and return either true or false if the goal is reached
	 * @param mySet - Array passed as parameters
	 * @param n - Will serve as a counter
	 * @param goal - Goal to be reached
	 * @return - Either true or false if the goal is reached.
	 */
	public static boolean SubSetSum(int[] mySet, int n, int goal)
	{
		if(goal == 0)
			return true;
		if((goal < 0) || (n >= mySet.length))
			return false;
		if(SubSetSum(mySet, n+1, goal-mySet[n]))
		{
			System.out.print(mySet[n] + " ");
			return true; //Element n is included
		}
		
		if(SubSetSum(mySet, n+1, goal))
			return true; //element n is not included
		return false;
	}

}
