import java.util.*;
import java.io.*;

/**
 * BOJ 15683 감시
 * 2021.04.21
 * : cctv당 감시할 수 있는 방향을 달리하여 모든 경우를 다 탐색하였음
 * @author 0JUUU
 *
 */
public class Main_BOJ_15683_감시 {
	static int N, M, K, min = Integer.MAX_VALUE;
	static ArrayList<int[]> listCCTV;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static ArrayList<int[]>[] cctv = new ArrayList[6];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(0 < map[i][j] && map[i][j] < 6) K++;
			}
		}
		
		listCCTV = new ArrayList<>();

		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(0 < map[i][j] && map[i][j] < 6) {
					listCCTV.add(new int[] {i, j});
				}
			}
		}
		
		// cctv 종류에 따른 감시할 수 있는 방법
		for(int i = 0; i<6;i++) {
			cctv[i] = new ArrayList<>();
		}
		cctv[1].add(new int[] {0}); cctv[1].add(new int[] {1}); cctv[1].add(new int[] {2}); cctv[1].add(new int[] {3});
		cctv[2].add(new int[] {0,2}); cctv[2].add(new int[] {1,3});
		cctv[3].add(new int[] {0,1}); cctv[3].add(new int[] {0,3}); cctv[3].add(new int[] {1,2}); cctv[3].add(new int[] {2,3});
		cctv[4].add(new int[] {0,1,2}); cctv[4].add(new int[] {0,1,3}); cctv[4].add(new int[] {1,2,3}); cctv[4].add(new int[] {0,2,3});
		cctv[5].add(new int[] {0,1,2,3});
		
		selectDir(0, map);
		System.out.println(min);
	}
	private static void selectDir(int cnt, int[][] map) {
		if(cnt == listCCTV.size()) {
			int sum = 0;
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<M;j++) {
					if(map[i][j] == 0) sum++;
				}
			}
			
			min = min > sum ? sum : min;
			return;
		}
		
		int[] cur = listCCTV.get(cnt);
		int[][] tmp;
		int size = cctv[map[cur[0]][cur[1]]].size();
		for(int s = 0; s<size;s++) {
			// cctv[map[cur[0]][cur[1]]]의 감시할 수 있는 방법이 들어감.
			int[] each = cctv[map[cur[0]][cur[1]]].get(s);
			int sx = cur[0]; int sy = cur[1];
			
			tmp = new int[N][M];
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<M;j++) {
					tmp[i][j] = map[i][j];
				}
			}
			
			// each에 속한 방향대로 tmp에 표시해주기
			for(int dir = 0; dir < each.length; dir++) {
				sx = cur[0]; sy = cur[1];
				
				while(true) {
					int nx = sx + dx[each[dir]];
					int ny = sy + dy[each[dir]];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(tmp[nx][ny] == 6) break;
					if(tmp[nx][ny] == 0) tmp[nx][ny] = -1;
					sx = nx; sy = ny;
				}
			}
			
			selectDir(cnt+1, tmp);
		}
	}
}
