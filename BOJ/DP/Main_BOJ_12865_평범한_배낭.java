import java.util.*;
import java.io.*;

/**
 * BOJ 12865 평범한 배낭
 * 2021.03.12
 * : 1. 부분집합은 안됨
 * : 2. 현재 구현한 코드는 같은 무게를 지닐 때는 할 수 없다. 
 * @author 0JUUU
 *
 */
public class Main_BOJ_12865_평범한_배낭 {
	static int N, K, sum, value;
	static int dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][K +1];

		for(int i =1; i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dp[i][a] = b;
		}
		
		for(int i = 1; i<=N;i++) {
			for(int j = 1; j<=K;j++) {
				
			}
		}
		
		System.out.println(dp[N][K]);     
	}

}

