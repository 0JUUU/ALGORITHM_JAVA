import java.util.*;
import java.io.*;

/**
 * BOJ 1757 달려달려
 * 2021.10.24
 * : TLE => 브루트포스? DFS
 * @author 0JUUU
 *
 */
public class Main_BOJ_1757_달려달려 {

	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		max = Integer.MIN_VALUE;
		int[] D = new int[N+1];
		for(int i = 1; i<=N; i++) {
			D[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(1, 0, 0, D, N, M);
		System.out.println(max);
	}

	private static void dfs(int start, int sum, int m, int[] D, int N, int M) {
		if(m != 0 && N- start+1 < m) 
			return;
		if(start > N) {
			max = sum > max ? sum : max;
			return;
		}
		// 지금 현재 start를 선택해? 안해?
		if(m == 0) {
			// 선택 안해
			dfs(start+1, sum, m, D, N, M);
			if(m <= M) {
				dfs(start+1, sum + D[start], m+1, D, N, M);
			}
		} else {
			// 한번 쉬면 계속 쉬어야함
			dfs(start+m, sum, 0, D, N, M);
			if(m <= M) {
				dfs(start+1, sum + D[start], m+1, D, N, M);
			}
		}
	}
}
