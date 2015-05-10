package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BridgeCross {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String arr[]=new String[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=br.readLine();
		}
		int ans=bridge(arr);
		System.out.println(ans);
	}
	public static int bridge(String[] input1)
    {
        //Write code here
		
		int len=input1.length;
		if(len==0)
			return 0;
		
		int arr[]=new int[len];
		for(int i=0;i<len;i++)
		{
			int index=input1[i].indexOf('#');
			int a=Integer.parseInt(input1[i].substring(0, index));
			if(a!=(i+1))
				return 0;
			if(index==-1)
				return 0;
			
			arr[i]=Integer.parseInt(input1[i].substring(index+1));
		}
		int lis=increasingSequence(arr);
		return lis;
		
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
		int max=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++)
		{
			if(max<lis[i])
				max=lis[i];
		}
		return max;
	}
}
