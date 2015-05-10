package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringsLength {

	public StringsLength() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l=Integer.parseInt(br.readLine());
		String s =br.readLine();
		char arr[]=s.toCharArray();			
		int k=Integer.parseInt(br.readLine());
		findAllLengthWord(arr,"",l,k);
	}

	private static void findAllLengthWord(char[] arr, String prefix, int l,
			int k) {
		// TODO Auto-generated method stub
		if(k==0)
		{
			System.out.println(prefix);
			return;
		}
		
			for(int i=0;i<l;i++)
			{
				String  newprefix=prefix+arr[i];
				findAllLengthWord(arr,newprefix, l, k-1);
				
			}
		
		
		
	}

}
