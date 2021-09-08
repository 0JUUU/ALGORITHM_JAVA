import java.util.*;
import java.io.*;

/**
 * BOJ 16202 MST 게임 
 * 2021.09.08
 * : 프림 이용 => 시간초과 (why? 프림에서 for문 여러번 돌려서)
 * : 결국에는 프림으로 풀어서 통과
 * @author user
 *
 */
public class Main_BOJ_16202_MST_게임 {

	static class Vertex implements Comparable<Vertex>{
		int num;
		int cost;
		Vertex(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.cost - o.cost;
		}
		@Override
		public String toString() {
			return "Vertex [num=" + num + ", cost=" + cost + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] edgesInfo = new int[M+1][2];
		ArrayList<Vertex>[] edges = new ArrayList[N+1]; 
		for(int i = 1; i<=N;i++) {
			edges[i] = new ArrayList<>();
		}
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edgesInfo[i][0] = a;
			edgesInfo[i][1] = b;
			edges[a].add(new Vertex(b, i));
			edges[b].add(new Vertex(a, i));
		}
		
		
		while(K-- != 0) {
			int edgesSum = 0;
			if((M--) < N-1) {
				sb.append(0+" ");
				continue;
			}
			
			// 전체 MST 비용 최소로 하는 루트 찾기
			int minCost = Integer.MAX_VALUE;
			int edgeOfMinCost = 0;
			// 시작점 0 ~ N까지 다해보기
			int start = 1;
			int[] visited = new int[N+1];
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.add(new Vertex(start, 0));
			int sum = 0;
			int minEdge = Integer.MAX_VALUE;
			while(!pq.isEmpty()) {
				Vertex cur = pq.poll();
				int curNum = cur.num;
				int curCost = cur.cost;
				if(visited[curNum] != 0) continue;
				visited[curNum] = 1;
				if(start != curNum) {	// 간선 정보 저장
					minEdge = curCost < minEdge ? curCost : minEdge;
					sum += curCost;
				}
				for(int j = 0; j<edges[curNum].size();j++) {
					Vertex next = edges[curNum].get(j);
					if(visited[next.num] != 0) continue;
					pq.add(new Vertex(next.num, next.cost));
				}
			}
			for(int j = 1; j<=N;j++) {
				if(visited[j] == 0) {
					sum = Integer.MAX_VALUE;
					break;
				}
			}
			if(sum < minCost) {
				minCost = sum;
				edgeOfMinCost = minEdge;
			}
			
			if(minCost == Integer.MAX_VALUE) {
				sb.append(0 + " ");
			} else {
				edgesSum = minCost;
				// 가장 적은 비용의 MST에 포함된 간선 중 가장 가중치가 작은 것의 값
				int a = edgesInfo[edgeOfMinCost][0];
				int b = edgesInfo[edgeOfMinCost][1];
				int aIndex = 0, bIndex = 0;
				for(int i = 0; i<edges[a].size();i++) {
					if(edges[a].get(i).cost == edgeOfMinCost) aIndex = i;
				}
				
				for(int i = 0; i<edges[b].size();i++) {
					if(edges[b].get(i).cost == edgeOfMinCost) bIndex = i;
				}
				
				edges[a].remove(aIndex);
				edges[b].remove(bIndex);
				
				sb.append(edgesSum + " ");
			}

		}
		
		System.out.println(sb.substring(0, sb.length()-1));
	}
}
