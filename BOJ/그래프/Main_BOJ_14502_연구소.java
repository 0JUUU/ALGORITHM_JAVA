import java.util.*;
import java.io.*;

/**
 * BOJ 14502 연구소
 * 2021.02.15
 * : 1. 벽을 세울 곳을 정하고, 후에 바이러스가 퍼지는 것을 관찰한다. 
 * @author 0JUUU
 *
 */
public class Main_BOJ_14502_연구소 {
	static int[][] temp, map;
	static int N, M, max;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] isSelected = new int[3][2];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		temp = new int[N][M];
		for(int i = 0; i<N;i++) {		// 지도 입력
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
			}
		}
		
		combination(0,0);
		System.out.println(max);
	}
	
	static void combination(int cnt, int startX) {

		if(cnt == 3) {
			int sum = count();
			max = sum > max ? sum : max;
			
			return;
		}
		for(int i = startX; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(map[i][j] != 0) continue;
				map[i][j] = 1;
				combination(cnt+1, i);
				map[i][j] =0;
			}
		}
	}
	static int count() {
		int sum = 0;
		bfs();
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(temp[i][j] == 0) sum++;
			}
		}
		return sum;
	}

	static void bfs() {
		for(int i =0; i<N;i++) {
			for(int j =0 ;j <M;j++) {
				temp[i][j] = map[i][j];
			}
		}
		boolean[][] isVisited = new boolean[N][M];
		Deque<int[]> q = new LinkedList<int[]>();
		for(int i =0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(isVisited[i][j]) continue;
				if(map[i][j] == 2) {
					q.offer(new int[] {i, j});
					isVisited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int cur[] = q.pollFirst();
			for(int dir = 0; dir<4;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx < 0 || nx >=N || ny < 0 || ny >=M) continue;
				if(temp[nx][ny] != 0) continue;
				if(isVisited[nx][ny]) continue;
				isVisited[nx][ny] = true;
				temp[nx][ny] = 2;
				q.offer(new int[] {nx,ny});
			}
		}
	}
}
