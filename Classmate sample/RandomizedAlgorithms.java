import java.util.Random;

/**
 * Class that will make an example of Randomized Algorithms, in this case the Random QuickSort
 * @author Alan
 * @TA Jaime Nava
 * @Professor Olac Fuentes
 *
 */

public class RandomizedAlgorithms
{
	/**
	 * Main method that will create an array and then pass it to auxiliary methods that will perform the quicksort.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Random number = new Random();
		int[] array = {4,5,1,6,3,1,4,8,9,12,11};//unordered list
		int len= array.length;
		int first = number.nextInt(array.length);
		int last = len-1;
		int second = first+1;
		partition(array,first,last);
		swap(array,first,second);
		quickS(array,first,last);
		quickSort(array,len);
		print(array,len);
	}
	
	/**
	 * Method that will partition the given array.
	 * @param arrayIn - Array that will be partitioned
	 * @param first - First element of the array
	 * @param last - Last element of the array
	 * @return
	 */
	public static int partition(int[] arrayIn, int first, int last)
	{
		int pivot;
		int smallIndex;

		swap(arrayIn,first,(first+last)/2);

		pivot = arrayIn[first];
		smallIndex = first;

		for(int i= first+1; i <= last; i++ )
		{
			if(arrayIn[i]<pivot)
			{    
				smallIndex++;
				swap(arrayIn,smallIndex,i);
			}
		}

		swap(arrayIn,first,smallIndex);

		return smallIndex;
	}

	/**
	 * Method that will do the swap between the numbers.
	 * @param newArray - Array to be swapped.
	 * @param first - First number of the array.
	 * @param second - Second number of the array.
	 */
	public static void swap(int[] newArray, int first, int second)
	{
		int temp;

		temp = newArray[first];
		newArray[first]= newArray[second];
		newArray[second]= temp;

	}

	/**
	 * Method that will perform the quicksort
	 * @param arr - Array to be sorted
	 * @param first - First element of the array.
	 * @param last - Last element of the array.
	 */
	public static void quickS(int[] arr, int first, int last)
	{
		if(first<last)
		{
			int pLocation = partition(arr,first,last);
			quickS(arr,first,pLocation-1);
			quickS(arr,pLocation+1,last);
		}
	}

	/**
	 * Method that will call quickS in order to perform QuickSort
	 * @param arry - Array to be passed.
	 * @param length - Lenght of the array.
	 */
	public static void quickSort(int[] arry, int length)
	{
		quickS(arry,0,length-1);
	}

	/**
	 * Method that will print the final sorted array.
	 * @param list - Array to be printed
	 * @param lng - Lenght of the array
	 */
	public static void print(int[] list, int lng)
	{
		for(int y=0; y < lng;y++)
			System.out.println(list[y] +" ");
		System.out.println();
	}

}
