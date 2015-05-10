package Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Adding {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s1=br.readLine();
		String s2=br.readLine();
		System.out.println(add(s1,s2));
	}
	private static String add(String s1, String s2) {
		// TODO Auto-generated method stub
		int max=Math.max(s1.length(),s2.length());
		int start1=s1.length()-1;
		int start2=s2.length()-1;
		String ans="";
		int carry=0;
		
		while(max-->0)
		{
			if(start1>=0&&start2>=0)
			{
				int a=s1.charAt(start1)-48;
				int b=s2.charAt(start2)-48;
				int adder=a+b+carry;
				ans=(adder%10)+ans;
				carry=adder/10;
				start1--;
				start2--;
			}
			else if(start1>=0)
			{
				int a=s1.charAt(start1)-48;
				int adder=a+carry;
				ans=(adder%10)+ans;
				carry=adder/10;
				start1--;
			}
			else if(start2>=0)
			{
				int a=s2.charAt(start2)-48;
				int adder=a+carry;
				ans=(adder%10)+ans;
				carry=adder/10;
				start2--;
			}
			
		}
		if(carry>0)
			ans=carry+ans;
		
		return ans;
	}

}
