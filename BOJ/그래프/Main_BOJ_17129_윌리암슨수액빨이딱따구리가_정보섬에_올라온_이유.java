import java.util.*;
import java.io.*;

/**
 * BOJ 17129 윌리암슨수액빨이딱따구리가 정보섬에 올라온 이유
 * 2021.09.20
 * 흔한 BFS
 * @author 0JUUU
 *
 */
public class Main_BOJ_17129_윌리암슨수액빨이딱따구리가_정보섬에_올라온_이유 {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] island = new int[n][m];
		int[][] visited = new int[n][m];
		
		LinkedList<int[]> q = new LinkedList<>();
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j<m;j++) {
				island[i][j] = Integer.parseInt(s.substring(j, j+1));
				if(island[i][j] == 2) {
					q.add(new int[] {i, j});
					visited[i][j] = 1;
				}
			}
		}
		
		boolean isFind = false;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int dir = 0; dir<4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if(island[nx][ny] == 1) continue;
				if(visited[nx][ny] != 0) continue;
				visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
				q.add(new int[] {nx, ny});
				if(island[nx][ny] != 0) {
					System.out.println("TAK");
					System.out.println(visited[nx][ny]-1);
					return;
				}
			}
		}
		System.out.println("NIE");
	}
}
