import java.util.*;
import java.io.*;

/**
 * BOJ 2688 줄어들지 않아
 * 2021.11.09
 * : DP 이용 -> N자리 수에서 첫자리가 0이라고 가정했을 때 N-1부터 1의 자리에 올 수 있는 수는 이전에 N-1자리일 때, 0~9의 값
 * @author 0JUUU
 *
 */
public class Main_BOJ_2688_줄어들지_않아 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long[] count = new long[65];
		long[][] each = new long[65][10];
		for(int i = 0; i<10; i++) {
			each[1][i] = 1;
		}
		
		for(int i = 2; i<= 64; i++) {
			for(int j = 0; j<10; j++) {
				for(int k = j; k < 10; k++) {
					each[i][j] += each[i-1][k];
				}
			}
		}
		
		for(int i = 1; i<=64; i++) {
			for(int j = 0; j<10; j++) {
				count[i] += each[i][j];
			}
		}
 		for(int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(count[num] + "\n");
		}
		
		System.out.println(sb);
	}
}
