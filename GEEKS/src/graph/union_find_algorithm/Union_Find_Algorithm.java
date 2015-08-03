package graph.union_find_algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Union_Find_Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
        StringTokenizer st;
		s=br.readLine().trim();    	        
  	  	st=new StringTokenizer(s," ");
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        Graph g=new Graph(N,M);       
		
        for(int i=0;i<M;i++)
        {
      	  	  s=br.readLine().trim();    	    	         
      		  st=new StringTokenizer(s);
	          int v1=Integer.parseInt(st.nextToken());
	          int v2=Integer.parseInt(st.nextToken());
	          g.edges[i]=new Edge(v1,v2);
	        
	         
	          
        }
        if(isCycle(g))
        {
        	System.out.println("The graph contains a cycle");
        }
        else
        {
        	System.out.println("The graph does not contains a cycle");
        }

	}
	private static boolean isCycle(Graph g) {
		int parent[]=new int[g.N];
		for(int i=0;i<parent.length;i++)
		{
			parent[i]=i;//initially the parent of every vertex is the vertex itself
		}
		for(int i=0;i<g.M;i++)
		{
			int x=find(parent,g.edges[i].v1);
			int y=find(parent,g.edges[i].v2);
			if(x==y)
				return true;
			parent[x]=y;
			
		}
		return false;
	}
	private static int find(int[] parent, int v2) {
		if(parent[v2]==v2)
			return v2;
		return find(parent,parent[v2]);
	}
	private static class Edge
	{
		int v1;
		int v2;
		public Edge(int a,int b) {
			v1=a;
			v2=b;
		
		}
	}
	private static class Graph
	{
		int N;
		int M;
		Edge edges[];
		Graph(int N1,int M1)
		{
			N=N1;
			M=M1;
			edges=new Edge[M];
		}
		
	}

}
