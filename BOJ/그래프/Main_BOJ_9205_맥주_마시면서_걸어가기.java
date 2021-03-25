import java.util.*;
import java.io.*;

/**
 * BOJ 9205 맥주 마시면서 걸어가기
 * 2021.03.25
 * : 플로이드 알고리즘 이용
 * @author 0JUUU
 *
 */
public class Main_BOJ_9205_맥주_마시면서_걸어가기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for(int tc = 0; tc<T;tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] location = new int[n+2][2];
			for(int i = 0; i<n+2;i++) {
				st = new StringTokenizer(br.readLine());
				location[i][0] = Integer.parseInt(st.nextToken());
				location[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[][] D = new int[n+2][n+2];
			for(int i = 0; i<n+2;i++) {
				for(int j = 0; j<n+2;j++) {
					if(i == j) D[i][j] = 0;
					else if(Math.abs(location[i][0] - location[j][0]) + Math.abs(location[i][1] - location[j][1])  <= 1000) {
						D[i][j] = 1;
					} else {
						D[i][j] = 987654321;
					}
				}
			}
			
			for(int k = 0; k<n+2; k++) {
				for(int i = 0; i<n+2;i++) {
					for(int j = 0; j<n+2;j++) {
						if(k == i || k == j || i == j) continue;
						D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]);
					}
				}
			}
			
			if(D[0][n+1] == 987654321) sb.append("sad\n");
			else sb.append("happy\n");
		}
		System.out.print(sb);
	}
}
