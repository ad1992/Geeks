package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author Aakansha Doshi 
 * 
 * 
 *         Snake and Ladder Problem
 * 
 *         Given a snake and ladder board, find the minimum number of dice
 *         throws required to reach the destination or last cell from source or
 *         1st cell. Basically, the player has total control over outcome of
 *         dice throw and wants to find out minimum number of throws required to
 *         reach last cell.
 * 
 */
public class SnakeAndLadder {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s, s1;
		int comma, start, end;
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int move[] = new int[101];
			if ((s = br.readLine()) != null) {
				// System.out.println(s);

				if ((s = br.readLine()) != null) {
					st = new StringTokenizer(s, " ");
					while (st.hasMoreElements()) {
						s1 = st.nextToken();
						comma = s1.indexOf(',');
						start = Integer.parseInt(s1.substring(0, comma));
						end = Integer.parseInt(s1.substring(comma + 1));
						move[start] = end;

					}
					// System.out.println(s);
					if ((s = br.readLine()) != null) {

						st = new StringTokenizer(s, " ");
						while (st.hasMoreElements()) {
							s1 = st.nextToken();
							comma = s1.indexOf(',');
							start = Integer.parseInt(s1.substring(0, comma));
							end = Integer.parseInt(s1.substring(comma + 1));
							move[start] = end;

						}
						// System.out.println(s);
						int vertex = 1;
						boolean visited[] = new boolean[101];
						LinkedList<Q> queue = new LinkedList<Q>();
						queue.add(new Q(1, 0));
						int ans = 0;
						l: {
							while (vertex < 100) {
								Q q = queue.poll();
								vertex = q.ver;
								// System.out.println(vertex+" " +q.dist);
								visited[vertex] = true;
								for (int adj = vertex + 1; adj <= vertex + 6
										&& adj <= 100; adj++) {
									if (!visited[adj]) {
										int next = adj;
										if (next == 100) {
											ans = q.dist + 1;
											break l;
										}
										if (move[adj] != 0)
											next = move[adj];
										queue.add(new Q(next, q.dist + 1));
										ans = q.dist + 1;
										queue.add(new Q(next, ans));
										visited[adj] = true;
									}
								}

							}
						}
						System.out.println(ans);

					}
				}

			}
		}
	}
}

class Q {
	int ver, dist;

	Q(int v, int d) {
		ver = v;
		dist = d;
	}
}
