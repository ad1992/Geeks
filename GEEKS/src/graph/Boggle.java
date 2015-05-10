package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Boggle {	
static boolean[][] state;
	 static String dict[];
	 char bog[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String s;
		StringTokenizer st;
		s=br.readLine();
		st=new StringTokenizer(s);
		int l=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		 String dict[];
		 char bog[][];
		 dict=new String[l];
		s=br.readLine();
		st=new StringTokenizer(s);
		for(int i=0;i<l;i++)
		{
			dict[i]=st.nextToken();
		}
		 bog=new char[n][m];
		s=br.readLine();int k=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				bog[i][j]=s.charAt(k++);
			}
			
		}
		
		state=new boolean[n][m];
		String str="";		
			for(int i=0;i<n;i++)
			{
				
				for(int j=0;j<m;j++)
				{				
					
					if(!state[i][j]){				
					DFS_VISIT(dict,i,j,n,m,bog,str);
					}
				}
			}
		
		

	}
	
	private static void DFS_VISIT(String[] dict2,int i,int j, int n,int m, char[][] bog,
		 String str) {
		// TODO Auto-generated method stub
		state[i][j]=true;
		str+=bog[i][j];
		System.out.println("i "+i+"j "+j+" "+str);
		if(check(str,dict2))
		{
			System.out.println(str);
		}
		for(int i1=i-1;i1<=i+1&&i1<n;i1++)
		{
			
			for(int j1=j-1;j1<=j+1&&j1<m;j1++)
			{
				if(i1>=0&&j1>=0&&!state[i1][j1]){
					
					DFS_VISIT(dict2,i1,j1,n,m,bog,str);
				
				}
			}
		}
		state[i][j]=false;
		str=str.substring(0,str.length()-1);
		System.out.println("new "+str);
	
		
	}

	private static boolean check(String str, String[] dict2) {
		// TODO Auto-generated method stub
		//System.out.println(dict2.length);
		for(int i=0;i<dict2.length;i++)
		{
			//System.out.println(dict2[i]+" "+str);
			
			if(dict2[i].equals(str))
				return true;
	    }
	
		return false;
	}
		
	
	

}
