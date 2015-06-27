package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Aakansha Doshi
 * 
 *         Given two strings ‘X’ and ‘Y’, find the length of the longest common
 *         substring. For example, if the given strings are “GeeksforGeeks” and
 *         “GeeksQuiz”, the output should be 5 as longest common substring is
 *         “Geeks”
 * 
 */
public class LongestCommonSubstring {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		String s1, s2;
		s1 = br.readLine().trim();
		s2 = br.readLine().trim();
		int ans = commomSubstring(s1, s2);
		out.println(ans);
		out.close();

	}

	private static int commomSubstring(String s1, String s2) {
		// TODO Auto-generated method stub
		int common[][] = new int[s1.length() + 1][s2.length() + 1];
		int max = -1;
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {

				if (i == 0 || j == 0) {
					common[i][j] = 0;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					common[i][j] = common[i - 1][j - 1] + 1;
					max = Math.max(max, common[i][j]);
				} else {
					common[i][j] = 0;
				}
			}
		}
		return max;
	}

}
