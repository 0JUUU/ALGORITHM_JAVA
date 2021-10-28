import java.util.*;
import java.io.*;

/**
 * BOJ 9641 파도반 수열
 * 2021.10.28
 * : 100 체크 안했으면 long 떄문에 틀릴 뻔함
 * 항상 예외를 생각하자
 * @author 0JUUU
 *
 */
public class Main_BOJ_9461_파도반_수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long[] P = new long[101];
		P[1] = 1; P[2] = 1; P[3] = 1; P[4] = 2; P[5] = 2;
		for(int i = 6; i<=100; i++) {
			P[i] = P[i-1] + P[i-5];
		}
		for(int i = 0; i<T; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(P[num]+"\n");
		}
		
		System.out.println(sb);
	}
}
