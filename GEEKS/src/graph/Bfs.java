package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g=new Graph(4);
			g.addEdge(0, 1);
		    g.addEdge(0, 2);
		    g.addEdge(1, 2);
		    g.addEdge(2, 0);
		    g.addEdge(2, 3);
		    g.addEdge(3, 3);
		    g.getBFS(0);
		 
	}

}
class Graph
{
	LinkedList<Integer>[] adj;
	int V;
	enum State
	{
		unvisited,visiting,processed;
	}
	
	@SuppressWarnings("unchecked")
	Graph(int n)
	{
		V=n;
		adj = new LinkedList[V];
		
	}
	void addEdge(int a,int b)
	{
		if(adj[a]==null)
		{
			adj[a]=new LinkedList<Integer>();
		}
		adj[a].add(b);
	}
	void getBFS(int start)
	{
		State st[]=new State[V];
		for(int i=0;i<V;i++)
		{
			st[i]=State.unvisited;
		}
		Queue<Integer> list=new LinkedList<>();
		st[start]=State.visiting;
		list.add(start);
		while(!list.isEmpty())
		{
			start=(int) list.poll();
			System.out.print(start+"-->");
			Iterator<Integer> itr=adj[start].iterator();
			while(itr.hasNext())
			{
				int ele=itr.next();
				if(st[ele]==State.unvisited)
				{
					st[ele]=State.visiting;
					list.add(ele);
				}
			}
			st[start]=State.processed;
			
		}
		
	}
}