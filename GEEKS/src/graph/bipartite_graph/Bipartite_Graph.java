package graph.bipartite_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Bipartite_Graph {
	enum Colour{
		uncoloured,white,black;
	}
static Colour colour[];
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
    	colour=new Colour[N];
    	for(int i=0;i<N;i++)
    		colour[i]=Colour.uncoloured;
    	if(isBipartite(adj,0))
    	{
    		System.out.println("The graph is Bipartite");
    	}
    	else
    	{
    		System.out.println("The graph is not Bipartite");
    	}

	}
	private static boolean isBipartite(LinkedList<Integer>[] adj, int source) {
		Queue<Integer> queue=new LinkedList<>();
		colour[source]=Colour.black;
		System.out.println(source+" "+colour[source]);
		queue.add(source);
		while(!queue.isEmpty())
		{
			int start=queue.poll();
			Colour adjc=colour[start]==Colour.black?Colour.white:Colour.black;
			if(adj[start]!=null)
			{
				Iterator<Integer> itr=adj[start].iterator();
				while(itr.hasNext())
				{
					int ele=itr.next();
					if(colour[ele]==Colour.uncoloured)
					{
						colour[ele]=adjc;
						queue.add(ele);
						System.out.println(ele+" "+colour[ele]);
					}
					else if(colour[ele]==colour[start])
					{
						
						return false;
					}
				}
			}
		}
		return true;
		
	}

}
