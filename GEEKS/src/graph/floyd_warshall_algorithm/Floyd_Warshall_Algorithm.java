package graph.floyd_warshall_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Floyd_Warshall_Algorithm {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
        StringTokenizer st;
		s=br.readLine().trim();    	        
  	  	st=new StringTokenizer(s," ");
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int arr[][]=new int[N][N];
        for(int i=0;i<N;i++)
        {
        	
        	for(int j=0;j<N;j++)
        	{
        		arr[i][j]=Integer.MAX_VALUE;
        		
        	}
        	arr[i][i]=0;
        }
        while(M-->0)
        {
        		  s=br.readLine().trim();    	    	         
        		  st=new StringTokenizer(s);
	              int v1=Integer.parseInt(st.nextToken());
	              int v2=Integer.parseInt(st.nextToken());
	              int w=Integer.parseInt(st.nextToken());
	              arr[v1][v2]=w;
	              
        }
        floydWarshall(arr,N);
	}

	private static void floydWarshall(int[][] arr, int N) {
		
		int dist[][]=new int[N][N];
		System.arraycopy(arr, 0, dist, 0, arr.length);
		for(int k=0;k<N;k++)
		{
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(dist[i][k]!=Integer.MAX_VALUE&&dist[k][j]!=Integer.MAX_VALUE&&dist[i][k]+dist[k][j]<dist[i][j])
					{
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
		}
		
		printSolution(dist,N);
	}

	private static void printSolution(int[][] dist, int N) {
		System.out.println("Shortest distance matrix\n"); 
		for(int i=0;i<N;i++)
	     {
	        	for(int j=0;j<N;j++)
	        	{
	        		if(dist[i][j]==Integer.MAX_VALUE)
	        			System.out.print("INF\t");
	        		else
	        			System.out.print(dist[i][j]+"\t");
	        	}
	        	System.out.println();
	     }
		
	}

}
