package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PrimsAlgorithm {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		@SuppressWarnings("unchecked")
		LinkedList<G> adj[]=new LinkedList[n];int copy=m;long ans=0l;
		while(m>0)
		{
			if((s=br.readLine())!=null)
			{
				st=new StringTokenizer(s);
				int ver1=Integer.parseInt(st.nextToken())-1;
				int ver2=Integer.parseInt(st.nextToken())-1;
				int w=Integer.parseInt(st.nextToken());
				if(adj[ver1]==null)
        		{
        			adj[ver1]=new LinkedList<G>();
        		}  
				if(adj[ver2]==null)
        		{
        			adj[ver2]=new LinkedList<G>();
        		}  
        		adj[ver1].add(new G(ver2,w));        		
        		adj[ver2].add(new G(ver1,w));
        		m--;
			}
		}
		int k=0;
		/*while(k<n){
		Iterator<G> itr=adj[k].iterator();
		while(itr.hasNext())
		{
			G next=itr.next();
			
			System.out.print("next= "+next.nextnode+" weight "+next.weight);
		}
		System.out.println();
		k++;
		}*/
		int key[]=new int[n];
		boolean isTree[]=new boolean[n];
		int parent[]=new int[n];
		for(int i=0;i<n;i++)
		{
			key[i]=Integer.MAX_VALUE;
		}
		key[0]=0;int i=0;
		while(!isTree[i])
		{
			isTree[i]=true;
			LinkedList<G> p=adj[i];int j=0;
			
			while(adj[i]!=null&&j<adj[i].size())
			{
				int next=p.get(j).nextnode;
				int w=p.get(j).weight;
				
				if(w<key[next]&&!isTree[next])
				{
					key[next]=w;
					parent[next]=i;
					
					
				}
				j++;
			}
			
			j=0;int min=Integer.MAX_VALUE;;
			while(j<n)
			{
				if(!isTree[j]&&key[j]<min){
					min=key[j];
					i=j;
				}
				j++;
					
			}
			if(min<Integer.MAX_VALUE)
			ans+=min;
		}
		/*for( i=1;i<n;i++)
		{
			int j=0;int w=0;
			while(adj[parent[i]].size()>0)
			{
				if(adj[parent[i]].get(j).nextnode==i)
				{
					w=adj[parent[i]].get(j).weight;
					break;
				}
				j++;
			}
			System.out.println(parent[i]+" "+i+" "+w);
		}*/
		System.out.println(ans);

	}
	}

class G
{
	int nextnode,weight;
	
	G(int n1,int w1)
	{
		nextnode=n1;
		weight=w1;
		
		
	}
}