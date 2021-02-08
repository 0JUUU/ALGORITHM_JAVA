import java.util.*;
import java.io.*;

/**
 * BOJ 2579. 계단 오르기
 * 2021.02.09
 * SSAFY 스터디 DP
 * @author 0JUUU
 *
 */
public class Main_BOJ_2579_계단_오르기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] step = new int[N+1];
		int sum = 0;
		for(int i = 1; i<=N;i++) {
			step[i] = Integer.parseInt(br.readLine());
			sum += step[i];
		}
		if(N <= 3) {
			if(N == 3) {
				System.out.println(step[1] > step[2] ? step[3] + step[1] : step[3] + step[2]);
			} else System.out.println(sum);
			return;
		}
		int[] dp = new int[N+1];
		dp[1] = step[1]; dp[2] = step[1] + step[2]; dp[3] = step[1] > step[2] ? step[3] + step[1] : step[3] + step[2];
		
		for(int i = 4; i<=N;i++) {
			dp[i] = step[i] + step[i-1] + dp[i-3];	// i의 전 계단을 선택했을 경우
			dp[i] = dp[i] < step[i] + dp[i-2] ? step[i] + dp[i-2] : dp[i];	// i의 전 계단을 선택하지 않는 경우
		}
		System.out.println(dp[N]);
	}
}
