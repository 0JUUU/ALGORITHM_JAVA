import java.util.*;
import java.io.*;

public class Main_BOJ_17143_낚시왕 {
	static int R, C, M, kingC;
	static int[][] water;
	static Shark[] shark;
	static boolean[] notExit;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,1,-1};
	static class Shark implements Comparable<Shark>{
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		public int compareTo(Shark o) {
			return this.z- o.z;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		shark = new Shark[M];
		notExit = new boolean[M];
		water = new int[R + 1][C + 1];
		for(int i = 0; i<=R;i++) {
			Arrays.fill(water[i], -1);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			shark[i] = new Shark(r, c, s, d, z);
		}
		Arrays.sort(shark);	// 크기 오름차순 정렬
		if(M == 0) System.out.println(0);
		else {
			for(int i =0; i<M;i++) {
				water[shark[i].r][shark[i].c] = i;
			}
			
			int fishing = 0;
			// 낚시왕 이동
			while (kingC != C) {
				kingC++;
				// 잡을 수 있는 물고기가 있는지 확인
				for (int i = 1; i <= R; i++) {
					if (water[i][kingC] == -1)
						continue;
					// water[i][kingC]가 0이 아닌 곳 : 물고기가 있는 곳을 찾았다.
					// 몇번째 상어인지 확인
					for(int j = 0; j<M;j++) {
						if(notExit[j]) continue;
						if(shark[j].c != kingC) continue;
						if(shark[j].r == i) {
							notExit[j] = true;
							fishing += shark[j].z;
							water[i][kingC] = -1;
							break;
						}
					}
					break;
				}
				// 상어 이동
				moveShark();
			}
			
			System.out.println(fishing);
		}
	}

	private static void moveShark() {
		int[][] tmp = new int[R+1][C+1];
		for(int i = 0; i<=R;i++) {
			Arrays.fill(tmp[i], -1);
		}
		for(int i = 0; i<M;i++) {
			if(notExit[i]) continue;	// 존재하지 않는 상어 걍 넘김
			
			// 존재하는 상어들만 올 수 있는 코드
			int r = shark[i].r;
			int c = shark[i].c;
			int s = shark[i].s;
			int d = shark[i].d;
			int z = shark[i].z;
			
			int nr = r, nc = c;
			int cnt = 0;
			while(cnt!=s) {
				nr = nr + dx[d];
				nc = nc + dy[d];
				
				if(nr <= 0 || nr > R || nc <= 0 || nc>C) {
					nr = nr - dx[d]; nc = nc-dy[d];
					d = d % 2 == 1? ++d : --d;
					continue;
				}
				cnt++;
			}
			shark[i].r = nr; shark[i].c = nc; shark[i].d = d;
			// 크기가 겹치는게 없고, 작은 것부터 탐색했기에 --> 걍 덮어쓰면 됨
			// 이전에 있던 값은 처리해주고
			if(tmp[nr][nc] != -1) {
				notExit[tmp[nr][nc]] = true;
			}
			tmp[nr][nc] = i;
		}
		
		for(int i = 0; i<=R; i++) {
			for(int j = 0; j<=C;j++) {
				water[i][j] = tmp[i][j];
			}
		}
	}
}
