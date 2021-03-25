import java.util.*;
import java.io.*;

/**
 * SWEA 1236 사람 네트워크2
 * 2021.03.25
 * : floid 알고리즘 	: 96,312 kb 메모리
					: 3,441 ms 실행시간
 * @author 0JUUU
 *
 */
public class Solution_SWEA_D6_1263_사람_네트워크2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for(int tc = 1; tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] D = new int[N][N];
			for(int i = 0; i<N;i++) {
				for(int j =0 ;j<N;j++) {
					D[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && D[i][j] == 0) D[i][j] = 987654321;
				}
			}
			
			for(int k = 0; k<N;k++) {
				for(int i = 0; i<N;i++) {
					for(int j = 0; j<N;j++) {
						if(i == k || j == k || j == i) continue;
						D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]);
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i<N;i++) {
				int sum = 0;
				for(int j = 0; j<N;j++) {
					sum += D[i][j];
				}
				min = min > sum ? sum : min;
			}
			sb.append("#"+tc+" " +min+ "\n");
		}
		System.out.print(sb);
	}
}
