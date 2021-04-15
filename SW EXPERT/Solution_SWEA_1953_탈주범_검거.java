import java.util.*;
import java.io.*;

/**
 * SWEA 1953 탈주범 검거
 * 2021.04.15
 * @author 0JUUU
 *
 */
public class Solution_SWEA_1953_탈주범_검거 {
	static class Direction {
		int x, y, pair;

		public Direction(int x, int y, int pair) {
			super();
			this.x = x;
			this.y = y;
			this.pair = pair;	// 넘어갈 수 있는 방향 설정
		}
		
	}
	static int[][] pipe = new int[8][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Direction[] dir = new Direction[4];
		dir[0] = new Direction(-1,0,1);		// 상	
		dir[1] = new Direction(1,0,0);		// 하	
		dir[2] = new Direction(0,-1,3);		// 좌
		dir[3] = new Direction(0, 1, 2);	// 우
		
		for(int tc = 1; tc<=T;tc++) {
			int count = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			for(int i = 0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 파이프 방향 설정
			pipe[1] = new int[] {0,1,2,3};
			pipe[2] = new int[] {0,1};
			pipe[3] = new int[] {2,3};
			pipe[4] = new int[] {0,3};
			pipe[5] = new int[] {1,3};
			pipe[6] = new int[] {1,2};
			pipe[7] = new int[] {0,2};
			
			int[][] visited = new int[N][M];
			
			// 맨홀 지점 설정
			visited[R][C] = 1;
			Deque<int[]> q = new LinkedList<int[]>();
			q.offer(new int[] {R,C});
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				// 설치된 파이프 번호
				int d = map[cur[0]][cur[1]];
				
				// 탈출조건
				if(visited[cur[0]][cur[1]] == L) break;
				
				
				int size = pipe[d].length;
				for(int i = 0; i<size;i++) {
					int num = pipe[d][i];
					int nx = cur[0] + dir[num].x;
					int ny = cur[1] + dir[num].y;

					if(nx < 0 || nx >=N || ny < 0 || ny >= M) continue;
					if(visited[nx][ny] != 0 || map[nx][ny] == 0) continue;
					int ndir = map[nx][ny];
					int nsize = pipe[ndir].length;
					for(int j = 0; j<nsize;j++) {
						if(dir[num].pair == pipe[ndir][j]) {
							visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
							q.offer(new int[] {nx,ny});
						}
					}
				}
			}
			
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<M;j++) {
					if(visited[i][j] != 0 && visited[i][j] <= L) count++;
				}
			}
			// 
			sb.append("#"+tc+" " +count+ "\n");
		}
		System.out.print(sb);
	}
}
