import java.util.*;
import java.io.*;

/**
 * BOJ 16927 배열 돌리기 2
 * 2021.03.08
 * 1: TLE 
 * @author 0JUUU	
 *
 */
public class Main_BOJ_16927_배열_돌리기_2 {
	static int N, M, R, dir, startX, startY;
	static int[][] arr;
	static int[] dx = {0,1,0,-1};	// 우 하 좌 상
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<M/2;i++) {
			startX = i; startY = i;
			moveArr(i);			
		}
		
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	private static void moveArr(int cnt) {
 		int rotate = 0;
 		for(int i = 0; i<R;i++) {	
 			int sx = startX; 
 			int sy = startY;
 			int temp = arr[startX][startY];
 			if(startX == N-startX+1) return;
 			while(dir != 4) {
 				int nx = sx + dx[dir];
 				int ny = sy + dy[dir];
 				if(nx < startX || nx >= N - startX || ny < startY || ny >= M-startY) {
 					dir++; continue;
 				}
 				arr[sx][sy] = arr[nx][ny];
 				sx = nx; sy = ny;
 			}
 			
 			arr[startX+1][startY] = temp;
 			dir = 0;
 		}
	}
}
