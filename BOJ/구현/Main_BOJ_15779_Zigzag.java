import java.util.*;
import java.io.*;

public class Main_BOJ_15779_Zigzag {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[][] dp = new int[3][N];
		dp[0][0] = 1; dp[1][0] = 1; dp[2][0] = 1;
		
		int max = 1;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i == 0) continue;
			if(arr[i-1] < arr[i]) {
				dp[1][i] = dp[1][i-1] + 1;
				dp[2][i] = 1;
			} else if(arr[i-1] > arr[i]) {
				dp[2][i] = dp[2][i-1] + 1;
				dp[1][i] = 1;
			} else {
				dp[1][i] = dp[1][i-1] + 1;
				dp[2][i] = dp[2][i-1] + 1;
			}
			
			if(dp[1][i] >= 3 || dp[2][i] >= 3) {
				dp[0][i] = 2;
			} else {
				dp[0][i] = dp[0][i-1] + 1;
			}
			
			if(max < dp[0][i])
				max = dp[0][i];
		}
		
		System.out.println(max);
	}
}
