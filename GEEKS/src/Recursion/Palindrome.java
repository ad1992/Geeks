package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

	public Palindrome() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int c=check(s,"",s.length());
		if(c==1)
			System.out.println(s+" is palindrome");
		else
			System.out.println(s+" is not palindrome");
		
	}

	private static int check(String s,String reverse,int l) {
		if(l==0)
		{
			if(reverse.equals(s))
				return 1;
			return 0;
		}
		
		reverse=reverse+s.charAt(l-1);
		return check(s,reverse,l-1);
		
	}
}