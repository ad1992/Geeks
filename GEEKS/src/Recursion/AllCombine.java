package Recursion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AllCombine {	
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l=Integer.parseInt(br.readLine());
		String s =br.readLine();
		char arr[]=s.toCharArray();			
		int k=Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		findAllCombine(arr,"",0,l,k);
}

	private static void findAllCombine(char[] arr, String prefix, int i, int l,int k) {		
		if(k==0)
		{
			System.out.println(prefix);			
			return;	
		}
		
			for(int j=i;j<l;j++)
			{	
				
				String newprefix=prefix+" "+arr[j];
				System.out.println("i"+i+"j"+j);
				findAllCombine(arr, newprefix, i+1, l, k-1);
				
				while(j<l-1 && arr[j]==arr[j+1]){
					j++;
					i++;
				}
				i++;
			}		
			
	}

}
