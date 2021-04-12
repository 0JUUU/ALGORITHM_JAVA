import java.util.*;
import java.io.*;

/**
 * SWEA D4 1249 보급로
 * 2021.04.12
 * : 다익스트라와 입력받은 행렬을 이용하여 풂
 * @author 0JUUU
 *
 */
public class Solution_SWEA_D4_1249_보급로 {
	static class Node implements Comparable<Node> {
		int x; int y; int dist;

		public Node(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist-o.dist;
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			for(int i = 0; i<N;i++) {
				Arrays.fill(dist[i], 987654321);
			}
			dist[0][0] = 0;
			for(int i = 0; i<N;i++) {
				String s = br.readLine();
				for(int j = 0; j<N;j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[][] visited = new boolean[N][N];
			pq.add(new Node(0,0,0));
			int[] dx = {0,-1,0,1};
			int[] dy = {-1,0,1,0};
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(visited[cur.x][cur.y]) continue;
				visited[cur.x][cur.y] = true;
				
				for(int dir = 0; dir<4;dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(!visited[nx][ny] && dist[nx][ny] > cur.dist + map[nx][ny]) {
						dist[nx][ny] = cur.dist + map[nx][ny];
						pq.add(new Node(nx, ny, dist[nx][ny]));
					}
				}
			}
			
			sb.append("#"+tc +" " +dist[N-1][N-1]+ "\n");
		}
		System.out.print(sb);
	}
}
