import java.util.*;
import java.io.*;

/**
 * BOJ 1197 최소 스패닝 트리
 * 2021.03.26
 * : Prim & 인접리스트 & 우선순위큐
 * @author 0JUUU
 *
 */
public class Main_BOJ_1197_최소_스패닝_트리 {
	static class Node implements Comparable<Node> {
		int vertex;
		long dist;
		public Node(int vertex, long dist) {
			super();
			this.vertex = vertex;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			return (int) (this.dist - o.dist);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] adjList = new ArrayList[V+1];
		for(int i = 0; i<=V;i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i = 0; i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			adjList[from].add(new Node(to, edge));
			adjList[to].add(new Node(from, edge));
		}
		
		long[] minEdge = new long[V+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		minEdge[1] = 0;
		pq.offer(new Node(1,0));
		long sum = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.vertex]) continue;
			visited[cur.vertex] = true;
			sum += cur.dist;
			
			for(int j = 0; j<adjList[cur.vertex].size();j++) {
				Node next = adjList[cur.vertex].get(j);
				if(!visited[next.vertex] && minEdge[next.vertex] > next.dist) {
					minEdge[next.vertex] = next.dist;
					pq.add(new Node(next.vertex, minEdge[next.vertex]));
				}
			}
		}
		
		System.out.println(sum);
	}
}
