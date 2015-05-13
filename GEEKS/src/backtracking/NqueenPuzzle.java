package backtracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class NqueenPuzzle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("enter the size of board");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim());
		boolean queen[][]=new boolean[N][N];
		if(solve(queen,0,N))
		{
			printSolution(queen,N);
		}
		else
		{
			System.out.println("Solution does not exist");
		}
		

	}

	private static char[] printSolution(boolean[][] queen,int N) {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(queen[i][j])
				{
					System.out.print("Q ");
				}
				else
				{
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
		return null;
	}

	private static boolean solve(boolean[][] queen, int column,int N) {
		// TODO Auto-generated method stub
		if(column>=N)
		{
			return true;
		}
		for(int i=0;i<N;i++)
		{
			if(isSafe(queen,column,i,N))
			{
				queen[i][column]=true;
				if(solve(queen,column+1,N))
				{
					return true;
				}
				queen[i][column]=false;
			}
			
		}
		return false;
		
	}

	private static boolean isSafe(boolean[][] queen, int column, int row,int N) {
		// TODO Auto-generated method stub
		//checking the entire row
		for(int i=0;i<N;i++)
		{
			if(queen[row][i])
				return false;
		}
		//checking upper diagonal
		for(int i=row,j=column;i>=0&&j>=0;i--,j--)
		{
			if((queen[i][j]))
				return false;
		}
		//checking lower diagonal
		for(int i=row,j=column;i<N&&j>=0;i++,j--)
		{
			if((queen[i][j]))
				return false;
		}
		return true;
	}

}
