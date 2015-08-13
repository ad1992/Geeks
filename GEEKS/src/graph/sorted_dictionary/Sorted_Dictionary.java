package graph.sorted_dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * @author Aakansha Doshi
 *
 */
public class Sorted_Dictionary {
private static boolean visited[];
private static Stack<Integer> st;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws NumberFormatException,IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim());
		String s=br.readLine().trim();	
		Set<Character> set=new HashSet<Character>();
		String words[] = null;
		for(int i=0;i<N;i++)
		{
			words=s.split("\\s");
			for(int j=0;j<words[i].length();j++)
			{
				set.add(words[i].charAt(j));
			}
			
		}
		st=new Stack<>();
		visited=new boolean[set.size()];
		LinkedList<Integer> adj[]=new LinkedList[26];
		for(int i=0;i<adj.length;i++)
			adj[i]=new LinkedList();
		for(int i=0;i<words.length-1;i++)
		{
			String w1=words[i];
			String w2=words[i+1];
			int j=0,k=0;			
			while(w1.charAt(j)==w2.charAt(k))
			{
				j++;
				k++;
				
			}
			int ch1=w1.charAt(j)-97;
			int ch2=w2.charAt(k)-97;		
			if(j<w1.length()&&k<w2.length()&&ch1!=ch2)
			{
				adj[ch1].add(ch2);
				
			}
		}
		for(int i=0;i<set.size();i++)
    	{
    		if(adj[i]!=null&&!visited[i])
    		{
    			topo_Sort(adj,i);
    		}
    	}
		
		print_order();
	
		
	}
	
	private static void print_order() {
		while(!st.isEmpty())
		{
			char ch=(char)(st.pop()+97);
			System.out.print(ch+" ");
		}
		
	}

	private static void topo_Sort(LinkedList<Integer>[] adj,int source) {
		visited[source]=true;
		for(int i=0;i<adj[source].size();i++)
		{
			if(!adj[i].isEmpty())
			{
				Iterator<Integer> itr=adj[source].iterator();
				
				while(itr.hasNext())
				{
					int num=itr.next();
					if(!visited[num])
						topo_Sort(adj,num);
				}
			}
		}
		st.push(source);
		
	}
	
}
