import java.util.*;
import java.io.*;

/**
 * BOJ 14938 서강그라운드
 * 2021.03.24
 * : 어디에 떨어지는지? 와 다익스트라 알고리즘을 이용 --> 시작정점을 바꿔가며 각 정점에 갈 수 있는 최단 경로를 구한다. 
 * @author 0JUUU	
 *
 */

public class Main_BOJ_14938_서강그라운드 {
	static class Node implements Comparable<Node> {
		int vertex;
		int totalDist;
		
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] item = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n;i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<int[]>[] adjList = new ArrayList[n+1];
		for(int i = 0; i<=n;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		int max = Integer.MIN_VALUE;
		// 연결된 마을 정보
		for(int i = 0; i<r;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			adjList[a].add(new int[] {b,l});
			adjList[b].add(new int[] {a,l});
		}
		
		// 시작 정점을 1부터 n까지 돌려봄? 시간초과 안나니?
		for(int i = 1 ; i<=n;i++) {
			int start = i;
			boolean[] visited = new boolean[n+1];
			int[] dist = new int[n+1];
			Arrays.fill(dist, 987654321);
			dist[start] = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(start, 0));
		
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(visited[cur.vertex]) continue;
				visited[cur.vertex] = true;
				if(cur.totalDist > m) break;
				
				for(int c = 0; c<adjList[cur.vertex].size();c++) {
					int[] next = adjList[cur.vertex].get(c);
					if(!visited[next[0]] && dist[next[0]] > cur.totalDist + next[1]) {
						dist[next[0]] = cur.totalDist + next[1];
						pq.offer(new Node(next[0], dist[next[0]]));
					}
				}
			}
			
			int sum = 0;
			for(int j = 1; j<=n;j++) {
				if(dist[j] <= m) sum += item[j];
			}
			
			max = sum > max ? sum : max;
		}
		System.out.println(max);
	}
}
