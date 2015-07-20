package DataStructures.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author Aakansha Doshi
 *
 */
public class Infix_To_Postfix {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine().trim();
		if(infixToPostfix(s)==-1)
			System.out.println("Invalid Expression");
		
	}

	private static int infixToPostfix(String s) {
		// TODO Auto-generated method stub
		Stack<Character> st=new Stack<>();
		char arr[]=s.toCharArray();
		StringBuilder res=new StringBuilder();
		for(int i=0;i<arr.length;i++)
		{
			char ch=arr[i];
			if(isOperand(ch))
			{
				res.append(ch);
			}
			else if(ch=='(')
			{
				st.push('(');
			}
			else if(ch==')')
			{
				
				while(!st.isEmpty()&&st.peek()!='(')
					res.append(st.pop());
				if(st.isEmpty())
					return -1;
				else
					st.pop();
				
				
			}
			else
			{
				while(!st.isEmpty()&&prec(ch)<=prec(st.peek()))
				{
					res.append(st.pop());
				}
				st.push(ch);
			}
		}
		while(!st.isEmpty())
		{
			char ch=st.pop();
			if(ch=='(')
				return -1;
			res.append(ch);
			
		}		
		System.out.println(res);
		return 1;
		
	}

	private static int prec(char ch) {
		// TODO Auto-generated method stub
		if(ch=='+'||ch=='-')
			return 1;
		if(ch=='*'||ch=='/')
			return 2;
		if(ch=='^')
			return 3;
		return -1;
	}

	private static boolean isOperand(char ch) {
		// TODO Auto-generated method stub
		return (ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z');
		
	}

}
