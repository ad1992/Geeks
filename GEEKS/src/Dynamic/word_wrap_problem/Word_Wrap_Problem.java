package Dynamic.word_wrap_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class Word_Wrap_Problem {
private static final int INF=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String s=br.readLine().trim();
		int M=Integer.parseInt(br.readLine().trim());
		String arr[]=s.split("\\s");
		int len[]=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			len[i]=arr[i].length();
		}
		solve_Word_Wrap(len,M,arr);
		
	}

	private static void solve_Word_Wrap(int[] len, int M, String[] arr) {
		int N=len.length;
		int extras[][]=new int[N][N];
		int c[]=new int[N];
		int p[]=new int[N];
		int space=0;
		for(int i=0;i<N;i++)
		{
			int curlen=len[i];
			space=M-curlen;
			extras[i][i]=space<0?INF:space*space;
			
			for(int j=i+1;j<N;j++)
			{
				curlen+=len[j];
				if(extras[i][j-1]==INF||curlen>=M)
					extras[i][j]=INF;
				else
				{
					space=M-curlen-1;
					extras[i][j]=space*space;
				}
			}
			
		}		
		c[N-1]=extras[N-1][N-1];
		p[N-1]=N;
		for(int i=N-2;i>=0;i--)
		{
			c[i]=extras[i][N-1];
			p[i]=N;
			for(int j=N-1;j>i;j--)
			{
					
				if(extras[i][j-1]!=INF&&c[j]+extras[i][j-1]<c[i])
				{
					c[i]=c[j]+extras[i][j-1];
					p[i]=j;
				}
				
				
			}
		}
		
		print_Justfied(p,arr);
		
	}

	private static void print_Justfied(int[] p, String[] arr) {
		int limit;
		int index=0;
		while(index<p.length)
		{
			limit=p[index];
			for(int j=index;j<limit;j++)
			{
				System.out.print(arr[j]+" ");
			}
			System.out.println();
			index=limit;
			
		}
		
	}

}
