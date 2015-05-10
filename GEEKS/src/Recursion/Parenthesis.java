package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Parenthesis {

	public Parenthesis() {
	}
	
		public static void main(String[] args) throws NumberFormatException, IOException {
			// TODO Auto-generated method stub
			StringTokenizer st; String line="";
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int s1=Integer.parseInt(br.readLine());
			int n=s1;
			char symbol[]=new char[s1];
			String s=br.readLine();
			symbol=s.toCharArray();
			char oper[]=new char[s1-1];
			s=br.readLine();
			oper=s.toCharArray();
			System.out.println(countParenth(symbol,oper,n));
		
		}
		private static int countParenth(char[] symbol, char[] oper, int n) {
			// TODO Auto-generated method stub
			int f[][]=new int[n][n];
			int t[][]=new int[n][n];
			for(int i=0;i<n;i++)
			{
				t[i][i]=(symbol[i]=='t')?1:0;
				//System.out.println("t"+t[i][i]);
				f[i][i]=(symbol[i]=='f')?1:0;
				//System.out.println("f"+f[i][i]);
			}
			for(int gap=1;gap<n;gap++)
			{
				for(int i=0,j=gap;j<n;i++,j++)
				{
					t[i][j]=f[i][j]=0;
					for(int g=0;g<gap;g++)
					{
						int k=i+g;
						int tik=t[i][k]+f[i][k];
						int tij=t[k+1][j]+f[k+1][j];
						if(oper[k]=='&')
						{
							t[i][j]+=t[i][k]*t[k+1][j];
							f[i][j]+=tik*tij-t[i][k]*t[k+1][j];
						}
						else if(oper[k]=='|')
						{
							t[i][j]+=tik*tij-(f[i][k]*f[i][j]);
							f[i][j]+=f[i][k]*f[k+1][j];
						}
						else
						{
							t[i][j]+=(t[i][k]*f[k+1][j])+(t[k+1][j]*f[i][k]);
							f[i][j]+=(t[i][k]*t[k+1][j])+(f[i][k]*f[k+1][j]);
						}
					}
					System.out.println("t["+i+"]"+"["+j+"]"+t[i][j]);
				}
			}
			return t[0][n-1];
		}
}
			


