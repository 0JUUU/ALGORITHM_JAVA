import java.util.*;
import java.io.*;

/**
 * BOJ 7576 토마토
 * 2021.2.19
 * BFS
 * */

public class Main_BOJ_7576_토마토 {
	static int N, M;
	static int[][] tomato, isVisited;
	static Deque<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M]; isVisited = new int[N][M];
		int countTomato = 0;
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] == 0) countTomato++;
				else if(tomato[i][j] == 1) {
					q.addLast(new int[] {i,j});
					isVisited[i][j] = 1;
				}
			}
		}
		
		int[] dx = {-1,0,1,0}; int[] dy = {0,-1,0,1};
		if(countTomato == 0) System.out.println(0);
		else {
			int max = 0;
			while(!q.isEmpty()) {
				int cur[] = q.pollFirst();
				for(int dir = 0; dir<4;dir++) {
					int nx = cur[0] + dx[dir]; 
					int ny = cur[1] + dy[dir];
					
					if(0 > nx || nx >= N || 0>ny || ny >= M) continue;
					if(isVisited[nx][ny] != 0) continue;
					if(tomato[nx][ny] != 0) continue;
					tomato[nx][ny] = 1;
					isVisited[nx][ny] = isVisited[cur[0]][cur[1]] + 1;
					max = max < isVisited[cur[0]][cur[1]] ? isVisited[cur[0]][cur[1]] : max;
					q.addLast(new int[] {nx,ny});
				}
			} 
			
			boolean isZero = false;
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<M;j++) {
					if(tomato[i][j] != -1 && isVisited[i][j] == 0) isZero = true;
					if(isZero) break;
				}
				if(isZero) break;
			}
			
			if(isZero) System.out.println(-1);
			else System.out.println(max);
		}
	}
}
