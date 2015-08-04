package DataStructures.stack.valid_parenthesis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author Aakansha Doshi
 *
 */
public class Valid_Parenthesis {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String s=br.readLine().trim();
		if(is_Valid(s))
		{
			System.out.println("Balanced");
		}
		else
		{
			System.out.println("Not Balanced");
		}
		br.close();

	}

	private static boolean is_Valid(String s) {
		Stack<Character> st=new Stack<>();
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch=='('|ch=='{'|ch=='[')
			{
				st.push(ch);
			}
			else if(ch==')'|ch=='}'||ch==']')
			{
				if(st.isEmpty())
					return false;
				char c=st.pop();
				if(!isMatchingPair(ch,c))
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		if(st.isEmpty())
			return true;
		return false;
	}

	private static boolean isMatchingPair(char ch, char c) {
		String s=""+c+ch;
		String pat="^(\\{\\}|\\(\\)|\\[\\])$";
		return Pattern.matches(pat,s);
		
	}

}
