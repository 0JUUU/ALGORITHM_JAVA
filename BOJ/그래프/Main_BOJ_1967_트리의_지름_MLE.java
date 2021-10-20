import java.util.*;
import java.io.*;

/**
 * BOJ 1967 트리의 지름
 * 2021.10.20
 * : 다익스트라 -> 메모리 초과
 * @author 0JUUU
 *
 */

public class Main_BOJ_1967_트리의_지름_MLE {

	static class Edge implements Comparable<Edge> {
		int num;
		int weight;
		Edge(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Edge [num=" + num + ", weight=" + weight + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Edge>[] adjList = new ArrayList[n+1];
		for(int i = 1; i<=n; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i = 1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int sibling = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[parent].add(new Edge(sibling, weight));
			adjList[sibling].add(new Edge(parent, weight));
		}
		
		int max = 0;
		for(int i = 1; i<n; i++) {
			// 시작점 설정
			int start = i;
			int[] dijkstra = new int[n+1];
			boolean[] visited = new boolean[n+1];
			Arrays.fill(dijkstra, Integer.MAX_VALUE);
			dijkstra[start] = 0;
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(start, 0));
			while(!pq.isEmpty()) {
				Edge cur = pq.poll();
				if(visited[cur.num]) continue;
				visited[cur.num] = true;
				
				for(Edge next : adjList[cur.num]) {
					if(!visited[next.num] && dijkstra[next.num] > cur.weight + next.weight) {
						dijkstra[next.num] = cur.weight + next.weight;
						pq.add(new Edge(next.num, dijkstra[next.num]));
					}
				}
			}
			
			for(int j = i+1; j<=n; j++) {
				if(dijkstra[j] != Integer.MAX_VALUE) {
					max = dijkstra[j] > max ? dijkstra[j] : max;
				}
			}
		}
		
		System.out.println(max);
	}
}
