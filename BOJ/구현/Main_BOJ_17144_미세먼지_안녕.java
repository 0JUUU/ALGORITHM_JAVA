import java.util.*;
import java.io.*;

/**
 * BOJ 17144 미세먼지 안녕!
 * 2021.04.14
 * : T초 지난 후 구사과 방에 남아있는 미세먼지의 양
 * : 각각의 미세먼지가 퍼지는 것을 계산 --> 모든 미세먼지에 대한 확산을 계산했으면 이후 계산값을 업데이트
 * : 바람은 위쪽과 아래쪽으로 나누어 각각 계산
 * @author 0JUUU
 *
 */
public class Main_BOJ_17144_미세먼지_안녕 {
	static int R, C, T, dust;
	static int[][] board, spread;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static class Cleaner {
		int x; int y;
		
		public Cleaner(int x) {
			super();
			this.x = x;
			this.y = 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		Cleaner[] cleaner = new Cleaner[2];
		int clean = 0;
		board = new int[R][C];
		for(int i = 0; i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<C;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == -1) cleaner[clean++] = new Cleaner(i);
			}
		}
		
		int time = 0;
		while(time != T) {
			speardDust();
			startCleaner(cleaner);
			time++;
		}
		
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				if(board[i][j] > 0) dust += board[i][j];
			}
		}
		System.out.println(dust);
	}
//	
//	private static void printStatus() {
//		for(int i = 0; i<R;i++) {
//			for(int j = 0; j<C;j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

	static int[] upX = {-1,0,1,0};
	static int[] upY = {0,1,0,-1};
	
	static int[] downX = {1,0,-1,0};
	static int[] downY = {0,1,0,-1};
	private static void startCleaner(Cleaner[] cleaner) {
		// 위쪽 ---> 반시계방향
		int dir = 0;
		int startX = cleaner[0].x-1;
		int startY = 0;
		while(dir != 4) {
			int nx = startX + upX[dir];
			int ny = startY + upY[dir];
			if(nx < 0 || nx >= cleaner[0].x+1 || ny < 0 || ny >= C) dir++;
			else {
				board[startX][startY] = board[nx][ny];
				startX = nx;
				startY = ny;
			}
		}
		board[cleaner[0].x][1] = 0;
		
		// 아래쪽 --> 시계방향
		dir = 0;
		startX = cleaner[1].x + 1;
		startY = 0;
		while(dir != 4) {
			int nx = startX + downX[dir];
			int ny = startY + downY[dir];
			if(nx < cleaner[1].x || nx >= R|| ny < 0 || ny >= C) dir++;
			else {
				board[startX][startY] = board[nx][ny];
				startX = nx;
				startY = ny;
			}
		}
		board[cleaner[1].x][1] = 0;
	}
	
	private static void speardDust() {
		spread = new int[R][C];
		
		// 미세먼지 퍼지게 하기 (독립적으로)
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				if(board[i][j] < 5) continue;
				int count = 0;
				int amount = board[i][j] / 5;
				for(int dir = 0; dir<4;dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					if(board[nx][ny] == -1) continue;
					spread[nx][ny] += amount;
					count++;
				}
				board[i][j] -= count * amount;
			}
		}
		
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				board[i][j] += spread[i][j];
			}
		}
	}
}
