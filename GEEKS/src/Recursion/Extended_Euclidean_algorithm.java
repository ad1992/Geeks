package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Extended_Euclidean_algorithm {
private static int x,y;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringTokenizer st;
		s=br.readLine().trim();
		st=new StringTokenizer(s);
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		x=y=0;
		egcd(A,B);
		 if(x<0) x += B;
		System.out.println(x+" "+y);
		 
	}

	private static void egcd(int a,int b) {
		// TODO Auto-generated method stub
		if(a%b==0)
		{
			x=0;
			y=1;
			return;
		}
		egcd(b,a%b);
		int temp=x;
		x=y;
		y=temp-y*(a/b);
		
	}

}
