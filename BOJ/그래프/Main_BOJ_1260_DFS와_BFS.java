import java.util.*;
import java.io.*;

/**
 * BOJ 1260 DFS와 BFS
 * 2021.03.16
 * : 1. 인접행렬을 이용하여 DFS와 BFS 구현
 * @author 0JUUU
 *
 */

public class Main_BOJ_1260_DFS와_BFS {
	static int N, M, V;
	static int[][] adjMatrix;
	static int[] visited;
	static StringBuilder sb;
	static Deque<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		// 1. 인접행렬 이용하여 풂
		adjMatrix = new int[N+1][N+1];
		visited  = new int[N+1];
	
		// 인접한 정점 정보 입력
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjMatrix[a][b] = adjMatrix[b][a] = 1;
		}
		
		// 1) DFS
		sb.append(V+" ");
		dfs(V);
		
		sb.append("\n");
		// 2) BFS
		visited = new int[N+1];
		q.add(V);
		visited[V] = 1;
		sb.append(V + " ");
		bfs();
		
		System.out.println(sb);
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int cur = q.pollFirst();
			for(int i = 1; i<=N;i++) {
				if(adjMatrix[cur][i] == 0) continue;
				if(visited[i] != 0) continue;
				visited[i] = 1;
				sb.append(i + " ");
				q.add(i);
			}
		}
		
	}
	private static void dfs(int current) {
		visited[current] = 1;
		
		for(int i = 1; i<=N;i++) {
			if(adjMatrix[current][i] == 0) continue;
			if(visited[i] != 0) continue;
			sb.append(i + " ");
			dfs(i);
		}
	}
}
