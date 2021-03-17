import java.util.*;
import java.io.*;

/**
 * BOJ 1976 여행 가자
 * 2021.03.17
 * : 같은 부모를 같는지 확인할 때, parent는 바뀌지않은 상태로 연결되있을 수 있다.
 * : 그러므로 부모 같은지를 확인할 때는 꼭 find() 함수를 사용해야한다. 
 * : union-find 를 정말 꼭 기억해두자.
 * @author 0JUUU
 *
 */
public class Main_BOJ_1976_여행_가자 {
	static int N, M;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		parent = new int[N+1];
		for(int i = 1; i<=N;i++) {		// 초기, 자기 자신을 부모로
			parent[i] = i;
		}
		for(int i = 1; i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N;j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 1) union(i, j);
			}
		}
		
		int[] route = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M;i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean isAvail = true;
		int root = find(route[0]);
		for(int i = 1; i<M;i++) {
			if(root !=  find(route[i])) {
                isAvail = false;
                break;
            }
		}
		
		if(isAvail) System.out.println("YES");
		else System.out.println("NO");
	}
	
	private static int find(int i) {
		if(i == parent[i]) {
			return i;
		}
		return parent[i] = find(parent[i]);
	}
	
	private static void union(int i, int j) {
		i = parent[i];
		j = parent[j];
		
		if(i == j) return;
		if(i > j) {
			parent[i] = j;
		} else if(j > i) {
			parent[j] = i;
		}
	}
}
