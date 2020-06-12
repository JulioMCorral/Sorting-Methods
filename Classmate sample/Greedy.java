import java.io.*;

/**
 * Class that contains the methods that will create the Kruskal's algorithm that represents the Greedy algorithm
 * @author Alan
 * @TA: - Jaime Nava
 * @Professor - Olac Fuentes
 */

public class Greedy
{
	public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

	static int [][] G;
	static int [][] t;
	static boolean [][] in;
	static boolean [][] temp;

	static int n;
	static int mincost = 0;
	static int k, l, num_ed=0;

	/**
	 * Main method
	 * @throws IOException
	 */
	public static void main (String[] args) throws IOException
	{
		System.out.print("\nEnter the number of the vertices: ");
		n = Integer.parseInt(br.readLine());

		G = new int[n+1][n+1];
		in = new boolean[n+1][n+1];
		t = new int[n+1][3];

		System.out.print("\nIf edge between the following vertices enter its cost (not more than 7000) else 0:\n");
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
			{
				in[i][j] = in[j][i] = false;
				if((i!=j)&&(i<j))
				{
					System.out.print(i+" and "+j+": ");
					G[j][i] = G[i][j] = Integer.parseInt(br.readLine());
					if(G[i][j] == 0 )
						G[j][i] = G[i][j] = 7001;
				}
				if(i==j)
					G[i][j]=7001;
			}

		System.out.println("Solution : \n\n");
		Kruskals();
		System.out.println("Cost is: "+ mincost);
	}

	/**
	 * Method that will implement Kruskal's algorithm by calling auxiliary methods.
	 */
	static void Kruskals()
	{
		for (int i = 1; i<=n; i++)
		{
			getMinKL();
			if(k==l)
				break;
			System.out.print(l + "-" +k);
			if(formscycle(i-1))
			{
				System.out.println(" --> Forms cycle, hence rejected!");
				i--;
				continue;
			}
			else
				System.out.println();

			mincost = mincost + G[k][l];
			num_ed = (isPresent(i, k))?num_ed:num_ed+1;
			num_ed = (isPresent(i, l))?num_ed:num_ed+1;

			t[i][1] = l;
			t[i][2] = k;
			if(num_ed >= n)
			{
				if(allconnect(i))
					return;
			}

		}
		System.out.println("\nNo Solution Available!");
	}

	/**
	 * Method that will check if all the vertices are connected
	 * @param i - Vertex that will be checked
	 * @return - Either true or false, depending if the condition is reached.
	 */
	static boolean allconnect(int i)
	{
		for(int c=2;c<=n;c++)
		{
			temp = new boolean[n+1][n+1];
			for(int a=1;a<=n;a++)
				for(int b=1;b<=n;b++)
					temp[a][b] = temp[b][a] = false;

			if(can_reach(1, c, i) == false)
				return false;
		}
		return true;
	}

	/**
	 * Method that will verify if the selected path, added will then form a cycle.
	 * @param i - Element to be verified
	 * @return - Either true or false.
	 */
	static boolean formscycle(int i)
	{
		if(isPresent(i, k) && isPresent(i, l))
		{
			temp = new boolean[n+1][n+1];
			for(int a=1;a<=n;a++)
				for(int b=1;b<=n;b++)
					temp[a][b] = temp[b][a] = false;

			if(can_reach(k, l, i) )
				return true;
		}
		return false;
	}

	/**
	 * Will verify if there's a connection between vertices -if they can reach each other-.
	 * @param k - Row size
	 * @param l - Colum size
	 * @param i - Will serve as a wall to stop the loop
	 * @return - Either true or false, depending if there's a connection.
	 */
	static boolean can_reach(int k, int l, int i)
	{
		temp[k][l] = temp[l][k] = true;
		for(int o=1; o<=i; o++)
		{
			if(((k == t[o][1]) && (l == t[o][2])) || ((l == t[o][1]) && (k == t[o][2])))
				return true;
			if((k == t[o][1]) && !(temp[t[o][2]][l]) )
			{
				if(can_reach(t[o][2], l, i) == true)
					return true;
			}
			else if((k == t[o][2]) && !(temp[t[o][1]][l]))
			{
				if(can_reach(t[o][1], l, i) == true)
					return true;    
			}
		}
		return false;
	}

	/**
	 * Method that will check if there's a union between those two numbers.
	 * @param i - Will serve as a wall
	 * @param val - Verifies if the element is present
	 * @return - Returns if the element is present, thus there is a union.
	 */
	static boolean isPresent(int i, int val)
	{
		for(int o=1; o<=i; o++)
			if((val == t[o][1]) || ((val == t[o][2]) ))
				return true;
		return false;
	}

	/**
	 * Method that will get the minimum cost path
	 */
	static void getMinKL()
	{
		int k1 = 1, l1 = 1;
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
			{
				if((i!=j)&&(i<j))
				{
					if((G[i][j] < G[k1][l1]) && G[i][j] !=0 && in[j][i]==false)
					{
						k1 = i;
						l1 = j;
					}
				}
			}
		if(G[k1][l1] !=0 )
		{
			k =k1; l=l1;
			in[k][l] = in[l][k] = true;
		}
	}

}
