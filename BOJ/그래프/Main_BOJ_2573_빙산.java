import java.util.*;
import java.io.*;

/**
 * BOJ 2573 등산
 * 2021.04.05
 * : BFS & 대소비교 유의
 * @author 0JUUU
 *
 */
public class Main_BOJ_2573_빙산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, M, year = 0, island = 1;
		int[][] ice, separate;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ice = new int[N][M];
		Deque<int[]> q = new LinkedList<int[]>();
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		// 1. 녹이기
		while(island == 1) {
			boolean[][] visited = new boolean[N][M];
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<M;j++) {
					if(ice[i][j] == 0) continue;
					visited[i][j] = true;
					for(int dir= 0; dir<4;dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
						if(visited[nx][ny] || ice[nx][ny] != 0) continue;
						ice[i][j] = ice[i][j] == 0 ? 0 : ice[i][j]-1;
					}
				}
			}
			year++;
			
			// 2. 분리여부 확인
			separate = new int[N][M];
			int count = 0;
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<M;j++) {
					if(ice[i][j] == 0 || separate[i][j] != 0) continue;
					separate[i][j] = ++count;
					island = island < separate[i][j] ? separate[i][j] : island;
					q.offer(new int[] {i, j});
					while(!q.isEmpty()) {
						int cur[] = q.pollFirst();
						for(int dir = 0; dir<4;dir++) {
							int nx = cur[0] + dx[dir];
							int ny = cur[1] + dy[dir];
							if(nx < 0 || nx>=N|| ny<0||ny>=M) continue;
							if(ice[nx][ny] == 0) continue;
							if(separate[nx][ny] != 0) continue;
							separate[nx][ny] = separate[cur[0]][cur[1]];
							q.offer(new int[] {nx,ny});
						}
					}
				}
			}
			
			if(count == 0) island = 0;
		}
		if(island == 0) System.out.println(0); 
		else System.out.println(year);
	}
}
