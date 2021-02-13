import java.util.*;
import java.io.*;

/**
 * BOJ 10026 적록색약
 * 2021.02.12
 * BFS를 이용하여 해결
 * @author 0JUUU
 *
 */
public class Main_BOJ_10026_적록색약 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		char[][] area = new char[N][N];
		
		for(int i = 0; i<N;i++) {			// 구역 입력
			String s = br.readLine();
			for(int j = 0; j<N;j++) {
				area[i][j] = s.charAt(j);
			}
		}
		int count_not = 0;
		int count_yes = 0;
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		// 적록색약 아닌 사람
		int[][] isVisited = new int[N][N];
		Queue<int[]> q_b = new LinkedList<int[]>();
		Queue<int[]> q_r = new LinkedList<int[]>();
		Queue<int[]> q_g = new LinkedList<int[]>();
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				if(area[i][j] == 'B' && isVisited[i][j] == 0) {
					q_b.offer(new int[] {i,j});
					isVisited[i][j] = 1;
					count_not++;
				}
				
				if(area[i][j] == 'R' && isVisited[i][j] == 0) {
					q_r.offer(new int[] {i,j});
					isVisited[i][j] = 1;
					count_not++;
				}
				
				if(area[i][j] == 'G' && isVisited[i][j] == 0) {
					q_g.offer(new int[] {i,j});
					isVisited[i][j] = 1;
					count_not++;
				}
				while(!q_b.isEmpty()) {
					int[] cur = q_b.poll();
					for(int dir = 0; dir<4;dir++) {
						int nx = cur[0] + dx[dir];
						int ny = cur[1] + dy[dir];
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(area[nx][ny] != 'B') continue;
						if(isVisited[nx][ny] != 0) continue;
						isVisited[nx][ny] = isVisited[cur[0]][cur[1]] +1;
						q_b.offer(new int[] {nx,ny});
					}
				}
				
				while(!q_r.isEmpty()) {
					int[] cur = q_r.poll();
					for(int dir = 0; dir<4;dir++) {
						int nx = cur[0] + dx[dir];
						int ny = cur[1] + dy[dir];
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(area[nx][ny] != 'R') continue;
						if(isVisited[nx][ny] != 0) continue;
						isVisited[nx][ny] = 1;
						q_r.offer(new int[] {nx,ny});
					}
				}
				
				while(!q_g.isEmpty()) {
					int[] cur = q_g.poll();
					for(int dir = 0; dir<4;dir++) {
						int nx = cur[0] + dx[dir];
						int ny = cur[1] + dy[dir];
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(area[nx][ny] != 'G') continue;
						if(isVisited[nx][ny] != 0) continue;
						isVisited[nx][ny] = 1;
						q_g.offer(new int[] {nx,ny});
					}
				}
			}
		}

		// 적록색약인 사람
		
		isVisited = new int[N][N];
		q_b = new LinkedList<int[]>();
		Queue<int[]> q_rg = new LinkedList<int[]>();
		
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				if(area[i][j] == 'B' && isVisited[i][j] == 0) {
					q_b.offer(new int[] {i,j});
					isVisited[i][j] = 1;
					count_yes++;
				}
				
				if((area[i][j] == 'R' || area[i][j] == 'G') && isVisited[i][j] == 0) {
					q_rg.offer(new int[] {i,j});
					isVisited[i][j] = 1;
					count_yes++;
				}

				while(!q_b.isEmpty()) {
					int[] cur = q_b.poll();
					for(int dir = 0; dir<4;dir++) {
						int nx = cur[0] + dx[dir];
						int ny = cur[1] + dy[dir];
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(area[nx][ny] != 'B') continue;
						if(isVisited[nx][ny] != 0) continue;
						isVisited[nx][ny] = isVisited[cur[0]][cur[1]] +1;
						q_b.offer(new int[] {nx,ny});
					}
				}
				
				while(!q_rg.isEmpty()) {
					int[] cur = q_rg.poll();
					for(int dir = 0; dir<4;dir++) {
						int nx = cur[0] + dx[dir];
						int ny = cur[1] + dy[dir];
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(area[nx][ny] == 'B') continue;
						if(isVisited[nx][ny] != 0) continue;
						isVisited[nx][ny] = 1;
						q_rg.offer(new int[] {nx,ny});
					}
				}
			}
		}
		
		System.out.println(count_not + " " + count_yes);
	}
}
