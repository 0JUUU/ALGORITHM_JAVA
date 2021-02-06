import java.util.*;
import java.io.*;

/**
 * BOJ 6588. 골드바흐의 추측
 * 2021.02.04
 * 코딩방범대 수학
 * @author 0JUUU
 * 
 */
public class Main_BOJ_6588_골드바흐의_추측 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] isNotPrime = new boolean[1000001];
		isNotPrime[1] = true;
		for(int i = 2; i<=1000000;i++) {
			for(int j = 2; i * j <=1000000; j++) {
				isNotPrime[i*j] = true;
			}
		}
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			boolean find = false;
			int small = 0, big = 0;
			int j = 0;
			for(int i = 3; i < n;i++) {
				j = n - i;
				if(!isNotPrime[i] && !isNotPrime[j]) {
					small = i; big = j; find = true; break;
				}
				if(j < i) break;
				if(small != 0 && big != 0) break;
			}
			if(!find) sb.append("Goldbach's conjecture is wrong.\n");
			else sb.append(n).append(" = ").append(small).append(" + ").append(big).append("\n");
		}// while문
		System.out.println(sb);
	}
}
