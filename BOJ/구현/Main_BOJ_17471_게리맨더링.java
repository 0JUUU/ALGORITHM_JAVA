import java.util.*;
import java.io.*;

/**
 * BOJ 17471 게리맨더링 2021.04.16
 * : 예외처리를 함부로 해서는 안된다. (구역이 2개이고 서로 이어져있지않다면, 내가 생각한 예외(인접한 것이 없는 구역이 2개 이상이면 바로 -1 리턴) 에 위배된다.)
 * @author 0JUUU
 *
 */
public class Main_BOJ_17471_게리맨더링 {
	static int N, min = Integer.MAX_VALUE;
	static boolean[] set;
	static int[] population;
	static int[][] adjMatrix, copy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		population = new int[N];
		set = new boolean[N];
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		adjMatrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for (int c = 0; c < count; c++) {
				int num = Integer.parseInt(st.nextToken()) - 1;
				adjMatrix[i][num] = 1;
			}
		}
		
		makeSubset(0);
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

	private static void makeSubset(int cnt) {
		if (min == 0)
			return;
		if (cnt == N) {
			copy = new int[N][N];
			int sub = 0;
			int countA = 0;
			int countB = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					copy[i][j] = adjMatrix[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				if (set[i]) {
					sub += population[i];
					countA++;
				} else {
					sub -= population[i];
					countB++;
				}
			}

			if (countA == 0 || countB == 0)
				return;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (set[i] != set[j])
						copy[i][j] = 0;
				}
			}

			if (isConnected()) 
				min = min > Math.abs(sub) ? Math.abs(sub) : min;
			
			return;
		}

		set[cnt] = true;
		makeSubset(cnt + 1);

		if (min == 0)
			return;
		set[cnt] = false;
		makeSubset(cnt + 1);
		if (min == 0)
			return;

	}

	private static boolean isConnected() {
		// A : 1 (true) , B : 2 (false)
		int[] visited = new int[N];
		int startA = 0, startB = 0;
		for (int i = 0; i < N; i++) {
			if (set[i])
				startA = i;
			else
				startB = i;
		}
		visited[startA] = 1;
		visited[startB] = 2;

		Deque<Integer> q = new LinkedList<Integer>();
		q.add(startA);
		q.add(startB);
		while (!q.isEmpty()) {
			int cur = q.poll();
			int section = set[cur] ? 1 : 2;
			for (int i = 0; i < N; i++) {
				if (copy[cur][i] == 0)
					continue;
				if (visited[i] != 0)
					continue;
				if (set[cur] == set[i]) {
					visited[i] = section;
					q.add(i);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] == 0)
				return false;
			if (visited[i] == 1 && !set[i])
				return false;
			if (visited[i] == 2 && set[i])
				return false;
		}
		return true;
	}
}
