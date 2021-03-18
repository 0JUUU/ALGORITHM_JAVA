import java.util.*;
import java.io.*;

/**
 * BOJ 10942 팰린드롬
 * 2021.03.18
 * : 미리 N개의 숫자의 팰린드롬 여부를 다 구한 후, 질문에 즉시 답할 수 있도록 한다. 
 * @author 0JUUU
 *
 */
public class Main_BOJ_10942_팰린드롬 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] number = new int[N+1];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i =1; i<=N;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		int[][] palindrome = new int[N+1][N+1];
		for(int i = 1; i<=N;i++) {
			for(int j = i; j<=N;j++) {
				if(i == j) palindrome[i][j] = 1;
				else if(j - i <= 2) {
					palindrome[i][j] = number[j] == number[i] ? 1 : 0;
				} else {
					boolean isPalin = true;
					for(int s = i, e = j; s < e; s++, e--) {
						if(number[s] != number[e]) {
							isPalin = false; break;
						}
					}
					if(isPalin) palindrome[i][j] = 1;
					else palindrome[i][j] = 0;
				}
			}
		}
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(palindrome[S][E] + "\n");
		}
		System.out.print(sb);
	}
}
