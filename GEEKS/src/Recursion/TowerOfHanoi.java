package Recursion;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Aakansha Doshi
 * Implementation of tower of hanoi using stacks;
 * 
 *
 */
public class TowerOfHanoi {
	int n;
	static Tower towers[];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of disks");
		int n = sc.nextInt();
		sc.close();
		int i1=0;
		towers = new Tower[3];
		for (char i = 'A'; i <='C'; i++) {
			towers[i1] = new Tower(i);
			i1++;
		}

		for (int i=n; i >=1; i--) {
			towers[0].add(i);
			
		}
		//Print the content of tower[0]
		System.out.println("Tower 0 contains");
		towers[0].disp();
		towers[0].towerofhanoi(n,towers[0],towers[1],towers[2]);
		//Print the content of tower[2]
		System.out.println("Tower 2 contains");
		towers[2].disp();
		System.out.println("There are "+Tower.count+ " steps ");
	}
	
	
}
	class Tower {
		Stack<Integer> st;
		char  index;
		static int count=0;
		public Tower(char i) {
			// TODO Auto-generated constructor stub
			st = new Stack<>();
			index = i;

		}

		public void towerofhanoi(int n, Tower begin, Tower aux, Tower end) {
			// TODO Auto-generated method stub
			if(n>0)
			{
				towerofhanoi(n-1, begin, end, aux);
				moveTopToTower(begin,end);
				count++;
				towerofhanoi(n-1, aux, begin, end);
			}
		}

		protected  void add(int num) {
			if (!st.isEmpty() && st.peek()<num) {
				System.out.println("Error entering the disk" + num);
			} else {
				st.push(num);
			}
		}

		protected void moveTopToTower(Tower T,Tower T1) {
			int top = T.st.pop();
			T1.add(top);
			System.out.println("Moving disk " + top + " from tower " + T.index
					+ " to tower " + T1.index);
			

		}
		//Display function to print the content of towers
		protected void disp()
		{
			for(int i=0;i<st.size();i++)
			{
				System.out.println(st.get(i));
			}
		}
		

	}
