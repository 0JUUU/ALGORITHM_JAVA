import java.util.*;
import java.io.*;

/**
 * BOJ 3055 탈출
 * 2021.03.11
 * : 1. BFS 이용
 * @author 0JUUU
 *
 */
public class Main_BOJ_3055_탈출 {
	static int R, C, bx, by, sx, sy;	// bx,by : 비버의 굴 위치, sx, sy : 고숨도치 시작위치
	static char[][] map;
	static int[][] water, S;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static Deque<int[]> queue = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		water = new int[R][C]; S = new int[R][C];
		for(int i =0; i<R;i++) {		// 지도 입력, 처리
			String s = br.readLine();
			for(int j = 0; j<C;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'D') {
					bx = i; by = j;
				} else if(map[i][j] == 'S') {
					S[i][j] = 1; sx = i; sy = j;
				} else if(map[i][j] == '*') {
					water[i][j] = 1; queue.offer(new int[] {i,j});
				}
			}
		}
		
		expectWater();
		moveS();
		if(S[bx][by] == 0) System.out.println("KAKTUS");
		else System.out.println(S[bx][by] - 1);
	}
	private static void moveS() {
		queue.offer(new int[] {sx,sy});
		while(!queue.isEmpty()) {
			int[] cur = queue.pollFirst();
			for(int dir = 0; dir<4;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >=R || ny <0 || ny>=C) continue;
				if(map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
				if(S[nx][ny] != 0) continue;	// 이 한 줄 차이로 메모리초과 --> 통과
				if(water[nx][ny] != 0 && (S[cur[0]][cur[1]] + 1 >= water[nx][ny])) continue;
				S[nx][ny] = S[cur[0]][cur[1]] + 1;
				queue.offer(new int[] {nx,ny});
			}
		}	
	}
	
	private static void expectWater() {
		while(!queue.isEmpty()) {
			int[] cur = queue.pollFirst();
			for(int dir = 0; dir<4;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >=R || ny <0 || ny>=C) continue;
				if(map[nx][ny] == 'X' || map[nx][ny] == 'D' || map[nx][ny] == '*') continue;
				if(water[nx][ny] != 0) continue;
				water[nx][ny] = water[cur[0]][cur[1]] + 1;
				queue.offer(new int[] {nx,ny});
			}
		}
	}
}
