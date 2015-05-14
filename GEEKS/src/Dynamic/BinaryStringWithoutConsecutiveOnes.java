package Dynamic;

import java.util.*;

/**
 * @author Aakansha Doshi
 * 
 *         Given a positive integer N, count all possible distinct binary
 *         strings of length N such that there are no consecutive 1’s.
 *         This code has been modified to print the strings also.
 *         
 *         This is the modified version of my code in Ideone http://ideone.com/Gw2H8e         
 * 
 * 
 * 
 */
public class BinaryStringWithoutConsecutiveOnes {
	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = sc.nextInt();
		sc.close();
		String a[] = new String[1];
		String b[] = new String[1];
		a[0] = "0";
		b[0] = "1";
		int a1 = 0, b1 = 0;
		int a2 = 1;
		int b2 = 1;
		// System.out.println(a[0]);
		// System.out.println(b[0]);
		for (int i = 2; i <= n; i++) {
			String newa[] = new String[2 * a2];
			String newb[] = new String[2 * b2];
			a1 = 0;
			b1 = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j].charAt(0) == '0') {
					newa[a1++] = '0' + a[j];
					newa[a1++] = '1' + a[j];

				} else {
					newa[a1++] = '0' + a[j];
				}
			}
			for (int j = 0; j < b.length; j++) {
				if (b[j].charAt(0) == '0') {
					newb[b1++] = '0' + b[j];
					newb[b1++] = '1' + b[j];

				} else {
					newb[b1++] = '0' + b[j];

				}
			}
			a = new String[a1];
			b = new String[b1];
			System.arraycopy(newa, 0, a, 0, a1);
			System.arraycopy(newb, 0, b, 0, b1);
			a2 = a1;
			b2 = b1;
		}
		int count=0;
		// display the strings
		for (int i1 = 0; i1 < a.length; i1++) {
			System.out.println(a[i1]);
			count++;
		}
		for (int i1 = 0; i1 < b.length; i1++) {
			System.out.println(b[i1]);
			count++;
		}
		System.out.println("There are "+count +" Strings possible");
	}
}