package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EulerDirectedPathAndCircuit {

	static  Node adj[];
	static boolean visited[];
	static int v;
	static int in[];
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
					in=new int[v+1];
					adj=new Node[v+1];
					for(int i=1;i<=v;i++)
						adj[i]=new Node();
					int e=Integer.parseInt(st.nextToken());
					while(e>0)
					{
							 if((s=br.readLine())!=null)
							 {
								 st=new StringTokenizer(s); 
							 
							 int v1=Integer.parseInt(st.nextToken());
							 int v2=Integer.parseInt(st.nextToken());
							
							 adj[v1].add(v2);
							 e--;
							 }
					
					}
					for(int i=1;i<=v;i++){
					if(adj[i]!=null){	
					Node j=adj[i].start;
					System.out.print(i+" ");
					while(j!=null)
					{
						int d=j.data;
						System.out.print(d+"-->");
						j=j.link;
					}
					System.out.println();
					}
					} 
					if(!checkisEulerian())
					{
						System.out.println("The graph does not have an Eulerian Path");
					}
					
					else
						System.out.println("The graph has a Eulerian cycle");
						
				}
					
			 
			 else
				 break;
				 
	}	

}
	private static boolean checkisEulerian() {
		// TODO Auto-generated method stub
		if(!isconnected())
			
		return false;
		for(int i=1;i<in.length;i++)
		{
			if(adj[i].size()!=in[i])
			{
				return false;
			}
		}
		return true;
		
	}
	private static boolean isconnected() {
		// TODO Auto-generated method stub
		int i;
		for(i=1;i<=v;i++)
		{
			
			if(adj[i]!=null&&adj[i].size()!=0)
				break;
			
		}
		int start=i;
		//System.out.println(adj[start].size());
		if(i==v)
			return true;
		visited=new boolean[v+1];
		dfs(start,adj);
		for(i=1;i<visited.length;i++)
		{
			if(!visited[i]&&adj[i].size()>0)
				return false;
		}
		
			Node rev[]=reverse();
			System.out.println("reverse");
			for(i=1;i<=v;i++){
				System.out.print(i+" ");
				
				Node j=rev[i].start;
				
				while(j!=null)
				{
					int d=j.data;
					System.out.print(d+"-->");
					j=j.link;
					in[i]++;
				}
				System.out.println();
				}
				
		
		visited=new boolean[v+1];
	
		dfs(start,rev);
		for(i=1;i<visited.length;i++)
		{
			if(!visited[i]&&rev[i].size()>0)
				return false;
		}
		return true;
		
	}
	
	






	private static Node[] reverse() {
		// TODO Auto-generated method stub
		Node rev[]=new Node[adj.length];
		for(int i=1;i<=v;i++)
		{
			rev[i]=new Node();
		}
		for(int i=1;i<=v;i++)
		{
			
			Node j=adj[i].start;
			while(j!=null)
			{
				int data=j.data;
				rev[data].add(i);
				j=j.link;
			}
		}
		return rev;
		
		
	}
	private static void dfs(int i,Node[]adj) {
		// TODO Auto-generated method stub
		visited[i]=true;
		
		Node j=adj[i].start;
		while(j!=null)
		{
			int d=j.data;
			j=j.link;
			if(!visited[d])
			{
				dfs(d,adj);
			}
		}
		
	}
}
class Node
{
	int data;
	Node link=null;
	Node start=null;
	Node(int d)
	{
		
		link=null;
		data=d;
	}
	Node()
	{
		link=null;
		//start=null;
	}
	public int size() {
		// TODO Auto-generated method stub
		Node p=start;int c=0;
		while(p!=null)
		{
			c++;
			p=p.link;
		}
		return c;
		
	}
	public void add(int v2) {
		// TODO Auto-generated method stub
		Node n=new Node(v2);
		if(start==null){
			start=n;
			//System.out.println("first"+start.data);
		}
		else
		{
			Node p=start;
			while(p.link!=null)
			{
				p=p.link;
			}
			p.link=n;			
		}
		
	}
	
}