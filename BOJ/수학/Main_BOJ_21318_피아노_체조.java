import java.util.*;
import java.io.*;

/**
 * BOJ 21318 피아노 체조
 * 2021.09.20
 * 앞보다 작을 경우 1로 표기하고 그 합을 계산 => TLE
 * Sn => 1 ~ n 까지 경우
 * Sn - Sn-x =>  n-x ~ n 까지의 경우
 * : 누적합
 * @author 0JUUU
 *
 */
public class Main_BOJ_21318_피아노_체조 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int[] q = new int[100001];
		int[] quality = new int[N+1];
		int[] compare = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			quality[i] = Integer.parseInt(st.nextToken());
			if(i == 1) continue;
			compare[i] = quality[i] >= quality[i-1] ? 0 : 1;
			q[i] += compare[i] + q[i-1];
		}
		
		int Q = Integer.parseInt(br.readLine());
		int beforeX = -1, beforeY = -1;
		for(int i = 0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			

			sb.append(q[y] - q[x] + "\n");
		}
		System.out.println(sb);
	}
}
