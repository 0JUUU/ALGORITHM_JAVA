import java.util.*;
import java.io.*;

/**
 * BOJ 2589 보물섬
 * 2021.03.16
 * : 1. 브루트포스와 BFS를 이용하여 max값과 비교하며 해결했다.
 * @author 0JUUU
 *
 */
public class Main_BOJ_2589_보물섬 {
	static int N, M, max;
	static char[][] map;
	static int[][] visited;
	static Deque<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0; i<N;i++) {
			String s = br.readLine();
			for(int j = 0; j<M;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		max = 1;
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(map[i][j] == 'W') continue;
				visited = new int[N][M];
			
				visited[i][j] = 1;
				q.offer(new int[] {i, j}); 
				bfs();
			}
		}
		if(max == 1) System.out.println(0);
		else System.out.println(max-1);
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	private static void bfs() {
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			for(int i = 0; i<4;i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(map[nx][ny] == 'W') continue;
				if(visited[nx][ny] != 0) continue;
				visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
				max = visited[nx][ny] > max ? visited[nx][ny] : max;
				q.offer(new int[] {nx, ny});
			}
		}
	}
}
