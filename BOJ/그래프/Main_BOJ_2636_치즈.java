import java.util.*;
import java.io.*;

/**
 * BOJ 2636 치즈
 * 2021.03.24
 * : BFS를 이용하여 풀었음
 * : 치즈의 가장자리 부분만 찾는 것이 중요 포인트!
 * @author 0JUUU
 *
 */

public class Main_BOJ_2636_치즈 {
	static int max, sx, sy, N, M;	// 세로, 가로
	static int[][] board, disappear;	// 사각형 모양의 판 & 치즈가 사라지는 시간 저장
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static Deque<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		disappear = new int[N][M];
	
		do {
			visited = new boolean[N][M];
			visited[sx][sy] = true;
			q.offer(new int[] {sx,sy});
			bfs();
		}while(isOne());
		
		int count = 0;
		// disappear에서 최대값 & 개수 세기
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(disappear[i][j] == max) count++;
			}
		}
		System.out.println(max);
		System.out.println(count);
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			int cur[] = q.pollFirst();
			for(int dir = 0; dir<4;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx < 0 || nx>=N||ny < 0 || ny >= M) continue;
				if(visited[nx][ny]) continue;
				if(board[nx][ny] == 1) {	// 가장자리에 있는 치즈는 탐색할 정점에 넣지 않음
					disappear[nx][ny] = max+ 1;
					visited[nx][ny] = true;
					continue;
				}
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
		
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(disappear[i][j] != 0) {
					board[i][j] = 0;
				}
			}
		}
		max++;
	}
	private static boolean isOne() {
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(board[i][j] == 1) return true;
			}
		}
		return false;
	}
}
