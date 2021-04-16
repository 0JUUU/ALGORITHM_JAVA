import java.util.*;
import java.io.*;

/**
 * BOJ 14503 로봇 청소기
 * 2021.04.16
 * : 방향을 잘 지정했어야함(방향에 유의하자)
 * @author 0JUUU
 *
 */

public class Main_BOJ_14503_로봇_청소기 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] clean = new int[N][M];
		boolean isMove = true;
		int sort = 1;
		while(true) {
//			for(int i = 0; i<N;i++) {
//				for(int j =0; j<M;j++) {
//					System.out.print(clean[i][j] + " ");
//				}
//				System.out.println();
//			}
			
//			System.out.println();
			clean[r][c] = sort++;	// 현재 위치 청소
			
			int count = 0;	// 방향 바꾼 횟수
			int save = d;
			int tmp;
			while(count != 5) {
				tmp = (d + 3) % 4;
				// 현재 위치 & 현재 방향 기준 왼쪽 방향
				count++;
				int nx = r + dx[tmp];
				int ny = c + dy[tmp];
				d = tmp;
				if(count == 5) {
					d = save;
					nx = r + dx[(d+2) % 4];
					ny = c + dy[(d+2) % 4];
					if(map[nx][ny] == 1) {
						isMove = false;
						break;
					}
					r = nx; c = ny; 
					count = 0;
					continue;
				}
				if(clean[nx][ny] != 0 || map[nx][ny] == 1) continue;
				r = nx; c = ny;
				
				break;
			}
			
			if(!isMove) break;
		}
		
		int countClean = 0;
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				System.out.print(clean[i][j] + " ");
				if(clean[i][j] != 0) countClean++;
			}
			System.out.println();
		}
		System.out.println(countClean);
	}
}
