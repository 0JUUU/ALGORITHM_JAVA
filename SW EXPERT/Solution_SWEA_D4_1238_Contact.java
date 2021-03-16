import java.util.*;
import java.io.*;

/**
 * SWEA 1238 Contact
 * 2021.03.16
 * : 정점의 연결정보를 저장한 후, 시작점에서 BFS를 시작한다.
 * @author 0JUUU
 */

public class Solution_SWEA_D4_1238_Contact {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int count = 1; // max값을 저장할 곳
			
			int[][] V = new int[101][101];		// 정점끼리의 연결 정보
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N/2;i++) {			// 연결정보 저장
				V[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			Deque<Integer> queue = new LinkedList<Integer>();
			queue.offer(start);					// 시작점 --> 큐 안에
			int[] visited = new int[101];
			visited[start] = 1;
			while(!queue.isEmpty()) {
				int cur = queue.pollFirst();
				for(int i = 1; i<=100;i++) {
					if(V[cur][i] == 0) continue;
					if(visited[i] != 0) continue;
					visited[i] = visited[cur] + 1;
					count = visited[i];
					queue.add(i);
				}
			}
			
			int maxNumber = 0;
			for(int i = 0; i<100;i++) {
				if(visited[i] ==count) maxNumber = i;
			}
			
			sb.append("#" + tc +" " + maxNumber + "\n");
		}
		System.out.println(sb);
	}
}
