
package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author aakansha
 * Give a String s,print all its permutations.
 *
 */
public class Anagrams {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		int T=Integer.parseInt(br.readLine());
		String s;
		while(T>0)
		{
			if((s=br.readLine())!=null)
			{
				StringBuilder s1=new StringBuilder(s);
				printAnagrams(s1,0,s1.length()-1);
			}
			T--;
			
		}

	}

	private static void printAnagrams(StringBuilder s1,int i,int j) {
		// TODO Auto-generated method stub
		
		if(i==j)
		{
			System.out.println(s1);
		}
		for(int k=i;k<=j;k++)
		{
			swap(s1,i,k);
			printAnagrams(s1, i+1, j);
			swap(s1,i,k);
		}
	}

	private static void swap(StringBuilder s1, int i, int j) {
		// TODO Auto-generated method stub
		char temp=s1.charAt(i);
		s1.setCharAt(i, s1.charAt(j));
		s1.setCharAt(j, temp);
	}

}
