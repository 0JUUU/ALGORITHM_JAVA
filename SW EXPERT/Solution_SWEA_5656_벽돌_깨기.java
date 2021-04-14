import java.util.*;
import java.io.*;

/**
 * SWEA 5656 벽돌 깨기
 * 2021.04.14
 * @author 0JUUU
 *
 */

public class Solution_SWEA_5656_벽돌_깨기 {
	static int N, W, H, ball, min = Integer.MAX_VALUE;
	static int[][] block, tmp;
	static int[] selected;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			block = new int[H][W];
			selected = new int[N];
			min = Integer.MAX_VALUE;
			for(int i = 0; i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<W;j++) {
					block[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			selectCol(0,0);
			sb.append("#"+tc+" " +min+ "\n");
		}
		System.out.print(sb);
	}
	
	private static void selectCol(int cnt, int start) {
		if(min == 0) return;
		if(cnt == N) {
			int count = 0;
			tmp = new int[H][W];
			for(int i = 0; i<H;i++) {
				for(int j =0; j<W;j++) {
					tmp[i][j] = block[i][j];
				}
			}
			
			breakBall();
			
			for(int i = 0; i<H;i++) {
				for(int j =0; j<W;j++) {
					if(tmp[i][j] != 0) count++;
				}
			}

			min = min > count ? count : min;
			if(min == 0) return;
			return;
		}
		for(int i = 0; i<W;i++) {
			selected[cnt] = i;
			selectCol(cnt+1, i);
		}
		if(min == 0) return;
	}
	
	private static void breakBall() {
		int[][] breaklist;
		Deque<int[]> q = new LinkedList<int[]>();
		LinkedList<Integer> col = new LinkedList<>();
		for(int select = 0; select<N;select++) {
			int drop = 0;
			for(int i = 0; i<H;i++) {
				if(tmp[i][selected[select]] != 0) {
					drop = i; break;
				}
			}
			breaklist = new int[H][W];
			q.add(new int[] {drop, selected[select]});
			breaklist[drop][selected[select]] = 1;
			while(!q.isEmpty()) {
				int[] cur = q.pollFirst();
				int len = tmp[cur[0]][cur[1]] -1;
				tmp[cur[0]][cur[1]] = 0;
				// 위
				for(int i = 1; i<=len;i++) {
					int nx = cur[0] - i;
					int ny = cur[1];
					if(nx < 0) continue;
					if(breaklist[nx][ny] != 0 || tmp[nx][ny] == 0) continue;
					breaklist[nx][ny] = 1;
					if(tmp[nx][ny] > 1) q.add(new int[] {nx, ny});
					else tmp[nx][ny] = 0;
				}
				
				// 아래
				for(int i = 1; i<=len;i++) {
					int nx = cur[0] + i;
					int ny = cur[1];
					if(nx >= H) continue;
					if(breaklist[nx][ny] != 0 || tmp[nx][ny] == 0) continue;
					breaklist[nx][ny] = 1;
					if(tmp[nx][ny] > 1) q.add(new int[] {nx, ny});
					else tmp[nx][ny] = 0;
				}
				
				// 오른쪽
				for(int i = 1; i<=len;i++) {
					int nx = cur[0];
					int ny = cur[1] + i;
					if(ny >= W) continue;
					if(breaklist[nx][ny] != 0 || tmp[nx][ny] == 0) continue;
					breaklist[nx][ny] = 1;
					if(tmp[nx][ny] > 1) q.add(new int[] {nx, ny});
					else tmp[nx][ny] = 0;
				}
				
				// 왼쪽
				for(int i = 1; i<=len;i++) {
					int nx = cur[0];
					int ny = cur[1] - i;
					if(ny < 0) continue;
					if(breaklist[nx][ny] != 0 || tmp[nx][ny] == 0) continue;
					breaklist[nx][ny] = 1;	
					if(tmp[nx][ny] > 1) q.add(new int[] {nx, ny});
					else tmp[nx][ny] = 0;
				}
			}	// end while
			
			for(int j = 0; j<W;j++) {
				col = new LinkedList<>();
				for(int i = 0; i<H;i++) {
					col.addFirst(tmp[i][j]);
				}
				while(col.contains(0)) {
					col.remove((Integer)0);
				}

				int size = col.size();
				int index = H-1;
				for(int i = 0; i<size;i++) {
					tmp[index][j] = col.pollFirst();
					index--;
				}
				
				for(int i = index; i>=0;i--) {
					tmp[i][j] = 0;
				}
				
			}
		}	// end for select
		
	}
}
