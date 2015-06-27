package Dynamic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class LongestpalindromeSubsequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		
		String s;
		s=br.readLine().trim();
		{
			//System.out.println(s.length());
			int len=getLongestPal(s);
			System.out.println("The length of longest palindromic subsequence is "+len);
		}
	}

	private static int getLongestPal(String s) {
		// TODO Auto-generated method stub
		char arr[]=s.toCharArray();
		int[][] lps=new int[s.length()][s.length()];
		for(int i=0;i<s.length()-1;i++)
		{
			if(arr[i]==arr[i+1])
			{
				lps[i][i+1]=2;
			}
			else
			{
				lps[i][i+1]=1;
			}
			lps[i][i]=1;
		}
		lps[s.length()-1][s.length()-1]=1;
		for(int len=3;len<=s.length();len++)
		{
			for(int i=0,j=i+len-1;j<s.length();i++,j++)
			{
				
				if(arr[i]==arr[j])
				{
					lps[i][j]=lps[i+1][j-1]+2;
				}
				else
				{
					lps[i][j]=Math.max(lps[i][j-1], lps[i+1][j]);
				}
			}
		}
		for(int i=0;i<s.length();i++)
		{
			for(int j=0;j<s.length();j++)
			{
				System.out.print(lps[i][j]+" ");
			}
			System.out.println();
		}
		return lps[0][s.length()-1];
	}

}
