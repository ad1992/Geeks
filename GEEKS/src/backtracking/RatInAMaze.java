package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi
 * 
 * In this solution the rat can only move down and right.
 *
 */
public class RatInAMaze {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("enter the size of maze");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim());
		int maze[][]=new int[N][N];
		int solve[][]=new int[N][N];
		String s;
		StringTokenizer st;
		System.out.println("Enter the values of maze.Enter \"1\" if block can be used and \"0\" if it a dead end");
		for(int i=0;i<N;i++)
		{
			System.out.println("enter the  row "+(i+1)+" values");
			if((s=br.readLine().trim())!=null)
			{
				st=new StringTokenizer(s);
				for(int j=0;j<N;j++)
				{
					maze[i][j]=Integer.parseInt(st.nextToken());
				}
			}
		}
		System.out.println("The maze is");
		printSolution(maze,N);
		if(getpath(maze,0,0,N-1,solve))
		{
			System.out.println("The path is ");
			printSolution(solve,N);
		}
		else
		{
			System.out.println("No Solution");
		}
	}

	private static void printSolution(int[][] maze, int N) {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++)
		{
			
			for(int j=0;j<N;j++)
			{
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static boolean getpath(int[][] maze, int i, int j,int N,int solve[][]) {
		if(i==N&&j==N)
		{
			solve[i][j]=1;
			return true;
		}
		
		if(i<0||i>N||j<0||j>N||maze[i][j]==0)
			return false;
		solve[i][j]=1;
		if(getpath(maze, i, j+1, N,solve))
		{
			return true;
		}
		if(getpath(maze, i+1, j, N,solve))
		{
			return true;
		}
		solve[i][j]=0;
		return false;
		
	}

}
