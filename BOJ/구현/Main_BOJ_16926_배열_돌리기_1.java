import java.util.*;
import java.io.*;

/**
 * BOJ 16926 배열 돌리기 1
 *  2021.02.10
 * : N과 M 중 min을 기준으로 한다. : 시작점 (0,0) : 내 값을 tmp에 저장하고
 * --> 시간 초과
 * @author 0JUUU 
 *
 */

public class Main_BOJ_16926_배열_돌리기_1 {
	static int[] dx = { 0, 1, 0, -1 };	// 우 하 좌 상
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] arr;
	static int[][] answer;
	static int start = 0;
	static int end = 0;
	static int x = 0;
	static int y = 0;
	static int N, M, R;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
	
		for (int i = 0; i < N; i++) { // 배열 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int move = (N > M ? M : N) / 2;

		for (int i = 0; i<R; i++) {
			rotate(move);
		}
		
		for(int i = 0; i<N;i++) {
			for(int j =0 ;j<M;j++) {
				sb.append(arr[i][j] + " " );
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.print(sb);
	}
	static void rotate(int move) {
		for(int cnt = 0; cnt<move;cnt++) {
			int dir = 0;
			int sX = cnt;
			int sY = cnt;
			int value = arr[sX][sY];
			
			while(dir<4) {
				int nX = sX + dx[dir];
				int nY = sY + dy[dir];
				 if (cnt <= nX && nX < N- cnt && cnt <= nY && nY < M - cnt) {//배열의 범위를 넘어섰다면, 바깥 로테이션 범위를 넘어섰다면
	                 arr[sX][sY] = arr[nX][nY]; //값 시프트

	                 sX = nX; //이동
	                 sY = nY; //이동
	             } else {
	                 dir++;
	             }
			}
			
			arr[cnt+1][cnt] = value;
		}
	}
	
}
