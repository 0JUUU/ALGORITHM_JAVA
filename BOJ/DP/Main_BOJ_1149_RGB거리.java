import java.util.*;
import java.io.*;

/**
 * BOJ 1149 RGB거리
 * 2021.02.09
 * SSAFY 스터디
 * @author 0JUUU
 *
 */
public class Main_BOJ_1149_RGB거리 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N+1][3];	// 0 : R 1: G 2:B
		int[][] dp = new int[N+1][3];
		for(int i = 1; i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3;j++) {
				house[i][j] = Integer.parseInt(st.nextToken());	
				if(i == 1) dp[i][j] = house[i][j];
			}
		}
		
		for(int i = 2; i<=N;i++) {
			for(int j = 0; j<3;j++) {
				dp[i][j] = house[i][j] + (dp[i-1][(j+1)%3] > dp[i-1][(j+2)%3]?dp[i-1][(j+2)%3]:dp[i-1][(j+1)%3] );
				
			}
		}
		Arrays.sort(dp[N]);
		System.out.println(dp[N][0]);
	}
}
