import java.util.*;
import java.io.*;

/**
 * BOJ 16202 MST 게임 
 * 2021.09.08
 * : 크루스칼 이용 => 시간이 줄어듦
 * 이전것이랑 비교했을 때 왜??
 * 
 * @author 0JUUU
 *
 */
public class Main_BOJ_16202_MST_게임3 {

	static class Vertex {
		int parent;
		
		public Vertex(int parent) {
			super();
			this.parent = parent;
		}
		
		@Override
		public String toString() {
			return "Vertex [parent=" + parent + "]";
		}
		
	}
	
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] edgesInfo = new int[M+1][2];

		parents = new int[N+1];
		ArrayList<int[]> adjList = new ArrayList<>();

		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edgesInfo[i][0] = a;
			edgesInfo[i][1] = b;
			adjList.add(new int[] {a, b, i});
		}
		
		while(K-- != 0) {
			int edgesSum = 0;
			
			for(int i = 1; i<=N;i++) {
				parents[i] = i;
			}

			int[] visited = new int[N+1];
			int sum = 0;
			int minEdgeCost = Integer.MAX_VALUE;
			int minEdgeIndex = -1;
			
			int count = 0;
			for(int[] v : adjList) {
				if(find(v[0]) != find(v[1])) {
					sum += v[2];
					union(v[0], v[1]);
					count++;
				}
			}
			
			if(count < N-1) {
				for(int j = 0; j<=K;j++) {
					sb.append(0 + " ");
				}
				break;
			} else {
				sb.append(sum + " ");
				adjList.remove(0);
			}
			// 간선 삭제
		}
		
		System.out.println(sb.substring(0, sb.length()-1));
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			if (a > b) parents[a] = b;
			else parents[b] = a;
		}
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
}
