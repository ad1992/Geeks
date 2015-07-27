package Dynamic.knapsack01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Dynamic_Sol{

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		
		int n=Integer.parseInt(br.readLine());
		String value=br.readLine();
		String w=br.readLine();		
		StringTokenizer st;
		
		int  wt[]=new int[n];
		int val[]=new int[n];
	
		st=new StringTokenizer(value);
		for(int i=0;i<n;i++)
		{
			
			val[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(w);
		for(int i=0;i<n;i++)
		{
			
			wt[i]=Integer.parseInt(st.nextToken());
			
		}
		int weight=Integer.parseInt(br.readLine());
		int knapsack[][]=new int[n+1][weight+1];
		for (int i = 0; i <= n; i++)
		{
		       for (int w1 = 0; w1 <= weight; w1++)
		       {
		    	  
		    	   if (i==0 || w1==0)
		               knapsack[i][w1] = 0;
		           
		           else if (wt[i-1] <= w1)
		           {
		                 knapsack[i][w1] = Math.max(val[i-1] + knapsack[i-1][w1-wt[i-1]],  knapsack[i-1][w1]);                
		                
		           }
		           else
		           {
		                 knapsack[i][w1] = knapsack[i-1][w1];
		           }
		         
		           
		       }
		       
		   }
		 
			for (int i = 1; i <= n; i++)
			{
		       for (int w1 =1; w1 <= weight; w1++)
		       {
		    	   System.out.print(knapsack[i][w1]+" ");
		       }
		       System.out.println();
		   }
			System.out.println("The maximum values is "+knapsack[n][weight]);
	}

}
