import java.util.*;
import java.io.*;

public class Solution_SWEA_4012_요리사 {
	static int N, R, min;
	static int[][] S;
	static boolean[] isSelected;
	static int[] permA, permB;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			R = N/2;
			min = Integer.MAX_VALUE;
			S = new int[N][N];
			isSelected = new boolean[N];
			permA = new int[R]; permB = new int[R];
			
			for(int i = 0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N;j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			subset(0);
			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.println(sb);
	}
	
	private static void subset(int cnt) {

		if(cnt == N) {
			int countTrue = 0;
			for(int i = 0; i<N;i++) {
				if(isSelected[i]) countTrue++;
			}
			if(countTrue != R) return;
			int cntA = 0, cntB = 0;
			int sumA = 0, sumB = 0;
			for(int i = 0; i<N;i++) {
				if(isSelected[i]) permA[cntA++] = i;
				else permB[cntB++] = i;
			}
			
			for(int i = 0; i<R;i++) {
				for(int j = i+1; j<R;j++) {
					sumA += S[permA[i]][permA[j]] + S[permA[j]][permA[i]];
					sumB += S[permB[i]][permB[j]] + S[permB[j]][permB[i]];
				}
			}
			
			min = min > Math.abs(sumA- sumB) ?  Math.abs(sumA- sumB) : min; 
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] =false;
		subset(cnt+1);		
	}
}
