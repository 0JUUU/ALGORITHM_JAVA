import java.util.*;
import java.io.*;

/**
 * BOJ 2023 신기한 소수
 * 2021.03.16
 * : 1. 에라토스테네스의 체를 이용하여 구함 --> 메모리 초과
 * : 2. dfs를 이용하여 첫번째 자리부터 N번째 자리까지 가능한 수들을 확인하며 구하였음
 * @author 0JUUU
 *
 */
public class Main_BOJ_2023_신기한_소수2 {
	static int N;
	static ArrayList<Integer> answer = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			sb.append(2 +"\n");
			sb.append(3+"\n");
			sb.append(5+"\n");
			sb.append(7+"\n");
			System.out.println(sb);
			return;
		}
		for(int i = 1; i<= 9; i++) {
			if(i == 2  || i == 3 || i == 5 || i == 7) dfs(1, i);
		}
		
		for(int i = 0; i<answer.size();i++) {
			sb.append(answer.get(i) + "\n");
		}
		System.out.print(sb);
	}

	private static void dfs(int cnt, int before) {
		if(cnt == N) {
			answer.add(before);
			return;
		}
		for(int i = 1; i<=9;i++) {
			if(i == 1 || i == 3|| i == 5||i == 7||i == 9) {
				int number = before*10 + i;     
				if(checkPrime(number)) dfs(cnt+1, number);
			}
		}
		
	}
	
	private static boolean checkPrime(int number) {
		for(int i = 2; i< number; i++) {
			if(number % i == 0) return false;
		}
		return true;
	}
}
