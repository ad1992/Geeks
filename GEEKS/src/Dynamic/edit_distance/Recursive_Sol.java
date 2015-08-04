package Dynamic.edit_distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class Recursive_Sol {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String s1=br.readLine().trim();
		String s2=br.readLine().trim();
		int ans=min_Edits(s1,s2,s1.length(),s2.length());
		System.out.println(ans);


	}

	private static int min_Edits(String s1, String s2, int m, int n) {
		if(m==0&&n==0)
		{
			return 0;
		}
		if(m==0)
		{
			return n;
		}
		if(n==0)
		{
			return m;
		}
			
		return Math.min(min_Edits(s1, s2, m-1, n)+1, Math.min(min_Edits(s1, s2, m, n-1)+1,min_Edits(s1, s2, m-1, n-1)+(s1.charAt(m-1)==s2.charAt(n-1)?0:1)));
				
	}

}
