import java.util.*;
import java.io.*;

/**
 * BOJ 17836 공주님을 구해라!
 * 2021.03.26
 * : BFS를 이용하여 그람을 얻지 않고 가는 경우와 그람을 얻고 가는 경우의 최솟값을 구함
 * @author 0JUUU
 *
 */
public class Main_BOJ_17836_공주님을_구해라 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] castle = new int[N][M];
		int[][] visited = new int[N][M];
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		Deque<int[]> q = new LinkedList<int[]>();
		int min = Integer.MAX_VALUE;
		int swordX = 0, swordY = 0;
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
				if(castle[i][j] == 2) {
					swordX = i; swordY = j;
				}
			}
		}
		
		// 그람을 찾지않고 가는 경우
		q.offer(new int[] {0,0});
		visited[0][0] = 1;
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			for(int dir = 0; dir<4;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx <0 || nx>=N||ny<0||ny>=M) continue;
				if(visited[nx][ny] != 0 || castle[nx][ny] == 1) continue;
				visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
				q.offer(new int[] {nx,ny});
			}
		}
		min = visited[N-1][M-1];
		
		// 그람을 찾아서 가는 경우
		visited = new int[N][M];
		q.offer(new int[] {0,0});
		visited[0][0] = 1;
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			for(int dir = 0; dir<4;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx <0 || nx>=N||ny<0||ny>=M) continue;
				if(visited[nx][ny] != 0 || castle[nx][ny] == 1) continue;
				visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
				if(nx == swordX && ny == swordY) break;
				q.offer(new int[] {nx,ny});
			}
		}
		int tmp = 0;
		if(visited[swordX][swordY] != 0) tmp = visited[swordX][swordY] + (N-1-swordX) + (M-1-swordY) ;
		if(min == 0 && tmp == 0) {
			System.out.println("Fail"); return;
		} else if(min == 0) min = tmp;
		else if(min != 0 && tmp != 0) min = min > tmp ? tmp : min;
		
		min -= 1;
		// 여기서 min을 -1을 하지 않고 비교하니까 T 시간에 도착하는 애를 Fail를 출력했음
		if(min > T) System.out.println("Fail");
		else System.out.println(min);
 	}
}
