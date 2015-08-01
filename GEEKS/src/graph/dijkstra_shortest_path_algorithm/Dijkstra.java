package graph.dijkstra_shortest_path_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Dijkstra {
	int N;//edge
	int W;//weight
	public Dijkstra(int N1,int W1) {
		N=N1;
		W=W1;
	}
	public static void main(String[] args) throws IOException {
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 String s;
         StringTokenizer st;
		 s=br.readLine().trim();    	        
   	  	 st=new StringTokenizer(s," ");
         int N=Integer.parseInt(st.nextToken());
         int M=Integer.parseInt(st.nextToken());
         @SuppressWarnings("unchecked")
		LinkedList<Dijkstra> adj[]=new LinkedList[N];       
         while(M-->0)
         {
       	  	  s=br.readLine().trim();    	    	         
       		  st=new StringTokenizer(s);
	              int v1=Integer.parseInt(st.nextToken());
	              int v2=Integer.parseInt(st.nextToken());
	              int w=Integer.parseInt(st.nextToken());
	              	if(adj[v1]==null)
	           		{
	           			adj[v1]=new LinkedList<Dijkstra>();
	           		}
	           		adj[v1].add(new Dijkstra(v2, w));
	           		if(adj[v2]==null)
	           		{
	           			adj[v2]=new LinkedList<Dijkstra>();
	           		}
	           		adj[v2].add(new Dijkstra(v1, w));
	              
	          
         }
         djkstra(adj,0,N);
	}

	private static void djkstra(LinkedList<Dijkstra>[] adj, int source, int n) {
		
		int dist[]=new int[n];
		boolean visited[]=new boolean[n];
		for(int i=0;i<n;i++)
		{
			dist[i]=Integer.MAX_VALUE;
			
		}
		dist[source]=0;
		for(int i=0;i<n;i++)
		{
			int u=min_dist(dist,visited);
			//System.out.println("min="+u);
			visited[u]=true;
			Iterator<Dijkstra> itr=adj[u].iterator();
			while(itr.hasNext())
			{
				Dijkstra ob=itr.next();
				
				int v=ob.N;
				int weight=ob.W;
				//System.out.println("edge="+v+"weight="+weight);
				if(!visited[v]&&dist[u]+weight<dist[v])
				{
					dist[v]=dist[u]+weight;
				}
				
			}
			
		}
		print_Solution(dist);
	}

	private static void print_Solution(int[] dist) {
		System.out.println("Vertex   Distance from Source");
		   for (int i = 0; i < dist.length; i++)
			   System.out.println(i+"\t\t"+ dist[i]);
		
	}
	private static int min_dist(int[] dist, boolean[] visited) {
		int min=Integer.MAX_VALUE,min_index=0;
		for(int i=0;i<dist.length;i++)
		{
			if(!visited[i]&&dist[i]<min)
			{
				min=dist[i];
				min_index=i;
			}
		}
		return min_index;
	}

}
