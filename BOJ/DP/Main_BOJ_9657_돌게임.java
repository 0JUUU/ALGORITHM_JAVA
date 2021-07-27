import java.util.*;
import java.io.*;

/**
 * BOJ 9657 돌게임
 * 2021.03.06 -> 2021.07.28
 * : DP로 접근 
 * : 처음 WA => four 부분에  %2를 넣지 않음 
 * @author 0JUUU
 *
 */
public class Main_BOJ_9657_돌게임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];	// 1 : 상근 / 2: 창영
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 1;
		dp[4] = 1;
		dp[5] = 1;
		dp[6] = 1;
		dp[7] = 2;
		
		for(int i = 8; i<=N;i++) {
			int one = 1 + dp[i-1];
			int three = 1 + dp[i-3];
			int four = 1 + dp[i-4];
			//System.out.println(i + " -> one : " + one + ", three : " + three + ", four :" + four);
			if(one % 2 != 1 && three % 2 != 1 && four % 2 != 1) {
				dp[i] = 2;
			} else dp[i] = 1;
		}
		
		System.out.println(dp[N] == 1 ? "SK" : "CY");
		
	}
}
