import java.util.*;
import java.io.*;

/**
 * SWEA 1236 사람 네트워크2
 * 2021.03.25
 * : 다익스트라
 * @author 0JUUU
 *
 */
public class Solution_SWEA_D6_1263_사람_네트워크2_2 {
	static class Node implements Comparable<Node> {
		int vertex;
		int totalDist;
		public Node(int vertex, int totalDist) {
			super();
			this.vertex = vertex;
			this.totalDist = totalDist;
		}
		@Override
		public int compareTo(Node o) {
			return this.totalDist - o.totalDist;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for(int tc = 1; tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			ArrayList<Node>[] adjList = new ArrayList[N];
			for(int i = 0; i<N;i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i = 0; i<N;i++) {
				for(int j =0 ;j<N;j++) {
					int dist = Integer.parseInt(st.nextToken());
					if(dist != 0) {
						adjList[i].add(new Node(j, dist));
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i<N;i++) {
				int start = i;
				int[] D = new int[N];
				Arrays.fill(D, 987654321);
				D[start] = 0;
				boolean[] visited = new boolean[N];
				PriorityQueue<Node> pq = new PriorityQueue<>();
				pq.offer(new Node(start, 0));
				int sum = 0;
				while(!pq.isEmpty()) {
					Node cur = pq.poll();
					if(visited[cur.vertex]) continue;
					visited[cur.vertex] = true;
					sum += cur.totalDist;
					
					if(sum > min) break;
					for(int j = 0;j<adjList[cur.vertex].size();j++) {
						Node next = adjList[cur.vertex].get(j);
						if(!visited[next.vertex] && D[next.vertex] > cur.totalDist + next.totalDist) {
							D[next.vertex] = cur.totalDist + next.totalDist;
							pq.offer(new Node(next.vertex, D[next.vertex]));
						}
					}
				}
				

				min = min > sum ? sum : min;
				if(min == N-1) break;
			}

			sb.append("#"+tc+" " +min+ "\n");
		}
		System.out.print(sb);
	}
}
