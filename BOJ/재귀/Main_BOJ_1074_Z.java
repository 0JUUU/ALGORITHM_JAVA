import java.util.*;
import java.io.*;

/**
 * BOJ 1074 Z 
 * 2021.02.16 
 * : 분할정복
 * : 1. 좌표 설정에서 오류가 있었음  /연산을 하는 것이 아닌 - 연산을 했어야 모든 경우를 예외 없이 처리할 수 있음
 * @author 0JUUU
 *
 */
public class Main_BOJ_1074_Z {
	static int N, r, c, sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		divide(N, r, c);
		System.out.println(sum);
	}

	static void divide(int N, int r, int c) {
		int len = (int)Math.pow(2, N);
		if(N == 0) {
			if(r == 0 && c == 0) sum += 0;
			if(r == 1 && c == 0) sum += 1;
			if(r == 0 && c == 1) sum += 2;
			if(r == 1 && c == 1) sum += 3;
			return;
		}
		if(r < len/2 && c < len/2) {
			sum += 0;
			divide(N-1, r, c);
		}
		else if(r <len/2 && c >=len/2) {
			sum += len * len / 4;
			divide(N-1, r, c - len/2);
		}
		else if(r >= len/2 && c <len/2) {
			sum += len * len / 4*2;
			divide(N-1, r-len/2, c);
		}
		else {
			sum += len * len / 4 * 3;
			divide(N-1, r - len/2, c - len/2);
		}

		return;
	}
}
