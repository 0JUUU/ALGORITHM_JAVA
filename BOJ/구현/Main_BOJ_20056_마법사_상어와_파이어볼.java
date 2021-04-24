import java.util.*;
import java.io.*;

public class Main_BOJ_20056_마법사_상어와_파이어볼 {
	static int N, M, K;
	static LinkedList<Ball>[][] board, tmp;
	static Ball[] ball;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static class Ball {
		int r, c, m, s, d;

		public Ball(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Ball [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new LinkedList[N+1][N+1];
		for(int i = 1; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				board[i][j] = new LinkedList<>();
			}
		}
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			board[r][c].add(new Ball(r, c, m, s, d));
		}
		
		// 이동명령
		// 1. 모든 파이어볼이 자신의 방향 d로 속력 s만큼 이동
	
		int cnt = 0;
		while(cnt != K) {
			move();	// board -> tmp로 움직여(board는 빈상태)
			divide();	// tmp에서 나눌거 다 나누고 board에 넣어(tmp는 빈상태)
			cnt++;
		}
		
		// 이동 K번 후, 남아있는 파이어볼 질량의 합
		int ans = 0;
		for(int i = 1; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				if(board[i][j].isEmpty()) continue;
				int size = board[i][j].size();
				for(int s = 0; s<size;s++) {
					ans += board[i][j].get(s).m;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	private static void divide() {
		for(int i =1; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				if(tmp[i][j].isEmpty()) continue;
				if(tmp[i][j].size() == 1) {
					board[i][j].add(tmp[i][j].pollFirst());
					continue;
				}
				int size = tmp[i][j].size();
				int sumM = 0, avgM = 0;
				int sumS = 0, avgS = 0;
				boolean isEven[] = new boolean[size];

				int index = 0;
				while(!tmp[i][j].isEmpty()) {
					Ball cur = tmp[i][j].pollFirst();
					sumM += cur.m;
					sumS += cur.s;
					isEven[index++] = cur.d % 2 == 0 ? true : false;
				}
				avgM = Math.floorDiv(sumM, 5);
				avgS = Math.floorDiv(sumS, size);
				if(avgM == 0) continue;
				int evenCnt = 0, oddCnt = 0;
				for(int k = 0; k<size;k++) {
					if(isEven[k]) evenCnt++;
					else oddCnt++;
				}
				
				if(evenCnt == size || oddCnt == size) {
					for(int k = 0; k<4;k++) {
						board[i][j].add(new Ball(i, j, avgM, avgS, 2 *k));
					}
				} else {
					for(int k = 0; k<4;k++) {
						board[i][j].add(new Ball(i, j, avgM, avgS, 2 *k + 1));
					}
				}
			}
		}
		
	}
	
	private static void move() {
		// arraylist에서 꺼내서 새로운 arraylist에 추가
		tmp = new LinkedList[N+1][N+1];
		for(int i =0; i<=N;i++) {
			for(int j = 0; j<=N;j++) {
				tmp[i][j] = new LinkedList<>();
			}
		}
		
		for(int i = 1; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				if(board[i][j].isEmpty()) continue;
				while(!board[i][j].isEmpty()) {
					Ball cur = board[i][j].pollFirst();
					int r = cur.r, c = cur.c, d = cur.d;
					int nr = cur.r, nc = cur.c;
					int s = cur.s;
					int speed = 0;
					// 속력만큼 움직이기
					while(speed != s) {
						nr = nr + dx[d];
						nc = nc + dy[d];
						if(nr <= 0 && nc <= 0) {
							nr = N+1; nc = N+1;
							continue;
						} else if(nr > N && nc > N) {
							nr = 0; nc = 0;
				 			continue;
						} else if(nr <= 0 && nc > N) {
							nr = N+1; nc = 0;
							continue;
						} else if(nr > N && nc <= 0) {
							nr = 0; nc = N+1; continue;
						} else if(nr <= 0 ) {
							nr = N+1; nc -= dy[d]; continue;
						} else if(nc<=0) {
							nc = N+1; nr -= dx[d]; continue;
						} else if(nr > N) {
							nr = 0; nc -= dy[d]; continue;
						} else if(nc > N ) {
							nc = 0; nr -= dx[d]; continue;
						}
						
						speed++;
					}
					
					tmp[nr][nc].add(new Ball(nr, nc, cur.m, s, d));
				}
			}
		}	// end for i
		
	}
}
