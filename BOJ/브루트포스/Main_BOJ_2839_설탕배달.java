import java.util.*;
import java.io.*;

public class Main_BOJ_2839_설탕배달 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[5001];
		dp[1] = -1; dp[2] = -1; dp[3] = 1; dp[4] = -1; dp[5] = 1;
		if(N <= 5) System.out.println(dp[N]);
		else {
			for(int i = 6; i<=N;i++) {
				int other5 = i - 5; int other3 = i - 3;
				if(dp[other5] == -1 && dp[other3] == -1) dp[i] = -1;
				else if(dp[other5] == -1) dp[i] = dp[3] + dp[other3];
				else if(dp[other3] == -1) dp[i] = dp[5] + dp[other5];
				else {
					dp[i] = dp[3] + dp[other3] < dp[5] + dp[other5] ? dp[3] + dp[other3] : dp[5] + dp[other5];			
				}
			}
			System.out.println(dp[N]);
		}
	}
}
