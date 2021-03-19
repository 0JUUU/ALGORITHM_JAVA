import java.util.*;
import java.io.*;

/**
 * BOJ 1800
 * 2021.03.19
 * : bfs로 조건을 탐색한 후, 부합하면 dfs로 확인 --> TLE
 * @author 0JUUU
 *
 */
public class Main_BOJ_1800_인터넷_설치 {
	static int N, P, K, min = Integer.MAX_VALUE;
	static int[] visited, costInt, bfsVisited;
	static ArrayList<Integer> cost = new ArrayList<>();
	static Deque<Integer> q = new LinkedList<Integer>();
	static int[][] adjMatrix;
	static boolean isConnected = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N+1][N+1];
		visited = new int[N+1];
		for(int i = 0; i<P;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			adjMatrix[a][b] = val;
			adjMatrix[b][a] = val;
		}
		
		costInt = new int[P+1];
		if(adjMatrix[1][N] != 0 && K != 0) System.out.println(0);
		else {
			q.offer(1);
			bfsVisited = new int[N+1];
			bfsVisited[1]= 0;
			bfs();
			if(bfsVisited[N] == 0) {
				System.out.println(-1);
				return;
			} else if(bfsVisited[N] <= K) {
				System.out.println(0);
				return;
			}
			visited[1] = 1;
			dfs(1, 0);
			if(isConnected)System.out.println(min);
			else System.out.println(-1);
		}
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			int cur = q.pollFirst();
			for(int i = 2; i<=N;i++) {
				if(adjMatrix[cur][i] == 0) continue;
				if(bfsVisited[i] != 0) continue;
				bfsVisited[i] = bfsVisited[cur]+1;
				q.offer(i);
			}
		}
	}
	private static void dfs(int vertex, int cnt) {
		if(min == 0) return;
		if(vertex == N) {
			if(cnt <= K) {
				min = 0;
				isConnected = true;
				return;
			}
			for(int i = 0; i<cnt;i++) {
				cost.add(costInt[i]);
			}
			Collections.sort(cost, Collections.reverseOrder());
//			int[] costInt = Arrays.stream(cost).mapToInt(Integer::intValue).toArray();
			min = min > cost.get(K) ? cost.get(K) : min;
			isConnected = true;
			cost.clear();
			return;
		}
		for(int i = 1; i<=N;i++) {
			if(adjMatrix[vertex][i] == 0) continue;
			if(visited[i] != 0) continue;
			costInt[cnt] = adjMatrix[vertex][i];
			visited[i] = 1;
			dfs(i, cnt+1);
			visited[i] = 0;
//			cost.remove(cost.size()-1);
			costInt[cnt] = 0;
		}
		if(min == 0) return;
	}
}
