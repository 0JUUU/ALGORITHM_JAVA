import java.util.*;
import java.io.*;

/**
 * BOJ 18352 특정 거리의 도시 찾기
 * 2021.03.22
 * : 인접리스트 이용 ---> get을 많이 할 때는 linkedlist 대신 arraylist를 쓰자 꼭 기억해라.
 * @author 0JUUU
 *
 */
public class Main_BOJ_18352_특정_거리의_도시_찾기 {
	static class Node implements Comparable<Node> {
		int vertex;
		int totalDist;
		Node() {
			super();
		}
		public Node(int vertex, int totalDist) {
			super();
			this.vertex = vertex;
			this.totalDist = totalDist;
		}
		@Override
		public int compareTo(Node o) {
			return this.totalDist - o.totalDist;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
//		int[][] adjMatrix = new int[N+1][N+1];
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		for(int i = 0; i<=N;i++) {
			adjList[i] = new ArrayList<>();
		}
		int[] D = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			adjList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
//			adjMatrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		Arrays.fill(D, Integer.MAX_VALUE);
		D[X] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.vertex]) continue;
			
			visited[cur.vertex] = true;
			
			for(int i = 0; i<adjList[cur.vertex].size();i++) {
				int next = adjList[cur.vertex].get(i);
				if(!visited[next] && D[next] > cur.totalDist + 1) {
					D[next] = cur.totalDist + 1;
					pq.offer(new Node(next, D[next]));
				}
			}
		}
		
		for(int i =1; i<=N;i++) {
			if(D[i] == K) sb.append(i + "\n");
		}
		
		if(sb.length() == 0) System.out.println(-1);
		else System.out.print(sb);
	}
}
