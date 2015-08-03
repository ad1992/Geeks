package graph.union_find_algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Union_By_Rank_and_Path_Compression {

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
		Subset subsets[]=new Subset[g.N];
        for(int i=0;i<subsets.length;i++)
        {
        	subsets[i]=new Subset(i,0);
        }
        for(int i=0;i<g.M;i++)
		{
			int x=find(subsets,g.edges[i].v1);
			int y=find(subsets,g.edges[i].v2);
			if(x==y)
				return true;
			union(subsets,x,y);
			
		}
		return false;
		
	}

	private static void union(Subset[] subsets, int x, int y) {
		if(subsets[x].rank>subsets[y].rank)
		{
			subsets[y].parent=x;
		}
		else if(subsets[x].rank<subsets[y].rank)
		{
			subsets[x].parent=y;
		}
		else
		{
			subsets[x].parent=y;
			subsets[y].rank++;
		}
		
	}

	private static int find(Subset[] subsets, int v1) {
		if(subsets[v1].parent==v1)
			return subsets[v1].parent;
		return find(subsets,subsets[v1].parent);
		
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
	private static class Subset
	{
		int parent;
		int rank;
		Subset(int p1,int r1)
		{
			parent=p1;
			rank =r1;
		}
	}


}
