import java.util.*;
import java.io.*;

/**
 * BOJ 21610 마법사 상어와 비바라기
 * 2021.06.09
 * : 삼성전자 2021 상반기 오후 1번문제
 * @author 0JUUU
 *
 */
public class Main_BOJ_21610_마법사_상어와_비바라기 {

	static int N, M;
	static int[][] board;
	static boolean[][] isCloud;
	static LinkedList<Cloud> cloud = new LinkedList<>();
	static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
	static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
	static class Movement {
		int d, s;

		public Movement(int d, int s) {
			super();
			this.d = d;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Movement [d=" + d + ", s=" + s + "]";
		}
	}
	
	static class Cloud {
		int x, y;

		public Cloud(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Cloud [x=" + x + ", y=" + y + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N+1][N+1];
		isCloud = new boolean[N+1][N+1];
		LinkedList<Movement> move = new LinkedList<>();
		
		for(int i = 1; i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if((i == N && j == 1) || (i == N && j == 2) || (i == N-1 && j==1) || (i == N-1&& j==2)) {
					isCloud[i][j] = true;
				}
			}
		}
		// 초기 구름 이동
		cloud.add(new Cloud(N, 1));
		cloud.add(new Cloud(N, 2));
		cloud.add(new Cloud(N-1, 1));
		cloud.add(new Cloud(N-1, 2));
		
		// 구름의 이동방향 및 속력 입력
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			move.add(new Movement(d, s));
		}
		
		while(!move.isEmpty()) {
			// 현재 구름 있는 곳 이동
			Movement curMove = move.poll();
			moveCloud(curMove.d, curMove.s);
			// 이동한 곳에 비가 내림
			for(int i = 1; i<=N;i++) {
				for(int j = 1; j<=N;j++) {
					if(isCloud[i][j]) board[i][j]++;
				}
			}
			// 구름 있는 곳 대각선 방향에 물 있는 놈의 개수 세서 물 추가
			for(int i = 1; i<=N;i++) {
				for(int j = 1; j<=N;j++) {
					if(!isCloud[i][j]) continue;
					int waterCnt = 0;
					for(int dir = 1; dir<=4;dir++) {
						int nx = i + dx[2*dir];
						int ny = j + dy[2*dir];
						if(nx < 1 || nx>N|| ny <1|| ny>N) continue;
						if(board[nx][ny] != 0) waterCnt++;
					}
					board[i][j] += waterCnt;
				}
			}
			
			// 바구니 물 2 이상일 경우, 구름 생기고 & 양은 2 줄어듦 (이전 구름이었던 놈 생성  X)
			for(int i = 1; i<=N;i++) {
				for(int j = 1; j<=N;j++) {
					if(isCloud[i][j]) continue;
					if(board[i][j] < 2) continue;
					board[i][j] -= 2;
					cloud.add(new Cloud(i, j));
				}
			}
		}
		
		int water = 0;
		for(int i = 1;i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				water += board[i][j];
			}
		}
		System.out.println(water);
	}

	private static void moveCloud(int d, int s) {
		boolean[][] tmpIsCloud = new boolean[N+1][N+1];
		while(!cloud.isEmpty()) {
			Cloud cur = cloud.poll();
			int move = 0;
			int cx = cur.x;
			int cy = cur.y;
			int nx = -1, ny = -1;
			while(move != s) {
				nx = cx + dx[d];
				ny = cy + dy[d];
				
				if(nx < 1 && ny < 1) {
					cx = N+1;
					cy = N+1;
					continue;
				} else if(nx < 1 && ny > N) {
					cx = N+1;
					cy = 0;
					continue;
				} else if(nx < 1) {
					cx = N+1;
					continue;
				} else if(nx > N && ny < 1) {
					cx = 0;
					cy = N+1;
					continue;
				} else if(nx > N && ny > N) {
					cx = 0;
					cy = 0;
					continue;
				} else if(nx > N) {
					cx = 0;
					continue;
				} else if(ny < 1) {
					cy = N+1;
					continue;
				} else if(ny > N) {
					cy = 0;
					continue;
				} else {
					cx = nx; 
					cy = ny;
				}
				
				move++;
			}
			tmpIsCloud[nx][ny] = true;
		}
		
		for(int i = 1; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				isCloud[i][j] = tmpIsCloud[i][j];
			}
		}
	}
}
