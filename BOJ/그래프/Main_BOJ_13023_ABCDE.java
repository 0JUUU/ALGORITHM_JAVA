import java.util.*;
import java.io.*;

/**
 * BOJ 13023 ABCDE
 * 2021.03.03
 * : 1. dfs & 방문한 사람 (linkedlist) & person의 친구 (linkedlist) --> 시간 초과
 * : 2. dfs & 방문한 사람 (배열) --> 시간 초과
 * : 3. dfs & 방문한 사람(linkedlist) & dfs 돌리는 것을 2차원 배열 --> 더욱더 시간초과
 * : 4. dfs & 방문한 사람(배열) & person의 친구 (ArrayList) --> 통과
 * --> ArrayList와 LinkedList는 add 에서는 속도 차이가 거의 없지만
 * !!!!!!!!!!개중요!!!!!!!! get에서는 ArrayList가 훨씬 더 빠른 속도를 가짐!
 * @author 0JUUU
 *
 */
public class Main_BOJ_13023_ABCDE {
	static int N, M, count;
	static boolean isRight = false;
	static int[] visited;
	static People[] people;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		people = new People[N];
		visited = new int[N];
		for(int i = 0; i<N;i++) {
			people[i] = new People();
		}
		
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			people[a].friends.add(b);
			people[b].friends.add(a);
		}
		
		if(M < 4) isRight = false;		// 4 미만이면, 관게가 제시된 것보다 작다는 것을 바로 알 수 있음
		else {
			for(int i = 0; i<N;i++) {
				int relation = 0;
				
//				list.clear();
//				list.addLast(i);
				visited[i] = 1;
				dfs(i, relation);
				visited[i] = 0;
				if(isRight) break;
			}
		}
		
		// 정답 출력
		if(isRight) System.out.println(1);
		else System.out.println(0);
	}
	private static void dfs(int start, int relation) {
		int next;
		if(isRight) return;
		if(relation == 4) {
			isRight = true;
			return;
		}
		for(int i = 0; i<people[start].friends.size();i++) {
			next = people[start].friends.get(i);
			
			if(visited[next] != 0) continue;
			visited[next] = 1;
			dfs(next, relation + 1);
			if(isRight) break;
			visited[next] = 0;
		}
		
		if(isRight) return;
	}

}

class People {
	int num;
	ArrayList<Integer> friends;
	
	public People() {
		super();
		friends = new ArrayList<>();
	}
}
