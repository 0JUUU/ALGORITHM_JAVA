import java.util.*;
import java.io.*;

/**
 * BOJ 5427 불
 * 2021.03.10
 * : BFS 이용
 * : 불의 퍼지는 시간과 상근이가 움직이는 시간을 계산해서 답을 구하였다.
 * : 불과 상근이를 비교할 때 유의하자. 조건을 뺴먹으면 틀린다. ㅎㅎ
 * @author 0JUUU
 *
 */
public class Main_BOJ_5427_불 {
	static int w, h, min, x, y;
	static char[][] building;
	static int[][] fire, sang;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static Deque<int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T;t++) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			building = new char[h][w];
			fire = new int[h][w];
			sang = new int[h][w];
			for(int i = 0; i<h;i++) {
				String s = br.readLine();
				for(int j = 0; j<w;j++) {
					building[i][j] = s.charAt(j);
					if(building[i][j] == '@') {
						sang[i][j] = 1;
						x = i; y = j;
					} else if(building[i][j] == '*') {
						fire[i][j] = 1;
						queue.offer(new int[] {i,j});
					}
				}
			}
			if(x == 0 || x== h-1 || y == 0 || y == w-1) min = 1;
			else {
				spreadFire();	// 불이 퍼질 상황 모두 정리
				moveSanggeun();
				for(int i = 0;i<h;i++) {
					for(int j = 0; j<w;j++) {
						if(sang[i][j] == 0) continue;
						if(i == 0 || i == h-1 || j == 0 || j == w-1) {
							min = sang[i][j] < min ? sang[i][j] : min; 
						}
					}
				}
			}

			if(min == Integer.MAX_VALUE) sb.append("IMPOSSIBLE\n");
			else sb.append(min + "\n");
		}
		
		System.out.println(sb);
	}
	private static void moveSanggeun() {
		queue.offer(new int[] {x,y});	// 상근이가 움직일 상황 예측
		while(!queue.isEmpty()) {
			int[] cur = queue.pollFirst();
			
			for(int dir = 0; dir<4;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
				if(building[nx][ny] != '.') continue;
				if(sang[nx][ny] != 0) continue;
				if(fire[nx][ny] != 0 && (sang[cur[0]][cur[1]] + 1 >= fire[nx][ny])) continue;
				sang[nx][ny] = sang[cur[0]][cur[1]] + 1;
				queue.offer(new int[] {nx,ny});
			}
		}
		
	}
	private static void spreadFire() {
		while(!queue.isEmpty()) {
			int[] cur = queue.pollFirst();
			
			for(int dir = 0; dir<4;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
				if(building[nx][ny] == '#' || building[nx][ny] == '*') continue;
				if(fire[nx][ny] != 0) continue;
				fire[nx][ny] = fire[cur[0]][cur[1]] + 1;
				queue.offer(new int[] {nx,ny});
			}
		}
	}
}
