import java.util.*;
import java.io.*;

/**
 * BOJ 1309 동물원
 * 2021.03.01
 * : 1. DP 이용하여 풀이 --> 현재 칸의 왼쪽/오른쪽/아예 선택x의 경우를 나눠 합침 
 * @author 0JUUU
 *
 */
public class Main_BOJ_1309_동물원 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dp = new int[100001][3];
		dp[1][0] = 1; dp[1][1] = 1; dp[1][2] = 1;
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 2; i<=N;i++) {
			dp[i][0] = (dp[i-1][1] % 9901) + dp[i-1][2]% 9901;
			dp[i][1] = dp[i-1][0]% 9901 + dp[i-1][2]% 9901;
			dp[i][2] = dp[i-1][0]% 9901 + dp[i-1][1]% 9901 + dp[i-1][2]% 9901;
		}
		int sum = dp[N][0]% 9901 + dp[N][1]% 9901 + dp[N][2]% 9901;
		System.out.println(sum% 9901);
	}
}
