import java.util.*;
import java.io.*;

public class Main_BOJ_2253_점프 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] stones = new int[N+1];

		for(int i = 0; i < M; i++) {
			int small = Integer.parseInt(br.readLine());
			stones[small] = -1;
		}
		
		int[][] dp = new int[N+1][142];
		for(int i = 0; i<=N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		dp[1][0] = 0;
		for(int i = 2; i<= N; i++) {
			if(stones[i] == -1) continue;
			int v = 1;
			while(v * (v+1) / 2 <= i) {
				if(dp[i-v][v+1] != Integer.MAX_VALUE && dp[i-v][v] != Integer.MAX_VALUE && dp[i-v][v-1] != Integer.MAX_VALUE) {
					dp[i][v] = Math.min(dp[i-v][v+1], Math.min(dp[i-v][v], dp[i-v][v-1])) + 1;
				} else if(dp[i-v][v+1] != Integer.MAX_VALUE && dp[i-v][v] != Integer.MAX_VALUE) {
					dp[i][v] = Math.min(dp[i-v][v+1], dp[i-v][v]) + 1;
				} else if(dp[i-v][v] != Integer.MAX_VALUE && dp[i-v][v-1] != Integer.MAX_VALUE) {
					dp[i][v] = Math.min(dp[i-v][v], dp[i-v][v-1]) + 1;
				} else if(dp[i-v][v+1] != Integer.MAX_VALUE && dp[i-v][v-1] != Integer.MAX_VALUE) {
					dp[i][v] = Math.min(dp[i-v][v+1], dp[i-v][v-1]) + 1;
				} else if(dp[i-v][v+1] != Integer.MAX_VALUE) {
					dp[i][v] = dp[i-v][v+1] + 1;
				} else if(dp[i-v][v] != Integer.MAX_VALUE) {
					dp[i][v] = dp[i-v][v] + 1;
				} else if(dp[i-v][v-1] != Integer.MAX_VALUE) {
					dp[i][v] = dp[i-v][v-1] + 1;
				}
	
				v += 1;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<142; i++) {
			if(min > dp[N][i]) {
				min = dp[N][i];
			}
		}
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
}
