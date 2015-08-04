package Dynamic.edit_distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class Dynamic_Sol {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String s1=br.readLine().trim();
		String s2=br.readLine().trim();
		int ans=min_Edits(s1,s2);
		System.out.println(ans);

	}

	private static int min_Edits(String s1, String s2) {
		int m=s1.length();
		int n=s2.length();
		int table[][]=new int[m+1][n+1];
		for(int i=0;i<m;i++)
		{
			table[i][0]=i;
		}
		for(int i=0;i<n;i++)
		{
			table[0][i]=i;
		}
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				int replace=s1.charAt(i-1)==s2.charAt(j-1)?0:1;
				table[i][j]=Math.min(table[i-1][j]+1,Math.min(table[i][j-1]+1,table[i-1][j-1]+replace));
			}
		}
		return table[m][n];
	}

}
