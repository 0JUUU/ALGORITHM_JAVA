import java.util.*;
import java.io.*;

/**
 * BOJ 15990 1,2,3 더하기 5
 * 2021.09.08
 * : 1. DFS (재귀) => TLE
 * : 2. DP 이용 => 각각 마지막이 1, 2, 3일 경우의 전은 (2,3) / (1,3) / (1,2) 라는 점 이용
 * @author user
 *
 */
public class Main_BOJ_15990_123더하기_5 {

	static int n;
	static long[][] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		num = new long[100001][4];
		num[1][1] = 1;
		num[2][2] = 1;
		num[3][1] = 1;
		num[3][2] = 1;
		num[3][3] = 1;
		for(int i = 4; i<=100000;i++) {
			long one = (num[i-1][2] + num[i-1][3]) % 1000000009;
			long two = (num[i-2][1] + num[i-2][3]) % 1000000009;
			long three = (num[i-3][1] + num[i-3][2]) % 1000000009;
			
			num[i][1] = one;
			num[i][2] = two;
			num[i][3] = three;
		}
		for(int i = 0; i<T;i++) {
			n = Integer.parseInt(br.readLine());
			
			long sum = (num[n][1] + num[n][2]+num[n][3])% 1000000009;
			sb.append(sum+"\n");
			//System.out.println(num[n]);
		}
		System.out.println(sb);
	}
	
}
