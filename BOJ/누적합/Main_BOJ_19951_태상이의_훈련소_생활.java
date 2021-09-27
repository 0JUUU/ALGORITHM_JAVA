import java.util.*;
import java.io.*;

/**
 * BOJ 19951 태상이의 훈련소 생활
 * 2021.09.27
 * : 누적합
 * @author 0JUUU
 *
 */
public class Main_BOJ_19951_태상이의_훈련소_생활 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] fields = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			fields[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int[] sum = new int[N+2];
		int[] oper = new int[N+2];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) continue;
			oper[a] += k;
			oper[b+1] -= k;
		}
		
		for(int i = 1; i <= N; i++) {
			sum[i] += sum[i-1] + oper[i];
		}
		
		for(int i = 1; i<=N; i++) {
			sb.append((sum[i]+fields[i]) + " ");
		}
		System.out.println(sb);
	}
}
