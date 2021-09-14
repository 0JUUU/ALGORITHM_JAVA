import java.util.*;
import java.io.*;

/**
 * BOJ 18427 함께 블럭 쌓기
 * 2021.09.14
 * DP 이용
 * @author 0JUUU
 *
 */
public class Main_BOJ_18427_함께_블럭_쌓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N, M, H;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int[][] blocks = new int[N][];
		int[] dp = new int[5001];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = st.countTokens();
			blocks[i] = new int[cnt];
			for(int j = 0; j<cnt;j++) {
				blocks[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0] = 1;
		for(int i = 0, size = blocks[0].length; i<size; i++) {
			dp[blocks[0][i]]++;
		}
		
		for(int i = 1; i<N; i++) {
			int size = blocks[i].length;
			int[] tmpH = new int[H+1];
			for(int j = 0; j < size; j++) {
				int num = blocks[i][j];
				int beforeSize = blocks[i-1].length;
				if(num > H) continue;
				if(H-num < 0) continue;
				for(int k = num; k<=H; k++) {
					tmpH[k] += dp[k-num];
					tmpH[k] %= 10007;
				}
			}
			for(int j = 0; j<=H;j++) {
				dp[j] += tmpH[j];
				dp[j] %= 10007;
			}
		}
		System.out.println(dp[H]);
	}
}
