import java.util.*;
import java.io.*;

/**
 * BOJ 3190 뱀
 * 2021.11.02
 * : Mod 연산 주의! (mod에는 음수가 안나오는 줄 알았다..)
 * @author 0JUUU
 *
 */
public class Main_BOJ_3190_뱀 {

	static int N, K, L;
	static int[][] board;
	static char[] times;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];
		
		for(int i = 0; i < K; i++) {
			 st = new StringTokenizer(br.readLine());
			 int r = Integer.parseInt(st.nextToken());
			 int c = Integer.parseInt(st.nextToken());
			 board[r][c] = -1;
		}
		
		L = Integer.parseInt(br.readLine());
		times = new char[10001];
		
		for(int i = 0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			times[time] = dir;
		}
		
		int sx = 1, sy = 1;
		int dir = 0;
		int len = 1;
		int time = 0;
		board[1][1] = 1;
		LinkedList<int[]> snake = new LinkedList<>();
		snake.add(new int[] {1,1});
		while(true) {
			
			// 머리 늘리기
			sx += dx[dir];
			sy += dy[dir];
			
			time++;
			// 현재
			if(meetWallOrSelf(sx, sy, dir, len)) 
				break;
			
			// 늘린 칸에 사과 존재 => 뱀 길이 증가 (이전꺼 표시 그대로) & 사과지우기
			if(board[sx][sy] == -1) {
				board[sx][sy] = 0;
				len++;
			} 
			// 사과 존재 x => 이전꺼 표시 0으로 
			else if(board[sx][sy] == 0) {
				// 제일 마지막 꼬리 지우기
				int[] tail = snake.poll();
				board[tail[0]][tail[1]] = 0;
			}
			board[sx][sy] = 1;
			snake.add(new int[] {sx, sy});
			
			// 해당 시간에 방향 전환 있으면 하기
			if(time > 10000) continue;
			if(times[time] == 'L')
				dir = (dir +3) % 4;	// 얘를 빼면 왜 안될까? 음수가 안나오는줄 ;;;
			else if(times[time] == 'D')
				dir = (dir+1) % 4;
		}
		System.out.println(time);
	}

	private static boolean meetWallOrSelf(int sx, int sy, int dir, int len) {
		
		// 벽이랑 만날 때
		if(sx <= 0 || sx > N || sy <= 0 || sy > N) 
			return true;
		// 자기 몸이랑 만날 때
		if(board[sx][sy] != 0 && board[sx][sy] != -1) 
			return true;
		return false;
	}
}
