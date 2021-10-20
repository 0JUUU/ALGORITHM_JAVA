import java.util.*;
import java.io.*;

/**
 * BOJ 1967 트리의 지름
 * 2021.10.20
 * : BFS를 시작점을 n번 바꿔서 하니까 => MLE
 * : 가장 큰 가중치를 갖는 리프노드 찾아서 거기를 시작점으로 지정하니까 메모리초과 해결
 * : BFS -> start값 -1로 초기화 => ArrayIndex 나옴
 * :	-> start를 1로 초기화해서 해결
 * 
 * @author 0JUUU
 *
 */

public class Main_BOJ_1967_트리의_지름 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<int[]>[] adjList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int sibling = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[parent].add(new int[] { sibling, weight });
			adjList[sibling].add(new int[] { parent, weight });
		}

		int start = 1, maxValue = 0;;
		LinkedList<Integer> q = new LinkedList<>();
		q.add(1);
		int[] visited = new int[n + 1];
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int[] next : adjList[cur]) {
				if (visited[next[0]] != 0)
					continue;
				visited[next[0]] = visited[cur] + next[1];
				if(visited[next[0]] > maxValue) {
					maxValue = visited[next[0]];
					start = next[0];
				}
				q.add(next[0]);
			}
		}
		
		int max = 0;
		visited = new int[n + 1];
		Arrays.fill(visited, Integer.MAX_VALUE);
		q.add(start);
		visited[start] = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int[] next : adjList[cur]) {
				if (visited[next[0]] != Integer.MAX_VALUE)
					continue;
				visited[next[0]] = visited[cur] + next[1];
				q.add(next[0]);
			}
		}

		for (int j = 1; j <= n; j++) {
			max = visited[j] > max ? visited[j] : max;
		}

		System.out.println(max);
	}
}
