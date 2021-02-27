import java.util.*;
import java.io.*;

/**
 * BOJ 2234 성곽
 * 2021.02.26
 * @author 0JUUU
 *
 */
public class Main_BOJ_2234_성곽 {
	static int n, m;
	static int[][] wall;
	static int[][] visited;
	static int count, max, maxSum;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static Deque<int[]> queue = new LinkedList<int[]>();
	static Map<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
		wall = new int[n][m];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m;j++) {
				wall[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new int[n][m];
		for(int i = 0; i<n;i++) {
			for(int j = 0; j<m;j++) {
				if(visited[i][j] == 0) {
					queue.offer(new int[] {i, j});
					visited[i][j] = ++count;
					bfs();
				}
			}
		}
		
		for(int i = 0; i<n;i++) {
			for(int j = 0; j<m;j++) {
				for(int dir = 0; dir<4;dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];
					if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
					if(visited[nx][ny] == visited[i][j]) continue;
					int plus = map.get(visited[i][j]) + map.get(visited[nx][ny]);
					maxSum = plus > maxSum ? plus : maxSum;
				}
			}
		}
		System.out.println(count + " \n" + max + "\n" + maxSum);
	}
	private static void bfs() {
		int sum = 1;
//		int[] first = queue.getFirst();
		while(!queue.isEmpty()) {
			int[] cur = queue.pollFirst();
			for(int dir = 0; dir<4;dir++) {	// 벽이 없다는 것!	
				if((wall[cur[0]][cur[1]] & (1<<dir)) != 0) continue;
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx < 0 || ny < 0 || nx>=n || ny>=m) continue;
				if(visited[nx][ny] != 0) continue;
				visited[nx][ny] = visited[cur[0]][cur[1]];
				queue.offer(new int[] {nx, ny});
				sum++;
			}
		}
		map.put(count, sum);
		max = max < sum ? sum : max;
	}
}
