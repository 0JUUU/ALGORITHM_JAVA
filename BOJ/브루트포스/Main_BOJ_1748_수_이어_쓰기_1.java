import java.util.*;
import java.io.*;
import java.math.BigInteger;

/**
 * BOJ 1748 수 이어 쓰기 1
 * 2021.02.14
 * @author 0JUUU
 *
 */
public class Main_BOJ_1748_수_이어_쓰기_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long N = Long.parseLong(br.readLine());
		long ans = 0;
		while(N != 0) {
			sb = new StringBuilder();
			sb.append(N);
			ans += (long) (N - Math.pow(10, sb.length() -1) + 1) * sb.length();
			long nine = (long)Math.pow(10, sb.length() -1) - 1;
			N = nine;
		}
	
		System.out.println(ans);
	}
}
