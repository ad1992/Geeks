package graph.depth_first_traversal;

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
public class Depth_First_Traversal {
static boolean visited[];
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    String s;
        StringTokenizer st;
   
    	s=br.readLine().trim();
    	st=new StringTokenizer(s);
    	int N=Integer.parseInt(st.nextToken());
    	int M=Integer.parseInt(st.nextToken());
    	LinkedList<Integer> adj[]=new LinkedList[N];
    	visited=new boolean[N];
    	while(M-->0)
        {
    		s=br.readLine().trim();    	    	         
      		st=new StringTokenizer(s);
	        int v1=Integer.parseInt(st.nextToken());
	        int v2=Integer.parseInt(st.nextToken());
	        if(adj[v1]==null)
	        {	
	        	adj[v1]=new LinkedList<Integer>();
          	}
          	adj[v1].add(v2);
          	if(adj[v2]==null)
          	{
          		adj[v2]=new LinkedList<Integer>();
          	}
          	adj[v2].add(v1);		              
	          
        }
    	
    	for(int i=0;i<N;i++)
    	{
    		if(adj[i]!=null&&!visited[i])
    		{
    			dfs(adj,i);
    			System.out.println();
    		}
    	}
    	
	}
	private static void dfs(LinkedList<Integer>[] adj, int source) {
		visited[source]=true;
		System.out.print(source+"-->");
		if(adj[source]!=null)
		{
			Iterator<Integer> itr=adj[source].iterator();
			while(itr.hasNext())
			{
				int ele=itr.next();
				if(!visited[ele])
				{
					dfs(adj,ele);
				}
			}
			
		
		}
	}
}
		

