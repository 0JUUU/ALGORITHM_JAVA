import java.util.*;
import java.io.*;

/**
 * BOJ 16439 치킨치킨치킨
 * 2021.11.10
 * : 조합으로 해결
 * @author 0JUUU
 *
 */
public class Main_BOJ_16439_치킨치킨치킨 {

	static int N, M, max;
	static int[][] a;
	static int[] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 0;
		
		a = new int[N][M+1];
		selected = new int[3];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=M; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0, 1);
		System.out.println(max);
	}
	private static void perm(int cnt, int start) {
		if(cnt == 3) {
			int[] satisfy = new int[N];
			int sum = 0;
			for(int i = 0; i<N; i++) {
				satisfy[i] = Math.max(a[i][selected[0]], 
						Math.max(a[i][selected[1]], a[i][selected[2]]));
				sum += satisfy[i];
			}
			
			max = sum > max ? sum : max;
			return;
		}
		
		for(int i = start; i <= M; i++) {
			selected[cnt] = i;
			perm(cnt+1, i);
		}
	}
	
	
}
