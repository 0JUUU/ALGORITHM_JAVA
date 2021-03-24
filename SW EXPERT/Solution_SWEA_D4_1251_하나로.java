import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA 1251 하나로 2021.03.24
 * : 프림 알고리즘 이용 & 반올림 시 최종 값만 반올림하는 것임 ㅎ
 * @author 0JUUU
 *
 */
public class Solution_SWEA_D4_1251_하나로 {

	static class Node {
		int x;
		int y;

		Node() {
			super();
		}

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[][] adjMatrix = new long[N][N];
			boolean[] visited = new boolean[N];
			Node[] nodes = new Node[N];
			for (int i = 0; i < N; i++)
				nodes[i] = new Node();
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (i == 0)
						nodes[j].x = Integer.parseInt(st.nextToken());
					else
						nodes[j].y = Integer.parseInt(st.nextToken());
				}
			}
			
//			for(int i = 0; i<N;i++) {
//				System.out.println(nodes[i]);
//			}
			double E = Double.parseDouble(br.readLine());
			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					long dist = (long) (Math.pow(nodes[i].x - nodes[j].x, 2) + Math.pow(nodes[i].y - nodes[j].y, 2));
					adjMatrix[i][j] = adjMatrix[j][i] = dist;
				}
			}

			long[] minDist = new long[N];
			Arrays.fill(minDist, Long.MAX_VALUE);
			long cost = 0;
			minDist[0] = 0;
			for (int i = 0; i < N; i++) {
				long min = Long.MAX_VALUE;
				int minIndex = 0;
				for (int j = 0; j < N; j++) {
					if (!visited[j] && min > minDist[j]) {
						min = minDist[j];
						minIndex = j;
					}
				}

				cost += min;
				visited[minIndex] =  true;
				for (int j = 0; j < N; j++) {
					if (!visited[j] && adjMatrix[minIndex][j] != 0 && minDist[j] > adjMatrix[minIndex][j]) {
						minDist[j] = adjMatrix[minIndex][j];
					}
				}
			}
			cost = Math.round(cost * E);
			sb.append("#" + tc + " " +cost+ "\n");
		}
		System.out.print(sb);
	}
}
