import java.util.*;
import java.io.*;

/**
 * BOJ 5557 1학년
 * 2021.08.07
 * : DP
 * @author 0JUUU
 *
 */
public class Main_BOJ_5557_1학년_2 {

	static int N;
	static int[] numbers;
	static long count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		long[][] calculate = new long[2][21];
		calculate[0][numbers[0]] = 1;
		for(int i = 1; i<N-1;i++) {
			int cur = numbers[i];
			for(int j = 0; j<21;j++) {
				if(calculate[0][j] == 0) continue;
				if(j + cur <= 20) {
					calculate[1][j+cur] += calculate[0][j];
				} 
				if(j - cur >= 0) {
					calculate[1][j-cur] += calculate[0][j];
				}
			}
			for(int j = 0; j<21;j++) {
				calculate[0][j] = calculate[1][j];
			}
			Arrays.fill(calculate[1], 0);
		}
		
		count = calculate[0][numbers[N-1]];
		System.out.println(count);
	}
}
