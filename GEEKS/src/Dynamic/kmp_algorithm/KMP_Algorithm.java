package Dynamic.kmp_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class KMP_Algorithm {
static int lps[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine().trim();
		String pat=br.readLine().trim();
		lps=new int[pat.length()];
		char p[]=pat.toCharArray();
		compute_lps(p);
		for(int i=0;i<p.length;i++)
			System.out.print(lps[i]+" ");
		System.out.println();
		char str[]=s.toCharArray();
			kmp_Search(str,p);

	}
	private static void kmp_Search(char[] str, char[] p) {
		int i=0,j=0;
		while(i<str.length)
		{
			
			if(str[i]==p[j])
			{
				i++;
				j++;
				
			}
			if(j==p.length)
			{
				System.out.println("Pattern found at at "+(i-j));
				j=lps[j-1];
			}
			else if(i<str.length&&p[j]!=str[i])
			{
				if(j>0)
					j=lps[j-1];
				else
					i++;
			}
				
			
		}
		
	}
	private static void compute_lps(char[] pat) {
		int i=1,start=0;
		while(i<pat.length)
		{
			
			if(pat[i]==pat[start])
			{
				start++;
				lps[i]=start;
				
				i++;
			}
			
			else if(start>0)
			{
				
				start=lps[start-1];
				
			}
			else
			{
				
				lps[i]=0;
				i++;
			}
			
		}
		
	}

	

}
