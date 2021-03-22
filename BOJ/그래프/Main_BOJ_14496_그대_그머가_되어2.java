import java.util.*;
import java.io.*;

/**
 * BOJ 14496 그대, 그머가 되어
 * 2021.03.22
 * : 2. 인접리스트로 구현
 * @author 0JUUU
 *
 */
public class Main_BOJ_14496_그대_그머가_되어2 {
	static class Node implements Comparable<Node>{
		int vertex; 
		int totalDistance;
		
		Node() {
			super();
		}
		
		Node(int vertex, int totalDistance) {
			this.vertex = vertex;
			this.totalDistance = totalDistance;
		}

		@Override
		public int compareTo(Node o) {
			return this.totalDistance - o.totalDistance;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b= Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] adjMatrix = new int[N+1][N+1];
		int[] D = new int[N+1];
		boolean[] visited = new boolean[N+1];
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjMatrix[x][y] = adjMatrix[y][x] = 1;
		}
		
		Arrays.fill(D, Integer.MAX_VALUE);
		D[a] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(a, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.vertex]) continue;
			
			visited[cur.vertex] = true;
			if(cur.vertex == b) break;
			
			for(int i = 1; i<=N;i++) {
				if(!visited[i] && adjMatrix[cur.vertex][i] != 0 && 
						D[i] > cur.totalDistance + adjMatrix[cur.vertex][i]) {
					D[i] = cur.totalDistance + adjMatrix[cur.vertex][i];
					pq.offer(new Node(i, D[i]));
				}
			}
		}
		
		if(D[b] != Integer.MAX_VALUE) System.out.println(D[b]);
		else System.out.println(-1);
	}
}
