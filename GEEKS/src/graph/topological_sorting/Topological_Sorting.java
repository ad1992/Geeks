package graph.topological_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Topological_Sorting {
	private static boolean visited[];
	private static Stack<Integer> stack;
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
    	stack=new Stack<Integer>();
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
          	
        }
    	for(int i=0;i<N;i++)
    	{
    		if(adj[i]!=null&&!visited[i])
    		{
    			dfs(adj,i);
    		}
    	}
    	while(!stack.isEmpty())
    	{
    		System.out.print(stack.pop()+" ");
    	}

	}
	private static void dfs(LinkedList<Integer>[] adj, int start) {
		visited[start]=true;
		if(adj[start]!=null)
		{
			Iterator<Integer> itr=adj[start].iterator();
			while(itr.hasNext())
			{
				int ele=itr.next();
				if(!visited[ele])
				{
					dfs(adj,ele);
				}
			}
		}
		stack.add(start);
		
	}

}
