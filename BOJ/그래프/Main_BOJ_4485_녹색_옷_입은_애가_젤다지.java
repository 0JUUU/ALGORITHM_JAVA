import java.util.*;
import java.io.*;

/**
 * BOJ 4485 녹색 옷 입은 애가 젤다지?
 * 2021.03.23
 * : dijkstra 이용
 * @author 0JUUU
 *
 */
public class Main_BOJ_4485_녹색_옷_입은_애가_젤다지 {
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
	static int[] dx = {0,1, -1, 0};
	static int[] dy = {1,0, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			int[][] info = new int[N][N];
			int[] dist = new int[N * N];
			Arrays.fill(dist, 123456789);
			
			for(int i = 0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N;j++) {
					info[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dist[0] = info[0][0];
			boolean[] visited = new boolean[N*N];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, dist[0]));
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(visited[cur.vertex]) continue;
				visited[cur.vertex] = true;
				if(cur.vertex == N*N-1) break;
				
				for(int dir = 0; dir<4; dir++) {
					int nx = cur.vertex / N + dx[dir];
					int ny = cur.vertex % N + dy[dir];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					if(!visited[nx * N + ny] && dist[nx * N + ny] > cur.totalDist + info[nx][ny]) {
						dist[nx * N + ny] = cur.totalDist + info[nx][ny];
						pq.offer(new Node(nx * N + ny, dist[nx*N + ny]));
					}
				}
			}
			sb.append("Problem " +tc++ +  ": " + dist[N*N-1] + "\n");
		}
		
		System.out.print(sb);
	}
}
