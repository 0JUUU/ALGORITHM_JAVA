import java.util.*;
import java.io.*;

/**
 * BOJ 8972 미친 아두이노
 * 2021.03.09
 * : 1. 구현
 * : 2. 1~5과정의 순서를 꼭 지켜야한다.
 * : 3. 4번과 5번의 과정이 뒤바뀌니 실패함
 * @author 0JUUU
 *
 */
public class Main_BOJ_8972_미친_아두이노 {
	static int R, C, X;
	static char[][] board;
	static int[][] copy_board;
	static String direction;
	static boolean meet = false;
	static int[] dx = {1,1,1,0,0,0,-1,-1,-1};
	static int[] dy = {-1,0,1,-1,0,1,-1,0,1};
	static int[] jongsu = new int[2]; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];

		for(int i = 0; i<R;i++) {
			String s = br.readLine();
			for(int j = 0; j<C;j++) {
				board[i][j] = s.charAt(j);
				if(board[i][j] == 'I') {
					jongsu[0] = i;
					jongsu[1] = j;
				}
			}
		}
		
		direction = br.readLine();
		
		for(int i = 0; i<direction.length();i++) {
			int nx, ny;						// 종수 먼저 움직인다. 
			nx = jongsu[0] + dx[direction.charAt(i) - '1'];
			ny = jongsu[1] + dy[direction.charAt(i) - '1'];

			if(board[nx][ny] == 'R') {		// 종수가 갈 곳에 로봇이 있다면 그 즉시 실패
				X = i+1;
				meet = true;
				break;
			}
			board[jongsu[0]][jongsu[1]] = '.';
			board[nx][ny] = 'I';
			jongsu[0] = nx; jongsu[1] = ny;
			
			moveCrazy();
			if(meet) {
				X = i+1;
				break;
			} 
		}
		
		if(meet) System.out.println("kraj " + X);
		else {
			for(int i = 0; i<R;i++) {
				for(int j = 0; j<C;j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
		}
	}
	private static void moveCrazy() {
		copy_board = new int[R][C];
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				if(board[i][j] != 'R') continue;
				int dir = -1, min = Integer.MAX_VALUE;
				for(int d = 0; d<9;d++) {		// 가장 짧은 거리 구하기
					int length = Math.abs(jongsu[0] - (i + dx[d])) + Math.abs(jongsu[1] - (j + dy[d]));
					if(min > length) {
						min = length; dir = d;
					}
				}
				board[i][j] = '.'; 
				copy_board[i + dx[dir]][j + dy[dir]]++;
			}
		}
		
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				if(copy_board[i][j] != 0 && board[i][j] == 'I') {
					meet = true;
					break;
				} else if(copy_board[i][j] != 1) continue;
				
				board[i][j] = 'R';	
			}
			if(meet) break;
		}
	}
}
