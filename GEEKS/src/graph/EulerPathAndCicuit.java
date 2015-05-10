package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class EulerPathAndCicuit {
	static  LinkedList<Integer> adj[];
	static boolean visited[];
	static int v;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String s;
		StringTokenizer st;
		while(true)
		{
			 if((s=br.readLine())!=null)
			 {
				 	st=new StringTokenizer(s); 
				 	v=Integer.parseInt(st.nextToken());
					visited=new boolean[v];
					adj=new LinkedList[v];
					int e=Integer.parseInt(st.nextToken());
					while(e>0)
					{
							 if((s=br.readLine())!=null)
							 {
								 st=new StringTokenizer(s); 							 
								 int v1=Integer.parseInt(st.nextToken());
								 int v2=Integer.parseInt(st.nextToken());
								 if(adj[v1]==null)
								 {
									 adj[v1]=new LinkedList<>();
								 }
								 adj[v1].add(v2);
							 	if(adj[v2]==null)
							 	{
							 		adj[v2]=new LinkedList<>();
							 	}
							 	adj[v2].add(v1);
							 	e--;
							 }
							 
					}
					int t=checkisEulerian();
					if(t==0)
					{
						System.out.println("The graph does not have an Eulerian Path");
					}
					else if(t==1)
					{
						System.out.println("The graph   has an Eulerian Path");
					}
					else
						System.out.println("The graph has a Eulerian cycle");
						
				}
			
			 else
				 break;
				}
	}
		private static int checkisEulerian() 
		{
		// TODO Auto-generated method stub
			int odd=0;
			if(!isconnected())
			{
				System.out.println("graph not connected");
				return 0;
			}
			
			for(int i=0;i<adj.length;i++)
			{
				if(adj[i].size()>0 && (adj[i].size()&1)==1)
				{
					odd++;
				}
			}
			if(odd>2)
			{
				
				return 0;
			}
			int c=odd==2?1:2;
			return c;
		
		}
		private static boolean isconnected() {
			// TODO Auto-generated method stub
			int i;
			for(i=0;i<adj.length;i++)
			{
				 if(adj[i].size()!=0)
					break;
				
			}
			if(i==v)
				return true;
			dfs(i);
			for(i=0;i<visited.length;i++)
			{
				if(!visited[i]&&adj[i].size()>0)
					return false;
			}
			return true;
			}
		private static void dfs(int start) {
			// TODO Auto-generated method stub
			visited[start]=true;
			Iterator<Integer> itr=adj[start].iterator();
			while(itr.hasNext())
			{
				int c=itr.next();
				if(!visited[c])
				dfs(c);
			}
			
		}	             
			
		

		
	}



