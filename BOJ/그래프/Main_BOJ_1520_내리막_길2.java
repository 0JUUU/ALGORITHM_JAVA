import java.util.*;
import java.io.*;

/**
 * BOJ 1520 내리막 길
 * 2021.04.06
 * : 2. BFS & PriorityQueue
 * @author 0JUUU	
 *
 */
public class Main_BOJ_1520_내리막_길2 {
	static int M, N;
	static int[][] map, route;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static class Point implements Comparable<Point> {
		int x, y, height;

		public Point() {}

		public Point(int x, int y, int height) {
			super();
			this.x = x;
			this.y = y;
			this.height = height;
		}

		@Override
		public int compareTo(Point o) {
			return o.height - this.height;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		route = new int[M][N];
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		if(map[0][0] < map[M-1][N-1]) System.out.println(0);
		else {
			route[0][0] = 1;
			PriorityQueue<Point> high = new PriorityQueue<>(); 
			high.add(new Point(0,0,map[0][0]));
			while(!high.isEmpty()) {
				Point cur = high.poll();
				for(int dir = 0; dir<4;dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					if(nx < 0 || nx >=M || ny <0 || ny>=N) continue;
					if(map[nx][ny] >= map[cur.x][cur.y]) continue;
					if(route[nx][ny] == 0) {
						route[nx][ny] = route[cur.x][cur.y];
						high.add(new Point(nx,ny,map[nx][ny]));
					} else {
						route[nx][ny] += route[cur.x][cur.y];
					}
				}
			}

			System.out.println(route[M-1][N-1]);
		}
	}
	private static void dfs(int x, int y) {
		for(int dir = 0; dir<4;dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(nx <  0 || nx >= M || ny < 0 || ny>=N) continue;
			if(map[x][y] <= map[nx][ny]) continue;
			if(route[nx][ny] == 0) route[nx][ny] =1 ;
			route[nx][ny]++;
			dfs(nx,ny);
		}
	}
}
