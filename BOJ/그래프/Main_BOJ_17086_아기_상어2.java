import java.util.*;
import java.io.*;

/**
 * BOJ 17086 아기 상어 2
 * 2021.02.15
 * SSAFY 스터디
 * : BFS 이용
 * @author 0JUUU
 *
 */
public class Main_BOJ_17086_아기_상어2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] area = new int[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] isVisited = new int[N][M];
		int[] dx = {-1,-1,-1,0,0,1,1,1};	// 8방
		int[] dy = {-1,0,1,-1,1,-1,0,1};
		
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(area[i][j] == 1) {
					q.offer(new int[] {i, j});
					isVisited[i][j] = 1;
				}
			}
		}
		int max = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir = 0; dir<8;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(isVisited[nx][ny] != 0) continue;
				if(area[nx][ny] != 0) continue;
				q.offer(new int[] {nx,ny});
				isVisited[nx][ny] = isVisited[cur[0]][cur[1]] + 1;
				max = isVisited[cur[0]][cur[1]];
			}
		}
		System.out.println(max);
	}
}
