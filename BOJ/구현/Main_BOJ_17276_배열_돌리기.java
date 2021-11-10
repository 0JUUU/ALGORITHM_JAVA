import java.util.*;
import java.io.*;

/**
 * BOJ 17276 배열 돌리기
 * 2021.11.10
 * : 반시계 = (360 - 각도) 인 시계방향
 * : 구현
 * @author 0JUUU
 *
 */

public class Main_BOJ_17276_배열_돌리기 {

	static int[][] X;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int degreeCount = d > 0 ? d / 45 : (360+d) / 45;
			X = new int[n][n];
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					X[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int dc = 1; dc<=degreeCount; dc++) {
				rotate(n);
			}
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j < n; j++) {
					sb.append(X[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
		
	}
	private static void rotate(int n) {
		int[][] tmp = new int[n][n];
		int index = n/2;
		// 주 대각선
		for(int i = 0; i<n; i++) {
			tmp[i][index] = X[i][i];		// 주 대각선
			tmp[i][n-i-1]= X[i][index];		// 가운데열
			tmp[index][i] = X[n-i-1][i];	// 부 대각선
			tmp[i][i] = X[index][i];		// 가운데행
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(tmp[i][j] == 0) continue;
				X[i][j] = tmp[i][j];
			}
		}
	}
}
