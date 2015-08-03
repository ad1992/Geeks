package graph.prims_minimum_spanning_tree;

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
public class Prims_Minimum_Spanning_Tree {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
        StringTokenizer st;
		s=br.readLine().trim();    	        
  	  	st=new StringTokenizer(s," ");
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        @SuppressWarnings("unchecked")
		LinkedList<Node> adj[]=new LinkedList[N];       
        while(M-->0)
        {
        		  s=br.readLine().trim();    	    	         
        		  st=new StringTokenizer(s);
	              int v1=Integer.parseInt(st.nextToken());
	              int v2=Integer.parseInt(st.nextToken());
	              int w=Integer.parseInt(st.nextToken());
	              if(adj[v1]==null)
	           	  {
	           		adj[v1]=new LinkedList<Node>();
	           	  }
	           	  adj[v1].add(new Node(v2,w));
	           	  if(adj[v2]==null)
	           	  {
	           	 	adj[v2]=new LinkedList<Node>();
	           	  }
	           	  adj[v2].add(new Node(v1, w));	              
	          
        }
        primMST(adj,N);

	}
	private static void primMST(LinkedList<Node>[] adj, int N) {
		int parent[]=new int[N];
		int key[]=new int[N];
		boolean visited[]=new boolean[N];
		for(int i=0;i<N;i++)
		{
			key[i]=Integer.MAX_VALUE;
		}
		parent[0]=-1;
		key[0]=0;
		for(int i=0;i<N;i++)
		{
			int u=min_Key(key,visited);
			visited[u]=true;
			if(adj[u]!=null)
			{
				Iterator<Node> itr=adj[u].iterator();
				while(itr.hasNext())
				{
					Node ob=itr.next();
					int v=ob.N;
					int w=ob.W;
					if(!visited[v]&&key[v]>w)
					{
						key[v]=w;
						parent[v]=u;
					}
				}
			}
		}
		
		printMST(parent,key);
		
	}
	private static void printMST(int[] parent, int[] key) {
		System.out.println("Following are the edges in the constructed Prim MST");
		System.out.println("Edge1\t\tEdge2\t\tWeight");
		int s=0;
		for(int i=1;i<parent.length;i++)
		{
			
			int weight=key[i];			
			s+=weight;
			System.out.println(parent[i]+"\t\t"+i+"\t\t"+weight);
		}
		System.out.println("The weight of MST is "+s);
	}
	private static int min_Key(int[] key, boolean[] visited) {
		int min_index=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<key.length;i++)
		{
			if(!visited[i]&&key[i]<min)
			{
				min=key[i];
				min_index=i;
				
			}
		}
		return min_index;
	}
	private static class Node
	{
		int N;
		int W;
		public Node(int N1,int W1) {
			N=N1;
			W=W1;
		}
	}
}
