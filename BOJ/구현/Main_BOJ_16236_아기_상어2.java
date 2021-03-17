import java.util.*;
import java.io.*;

/**
 * BOJ 16236 아기 상어
 * 2021.03.17
 * : 현재 상어 좌표에서 먹으러 갈 수 있는 물고기들의 거리를 구한 후, 그 중 가장 짧으며 위에 있는 것, 위에 있는 것들이 여러개라면
 * : 가장 왼쪽에 있는 것을 고른 뒤 좌표값과 걸리는 시간을 바꿔준다. 
 * @author 0JUUU
 *
 */

public class Main_BOJ_16236_아기_상어2 {
	static int N, sharkX, sharkY, time, count, size = 2;
	static int[][] space, dist;
	static Deque<int[]> q = new LinkedList<int[]>();
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static boolean isFish;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		dist = new int[N][N];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N;j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j] == 9) {
					sharkX = i; sharkY = j;
					q.offer(new int[] {i, j});
				}
 			}
		}
		do {
			dist = new int[N][N];
			findFish();
		}while(isFish);
		
		System.out.println(time);
	}
	private static void findFish() {
		isFish = false;
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			for(int d = 0; d<4;d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(nx < 0 || nx >=N|| ny<0||ny>=N) continue;
				if(space[nx][ny] == 9) continue;
				if(space[nx][ny] > size) continue;
				if(dist[nx][ny] != 0) continue;
				dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
				q.offer(new int[] {nx,ny});
				if(space[nx][ny] != 0 && space[nx][ny] < size) {
					min = dist[nx][ny] < min ? dist[nx][ny] : min;
				}
			}
		}
		
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				if(space[i][j] != 0 && space[i][j] < size && dist[i][j] == min) {
					setSpace(new int[] {i, j});
					isFish = true;
					if(isFish) break;
				}
			}
			if(isFish) break;
		}
	}
	private static void setSpace(int[] nextShark) {
		space[sharkX][sharkY] = 0;
		sharkX = nextShark[0]; sharkY = nextShark[1];
		space[sharkX][sharkY] = 9;
		count++;
		time += dist[sharkX][sharkY];
		q.clear();
		q.offer(new int[] {sharkX, sharkY});
		if(count == size) {
			count = 0; size++;
		}
		
	}
}
