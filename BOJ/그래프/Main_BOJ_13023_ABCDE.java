import java.util.*;
import java.io.*;

/**
 * BOJ 13023 ABCDE
 * 2021.03.03
 * : dfs --> 시간 초과
 * @author 0JUUU
 *
 */
public class Main_BOJ_13023_ABCDE {
	static int N, M, count;
	static boolean isRight = false;
	static LinkedList<Integer> list = new LinkedList<Integer>();
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
				list.clear();
				list.addLast(i);
				dfs(i, relation);
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
			
			if(list.contains(next)) continue;
			list.addLast(next);
			dfs(next, relation + 1);
		}
		
		if(isRight) return;
	}

}

class People {
	int num;
	LinkedList<Integer> friends;
	
	public People() {
		super();
		friends = new LinkedList<>();
	}
}
