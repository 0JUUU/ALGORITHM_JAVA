import java.util.*;
import java.io.*;

/**
 * BOJ 1929. 소수 구하기
 * 2021.02.04
 * : 코딩방범대 수학
 * @author 0JUUU
 * : 1. M과 N 사이의 수들을 1~N/2까지 모두 나눠서 구하려고 했음 --> 시간초과
 * : 2. 그러면, 2부터 증가하면서 N까지 그 증가하는 수의 배수들을 모두 X처리 같은 표식을 해줌 --> 후에 표식이 되지 않은 수만 출력(에라토스테네스의 체 : 소수 구할 때 중요한가봄) 
 */
public class Main_BOJ_1929_소수_구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] isNotPrime = new boolean[1000001];
		isNotPrime[1] = true;
		for(int i = 2;i<=N;i++) {
			for(int j = 2; i*j<=N;j++) {
				isNotPrime[i*j] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = M; i<=N;i++) {
			if(!isNotPrime[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
