package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 * 
 *         Given a value N, if we want to make change for N cents, and we have
 *         infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how
 *         many ways can we make the change? The order of coins doesn’t matter.
 * 
 *         For example, for N = 4 and S = {1,2,3}, there are four solutions:
 *         {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and
 *         S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3},
 *         {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 * 
 */
public class Coin_Change {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		int N=Integer.parseInt(br.readLine().trim());
		int arr[]=new int[N];
		String s=br.readLine().trim();
		StringTokenizer st=new StringTokenizer(s);
		for(int i=1;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
			
		}
		int amount=Integer.parseInt(br.readLine());
		int ans=countcoins(arr,amount);
		System.out.println(ans);

	}

	private static int countcoins(int[] arr, int amount) {
		// TODO Auto-generated method stub
		int coins[]=new int[amount+1];
		coins[0]=1;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=arr[i];j<amount;j++)
			{
				coins[j]+=coins[j-arr[i]];
			}
			
		}
		return coins[amount];
		
	}

}
