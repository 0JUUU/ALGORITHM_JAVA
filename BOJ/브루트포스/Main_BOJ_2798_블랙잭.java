import java.util.*;
import java.io.*;

/***
 * BOJ 2798 블랙잭
 * 2021.02.24
 * 
 * @author 0JUUU
 *
 */
public class Main_BOJ_2798_블랙잭 {
	static int N, M;
	static int[] card, three;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		three = new int[3];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ;i<N;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		makeCombination(0,0);
		System.out.println(max);
	}
	
	private static void makeCombination(int cnt, int start) {
		if(cnt == 3) {
			int sum = 0;
			for(int i = 0; i<3;i++) sum += three[i];
			if(sum < M) {
				max = max < sum ? sum : max;
			} else if(sum == M) {
				max = M;
				return;
			}
			return;
		}
		for(int i = start;i<N;i++) {
			three[cnt] = card[i];
			makeCombination(cnt+1, i+1);
			if(max == M) return;
		}
	}
}
