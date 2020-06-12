/**
 * Class that will contain the main method and a example of Divide and Conquer, in this case MergeSort.
 * @author Alan
 * Professor: Olac Fuentes
 * TA: Jaime Nava
 *
 */
public class DivideAndConquer
{
	/**
	 * Main method that will call the MergeSort method.	
	 */
	public static void main(String[ ] args)
	{
		int i;    // index of array

		//Create 3 arrays to be sorted
		int b[] = {1,3,4,5,2,80,90,38,32,52,32};
		int c[] = {6,2,7,5,23,32,78,99,56};
		int d[] = {67,66,65,78,90,3562,32909,1337,323,23221,321,231};

		// Print the array before sorting:
		System.out.println("Unsorted Arrays:\n");
		for (i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");
		System.out.println();
		
		for (i = 0; i < c.length; i++)
			System.out.print(c[i] + " ");
		System.out.println();
		
		for (i = 0; i < d.length; i++)
			System.out.print(d[i] + " ");
		System.out.println();


		// Sort the numbers, and print the result with two blanks after each number.
		mergesort(b, 0, b.length);
		mergesort(c, 0, c.length);
		mergesort(d, 0, d.length);
		
		System.out.println();
		System.out.println();

		System.out.println("Sorted Arrays: \n");
		for (i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");
		System.out.println();
		
		for (i = 0; i < c.length; i++)
			System.out.print(c[i] + " ");
		System.out.println();
		
		for (i = 0; i < d.length; i++)
			System.out.print(d[i] + " ");
		System.out.println();
	}

	/**
	 * MergeSort method that will divide and merge the given array. It will call auxiliary methods
	 * @param data - Array to be sorted
	 * @param first - First number
	 * @param n - Size of the half of the arrays
	 */
	public static void mergesort(int[ ] data, int first, int n)
	{
		int n1; // Size of the first half of the array
		int n2; // Size of the second half of the array

		if (n > 1)
		{
			// Compute sizes of the two halves
			n1 = n / 2;
			n2 = n - n1;

			mergesort(data, first, n1);      // Sort data[first] through data[first+n1-1]
			mergesort(data, first + n1, n2); // Sort data[first+n1] to the end

			// Merge the two sorted halves.
			merge(data, first, n1, n2);
		}
	} 

	/**
	 * Auxiliary method that will receive the array, sort and merge
	 * @param data - Array that will be passed from MergeSort method
	 * @param first - First element on the array.
	 * @param n1 - First element on first array
	 * @param n2 - First element on second array
	 */
	private static void merge(int[ ] data, int first, int n1, int n2){

		int[ ] temp = new int[n1+n2]; // Allocate the temporary array
		int copied  = 0; // Number of elements copied from data to temp
		int copied1 = 0; // Number copied from the first half of data
		int copied2 = 0; // Number copied from the second half of data
		int i;           // Array index to copy from temp back into data

		// Merge elements, copying from two halves of data to the temporary array.
		while ((copied1 < n1) && (copied2 < n2))
		{
			if (data[first + copied1] < data[first + n1 + copied2])
				temp[copied++] = data[first + (copied1++)];
			else
				temp[copied++] = data[first + n1 + (copied2++)];
		}

		// Copy any remaining entries in the left and right subarrays.
		while (copied1 < n1)
			temp[copied++] = data[first + (copied1++)];
		
		while (copied2 < n2)
			temp[copied++] = data[first + n1 + (copied2++)];

		// Copy from temp back to the data array.
		for (i = 0; i < n1+n2; i++)
			data[first + i] = temp[i];
	}


}
