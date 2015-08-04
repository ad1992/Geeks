package Dynamic.boolean_parenthesization_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class Boolean_Parenthesization_Problem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String s=br.readLine().trim().replaceAll("\\s", "");
		char operand[]=s.toCharArray();
		s=br.readLine().trim().replaceAll("\\s", "");
		char operator[]=s.toCharArray();
		int ways=cal_ways(operand,operator);
		System.out.println(ways);
		

	}

	private static int cal_ways(char[] operand, char[] operator) {
		int len=operand.length;
	int T[][]=new int[len][len];
	int F[][]=new int[len][len];
	for(int i=0;i<len;i++)
	{
		if(operand[i]=='T')
			T[i][i]=1;
		else
			F[i][i]=1;
	}
	for(int gap=1;gap<len;gap++)
	{
		for(int i=0,j=gap;j<len;i++,j++)
		{
			for(int k=i;k<i+gap;k++)
			{
				int Total=(T[i][k]+F[i][k])*(T[k+1][j]+F[k+1][j]);
				if(operator[k]=='&')
				{
					int True=T[i][k]*T[k+1][j];
					T[i][j]+=True;
					F[i][j]+=Total-True;
				}
				else if(operator[k]=='|')
				{
					int False=F[i][k]*F[k+1][j];
					F[i][j]+=False;
					T[i][j]+=Total-False;
					
				}
				else if(operator[k]=='^')
				{
					int True=T[i][k]*F[k+1][j]+F[i][k]*T[k+1][j];
					T[i][j]+=True;
					F[i][j]+=Total-True;
				}
				
			}
		}
	}
	/*for(int i=0;i<len;i++){
		for(int j=0;j<len;j++){
			System.out.print(T[i][j]+" ");
		}
		System.out.println();
		
	}*/
	return T[0][len-1];
	}

}
