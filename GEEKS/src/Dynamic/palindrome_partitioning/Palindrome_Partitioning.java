package Dynamic.palindrome_partitioning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class Palindrome_Partitioning {
private static final int INF=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		s=br.readLine().trim();
		char str[]=s.toCharArray();
		int ans=min_cuts(str);
		System.out.println(ans);
	}

	private static int min_cuts(char arr[]) {
		int  N=arr.length;
		int cuts[][]=new int[N][N];
		
		for(int len=2;len<=N;len++)
		{
			for(int i=0,j=len-1;j<N;j++,i++)
			{
				cuts[i][j]=INF;
				if(len==2)
				{
					cuts[i][j]=(arr[i]==arr[j])?0:1;
				}
				else if(arr[i]==arr[j]&&cuts[i+1][j-1]==0)
				{
					cuts[i][j]=0;
				}
				else
				{
					for(int k=i;k<j;k++)
					{
						cuts[i][j]=Math.min(cuts[i][j],cuts[i][k]+cuts[k+1][j]+1);
					}
				}
			}
		}
		/*for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				
				System.out.print(cuts[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(cuts[0][N-1]);*/
		return cuts[0][N-1];
	}

}
