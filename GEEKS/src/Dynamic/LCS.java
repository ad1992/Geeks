package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author aakansha
 * 
 *         LCS Problem Statement: Given two sequences, find the length of
 *         longest subsequence present in both of them. A subsequence is a
 *         sequence that appears in the same relative order, but not necessarily
 *         contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc
 *         are subsequences of “abcdefg”. So a string of length n has 2^n
 *         different possible subsequences.
 * 
 *         It is a classic computer science problem, the basis of diff (a file
 *         comparison program that outputs the differences between two files),
 *         and has applications in bioinformatics.
 * 
 *         Examples: LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of
 *         length 3. LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of
 *         length 4.
 * 
 */
public class LCS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		char arr1[]=s1.toCharArray();
		char arr2[]=s2.toCharArray();
		int lcs[][]=new int[s1.length()+1][s2.length()+1];
		for(int i=0;i<=s1.length();i++)
		{
			for(int j=0;j<=s2.length();j++)
			{
				if(i==0||j==0)
					lcs[i][j]=0;
				else if(arr1[i-1]==arr2[j-1])
				{
					lcs[i][j]=lcs[i-1][j-1]+1;
				}
				else
				{
					lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		System.out.println(lcs[s1.length()][s2.length()]);
		///Now printing the lcs
		int len=lcs[s1.length()][s2.length()]+1;
		String commonlcs="";
		int i=s1.length(),j=s2.length();
		while(i>0&&j>0)
		{
			if(arr1[i-1]==arr2[j-1])
			{
				commonlcs=arr1[i-1]+commonlcs;
				i--;
				j--;
			}
			else if(lcs[i-1][j]>lcs[i][j-1])
			{
				i--;
			}
			else
			{
				j--;
			}
		}
		System.out.println(commonlcs);

	}

}
