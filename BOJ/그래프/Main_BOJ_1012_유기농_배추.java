import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 1012. 유기농 배추
 * 2021.02.03
 * SSAFY 스터디
 * : 1. BFS 이용하여 품
 * : 증감연산자를 유의하자. 
 * @author 0JUUU
 *
 */

public class Main_BOJ_1012_유기농_배추 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] farm = new int[M][N];
			for(int k = 0; k<K;k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[x][y] = 1;
			}
			
			
			int[] dx = {1,-1,0,0};	// 하 상 우 좌
			int[] dy = {0,0,1,-1};
			int[][] visited = new int[M][N];
			Queue<Farm> q = new LinkedList<>();
			int count = 1;
			for(int i = 0;i<M;i++) {
				for(int j = 0; j<N;j++) {
					if(farm[i][j] == 1 && visited[i][j] == 0) {
						visited[i][j] = count++; 
						q.add(new Farm(i,j));
					}
					while(!q.isEmpty()) {
						Farm cur = q.poll();
						for(int dir = 0; dir<4;dir++) {
							int x = cur.x + dx[dir];
							int y = cur.y + dy[dir];
							if(x < 0 || x >= M) continue;
							if(y < 0 || y >=N) continue;
							if(visited[x][y] != 0 || farm[x][y] != 1) continue;
							q.add(new Farm(x,y));
							visited[x][y] = visited[cur.x][cur.y];
						}
					}

				}
			}

			System.out.println(--count);
		} // for - 테케

	}//main
}
class Farm {
	int x;
	int y;
	public Farm (int x, int y) {
		this.x = x;
		this.y = y;
	}
}