import java.util.*;
import java.io.*;

/**
 * SWEA 3307 최장 증가 부분 수열
 * 2021.03.25
 * : LIS : 내 이전의 값들과 비교하여 붙은 수 있는 수들 중 가장 큰 수를 골라 1을 더한 배열
 * @author 0JUUU
 *
 */

public class Solution_SWEA_D3_3307_최장_증가_부분_수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for(int tc = 1; tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] seq = new int[N];
			int[] LIS = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N;i++) {
				seq[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i = 0; i<N;i++) {
				LIS[i] = 1;
				for(int j = 0; j<i;j++) {
					if(seq[i] > seq[j] && LIS[i] <LIS[j]+1) {
						LIS[i] = LIS[j] + 1;
					}
				}
				max = LIS[i] > max ? LIS[i] : max;
			}	
			sb.append("#" + tc + " " +max+ "\n");
		}
		System.out.print(sb);
	}
}
