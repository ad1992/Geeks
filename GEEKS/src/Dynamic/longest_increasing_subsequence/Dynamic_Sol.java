package Dynamic.longest_increasing_subsequence ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 *
 */
public class Dynamic_Sol {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String s=br.readLine().trim();
		StringTokenizer st=new StringTokenizer(s,", ");
		int arr[]=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int ans=increasingSequence(arr);
		System.out.println(ans);
	}
	public static int increasingSequence(int a[])
	{
		int lis[]=new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			lis[i]=1;
		}
		for(int i=1;i<a.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(a[i]>a[j]&&lis[i]<lis[j]+1)
				{
					lis[i]=lis[j]+1;
				}
			}
		
		}
		/*for(int i=1;i<a.length;i++)
		{
			System.out.println(lis[i]);
		}*/
		int max=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++)
		{
			if(max<lis[i])
				max=lis[i];
		}
		return max;
	}
}
