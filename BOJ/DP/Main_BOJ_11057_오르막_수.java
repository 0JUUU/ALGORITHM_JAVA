import java.util.*;
import java.io.*;

/**
 * BOJ 11057 오르막 수
 * 2021.03.02
 * : DP를 이용한 풀이
 * @author 0JUUU
 *
 */
public class Main_BOJ_11057_오르막_수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][10];
		for(int i = 0; i<10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i<=N;i++) {
			for(int j =0; j<10;j++) {
				for(int k = j; k<10;k++) {
					dp[i][j] += dp[i-1][k] % 10007;
				}
			}
		}
		
		int sum = 0;
		for(int i = 0; i<10;i++) {
			sum += dp[N][i] % 10007;
		}
		System.out.println(sum % 10007);
	}
}

