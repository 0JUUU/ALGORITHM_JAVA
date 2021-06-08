import java.util.*;
import java.io.*;

/**
 * BOJ 3197 백조의 호수
 * 2021.06.08
 * : 그냥 BFS 2번 하는 건 TLE (R,C <= 1500이기 때문~)
 * @author 0JUUU
 *
 */
public class Main_BOJ_3197_백조의_호수 {

	static int R, C;
	static char[][] lake;
	static int[][] swan = new int[2][2];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		lake = new char[R][C];
		int day = 0;
		int swanCnt = 0;
		for(int i = 0; i<R;i++) {
			String input = br.readLine();
			for(int j = 0; j<C;j++) {
				lake[i][j] = input.charAt(j);
				if(lake[i][j] == 'L') {		// 백조 저장
					swan[swanCnt][0] = i;
					swan[swanCnt++][1] = j;
				}
			}
		}
		
		while(true) {
			// 백조끼리 만나는지 확인
			if(meetSwan()) break;
			// 얼음 녹기
			meltIce();
			day++;
		}
		System.out.println(day);
	}
	private static void meltIce() {
		boolean[][] isMelt = new boolean[R][C];
		Deque<int[]> q = new LinkedList<>();
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				if(lake[i][j] == 'X') continue;
				if(isMelt[i][j]) continue;
				q.add(new int[] {i, j});
				isMelt[i][j] = true;
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					
					for(int dir = 0; dir<4;dir++) {
						int nx = cur[0] + dx[dir];
						int ny = cur[1] + dy[dir];
						if(nx < 0 || nx >= R || ny < 0 || ny >=C) continue;
						if(isMelt[nx][ny]) continue;
						isMelt[nx][ny] = true;
						if(lake[nx][ny] != 'X') {
							q.add(new int[] {nx, ny});
						}
					}
 				}
			}
		}
		
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				if(lake[i][j] != 'X') continue;
				if(isMelt[i][j]) lake[i][j] = '.';
			}
		}
	}
	private static void printLake() {
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				System.out.print(lake[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	private static boolean meetSwan() {
		Deque<int[]> q = new LinkedList<>();
		boolean[][] isVisted = new boolean[R][C];
		q.add(swan[0]);
		isVisted[swan[0][0]][swan[0][1]] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int dir = 0; dir<4;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >= R || ny < 0 || ny >=C) continue;
				if(isVisted[nx][ny] || lake[nx][ny] == 'X') continue;
				if(nx == swan[1][0] && ny == swan[1][1]) return true;
				isVisted[nx][ny] = true;
				q.add(new int[] {nx,ny});
			}
		}
		return false;
	}
}
