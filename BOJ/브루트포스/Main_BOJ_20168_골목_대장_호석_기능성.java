import java.util.*;
import java.io.*;

/**
 * BOJ 20168 골목 대장 호석 - 기능성
 * 2021.10.19
 * : 10/18 => max 값을 갱신한 것을 그 다음에서도 사용했던 것이 문제였다 (like 조합에서 cnt++하는 것처럼)
 * : 18/18 => 
 * @author 0JUUU
 *
 */
public class Main_BOJ_20168_골목_대장_호석_기능성 {
	static int N, M, A, B,C;
	static int[][] map;
	static int[] visited;
	static PriorityQueue<Path> pq;
	static class Path implements Comparable<Path> {
		int sum;
		int max;
		Path(int sum, int max) {
			this.sum = sum;
			this.max = max;
		}
		@Override
		public int compareTo(Path o) {
			int gap = this.max - o.max;
			return gap == 0 ? this.sum - o.sum : gap;
		}
		@Override
		public String toString() {
			return "Path [sum=" + sum + ", max=" + max + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visited = new int[N+1];
		pq = new PriorityQueue<>();
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());
			map[one][two] = fee;
			map[two][one] = fee;
		}
		
		dfs(A, 0, 0);
		if(pq.isEmpty()) System.out.println("-1");
		else {
			while(!pq.isEmpty()) {
				Path cur = pq.poll();
				if(C >= cur.sum) {
					System.out.println(cur.max);
					return;
				}
			}
			System.out.println("-1");
		}	
	}
	
	private static void dfs(int now, int sum, int max) {
		if(now == B) {
			pq.add(new Path(sum, max));
			return;
		}
		
		for(int i = 1; i<=N; i++) {
			if(map[now][i] == 0) continue;
			if(visited[i] != 0) continue;
			if(sum + map[now][i] <= C) {
				visited[i] = 1;
				dfs(i, sum + map[now][i], Math.max(max,  map[now][i]));
				visited[i] = 0;
			}

		}
	}
}
