import java.util.*;
import java.io.*;

/**
 * BOJ 14502 연구소
 * 2021.03.26
 * : 조합을 이용 --> 세울 벽 3개를 골라서 바이러스가 퍼지는 것을 확인
 * : 안전영역의 최대값
 * @author 0JUUU	
 *
 */
public class Main_BOJ_14502_연구소 {
	static int N, M, max = Integer.MIN_VALUE;
	static int[][] map, copyMap;
	static Deque<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
	
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 3개의 벽을 선택
		comb(0,0);
		System.out.println(max);
	}
	private static void comb(int cnt, int start) {
		if(cnt == 3) {
			int safe = bfs();
			max = max < safe ? safe : max;
			return;
		}
		
		for(int i = start; i<N*M;i++) {
			int x = i / M;
			int y = i % M;
			if(map[x][y] != 0) continue;
			map[x][y] = 1;
			comb(cnt+1, x * M + y);
			map[x][y] = 0;
		}
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	private static int bfs() {
		int safe = 0;
		copyMap();

		// 바이러스가 퍼지는 것을 관찰
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(copyMap[i][j] == 2 ) {
					q.offer(new int[] {i, j});
				}	
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			for(int dir = 0; dir<4;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx < 0 || nx>=N || ny<0 || ny>=M) continue;
				if(copyMap[nx][ny] != 0) continue;
				copyMap[nx][ny] = 2;
				q.offer(new int[] {nx,ny});
			}
		}
		
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(copyMap[i][j] == 0) safe++;
			}
		}
		return safe;
	}
	
	private static void copyMap() {
		copyMap = new int[N][M];
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
}
