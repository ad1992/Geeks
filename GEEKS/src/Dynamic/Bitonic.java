package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bitonic {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int arr[]=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		int ans=bitonic_sequence(arr);
		System.out.println(ans);
	}
	 public static int bitonic_sequence(int[] input1)
	    {
		 int lis[]=new int[input1.length];
		 int dis[]=new int[input1.length];
			for(int i=0;i<input1.length;i++)
			{
				lis[i]=1;
				dis[i]=1;
			}
			for(int i=1;i<input1.length;i++)
			{
				for(int j=0;j<i;j++)
				{
					if(input1[i]>input1[j]&&lis[i]<lis[j]+1)
					{
						lis[i]=lis[j]+1;
					}
				}
			}
			for(int i=input1.length-2;i>=0;i--)
			{
				for(int j=input1.length-1;j>i;j--)
				{
					if(input1[i]>input1[j]&&dis[i]<dis[j]+1)
					{
						dis[i]=dis[j]+1;
					}
				}
			}
			int max=Integer.MIN_VALUE;
			for(int i=0;i<input1.length;i++)
			{
				//System.out.println("lis[i] :"+lis[i]+" dis[i]:"+dis[i]);
				if(max<(lis[i]+dis[i]-1))
				{
					max=lis[i]+dis[i]-1;
				}
			}
		return max;		
	    }
}
