import java.util.*;
import java.io.*;

/**
 * BOJ 20057 마법사 상어와 토네이도
 * 2021.06.10
 * : 예제 4와 6이 안됨 뭐가 문제일지 내일 확인해보자.
 * 2021.06.12
 * : windy[1][6] / [1][7] 부분이 동일했음 => 달랐어야한다!! (좌표 위치 변환 작업에서 실수 발생 -> 신경쓰자)
 * @author user
 *
 */
public class Main_BOJ_20057_마법사_상어와_토네이도 {

	static int N;
	static int[][] board;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[][] windx = {
			{0, -1, 1, -2, 2, -1, 1, -1, 1,0},
			{2, 1, 1, 0, 0, 0, 0, -1, -1,1},
			{0, -1, 1, -2, 2, -1, 1, -1, 1,0},
			{-2, -1, -1, 0, 0, 0, 0, 1, 1,-1}
	};
	static int[][] windy = {
			{-2, -1, -1, 0, 0, 0, 0, 1, 1,-1},
			{0, -1, 1, -2, 2, -1, 1, -1, 1,0},
			{2, 1, 1, 0, 0, 0, 0, -1, -1,1},
			{0, -1, 1, -2, 2, -1, 1, -1, 1,0}
	};
	
	static double[] spread = {5, 10, 10, 2, 2, 7, 7, 1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int i =0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sx = N/2, sy = N/2;
		int length = 1;
		int move = 0;
		int cnt = 0;
		int sand = 0;
		int dir = 0;
		while(sx != 0 || sy != 0) {	// 달팽이 모양으로 잘 돌아감
			if(move == length) {
				move = 0;
				dir = (dir+1)%4;
				cnt++;
			}
			int nx = sx + dx[dir];
			int ny = sy + dy[dir];

			move++;
			if(cnt == 2) {
				length++;
				cnt = 0;
			}
			
			// 이동할 곳에 모래가 있다면!
			if(board[nx][ny] != 0) {
				int sum = board[nx][ny];
				for(int i = 0; i<9;i++) {
					int spreadx = nx + windx[dir][i];
					int spready = ny + windy[dir][i];
					int addSand = (int) ((board[nx][ny] * spread[i]) / 100);
					if(spreadx < 0 || spreadx >= N || spready < 0 || spready >= N) {
						sand += addSand;
					} else {
						board[spreadx][spready] += addSand;
					}
					sum -= addSand;
				}
				
				int alphax = nx + windx[dir][9];
				int alphay = ny + windy[dir][9];
				if(alphax < 0 || alphax >= N || alphay < 0 || alphay >= N) {
					sand += sum;
				} else {
					board[alphax][alphay] += sum;
				}
				board[nx][ny] = 0;
			}
			sx = nx; sy = ny;
			
		}
		System.out.println(sand);
	}
}
