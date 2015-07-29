package Dynamic.count_all_paths_in_a_matrix ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recursive_Sol {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String s=br.readLine().trim();
		StringTokenizer st=new StringTokenizer(s);
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int ans=count_ways(m,n);
		System.out.println(ans);
	}

	private static int count_ways(int m, int n) {
		if(m==1||n==1)
			return 1;
		return count_ways(m-1,n)+count_ways(m, n-1);
	}

}
