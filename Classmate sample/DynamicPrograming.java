/**
 * Class that will contain the main method and a example of Dynamic Programming, in this case the Fibbonacci number.
 * @author Alan
 * Professor: Olac Fuentes
 * TA: Jaime Nava
 *
 */

public class DynamicPrograming
{
	 /**
	  * This is the main method, we will call the three different methods that will calculate the fibonacci of a given number.
	  */
	 public static void main(String[] args)
	 {
	  int x = 7; //Variable with the number to be computed
	  long start;
	  long end;
	  
	  //Loop (O^n)
	  start = System.currentTimeMillis();
	  System.out.println("The fibonacci result for your number " + x + " is: " + fibonacci2(x)); 
	  end = System.currentTimeMillis();
	  System.out.println("The running time was: " + (end-start) + " milliseconds\n");
	  
	 }
	 
	 /**
	  * This method will compute the fibonacci number using a loop, having a complexity of O(n)
	  * @param n - Number to be computed
	  * @return - The result of the fibonacci number of n.
	  */
	 public static int fibonacci2(int n)
	 {
	  int first = 1;
	  int second = 1;
	  int third;
	  int i = 0;
	  
	  while(i < n)
	  {
	   third = first + second;
	   first = second;
	   second = third;
	   i++;
	  }
	  
	  return first;
	 }
}
