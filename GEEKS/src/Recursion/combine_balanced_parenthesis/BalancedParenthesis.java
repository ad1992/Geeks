package Recursion.combine_balanced_parenthesis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class BalancedParenthesis {
	private static char arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim()) ;
		arr=new char[100];
		print_Parenthesis(N,0,0,0);

	}

	private static void print_Parenthesis(int n, int open, int close, int pos) {
		
		
		if(close==n)
		{
			System.out.println(new String(arr));
			return;
		}
		if(open>close)
		{
			arr[pos]='}';
			print_Parenthesis(n, open, close+1, pos+1);
		}
		if(open<n)
		{
			arr[pos]='{';
			print_Parenthesis(n, open+1, close, pos+1);
		}
		
	}

}
