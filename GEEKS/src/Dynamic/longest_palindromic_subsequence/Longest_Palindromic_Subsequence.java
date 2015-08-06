package Dynamic.longest_palindromic_subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class Longest_Palindromic_Subsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine().trim();
		LPS(s);

	}

	private static void LPS(String s) {
		int lps[][]=new int[s.length()][s.length()];
		int n=s.length();
		for(int i=0;i<n;i++)
		{
			lps[i][i]=1;
		}
		for(int len=2;len<=n;len++)
		{
			for(int i=0,j=len-1;j<n;i++,j++)
			{
				
				if(s.charAt(i)==s.charAt(j))
				{
					lps[i][j]=lps[i+1][j-1]+2;
					
					
				}
				else
				{
				
					lps[i][j]=Math.max(lps[i][j-1], lps[i+1][j]);
				}
				
			}
		}
		/*for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(lps[i][j]+" ");
			System.out.println();
		}*/
		int i=0,j=n-1;
		char arr[]=new char[lps[0][n-1]];
		int start=0,end=arr.length-1;
		while(lps[i][j]>0)
		{
			
			if(s.charAt(i)==s.charAt(j))
			{
				arr[start]=arr[end]=s.charAt(i);
				
				i++;
				j--;
				start++;
				end--;
				
			}
			else
			{
				if(lps[i+1][j]>lps[i][j-1])
					i++;
				else
					j--;
			}
		}
		String ans=new String(arr);
		System.out.println("longest palindrome subsequence: "+ans);
		System.out.println("The maximum length of longest palindromic subsequence is "+lps[0][n-1]);
	}

}
