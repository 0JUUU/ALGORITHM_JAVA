import java.util.*;
import java.io.*;

/**
 * BOJ 16967 배열 복원하기
 * 2021.06.29
	오랜만에 알고리즘 문제를 도전했던 터라 머리가 굉장히 안굴러갔다. 
	배열 이동 규칙을 발견하여 문제를 해결하였다.
 * @author 0JUUU
 *
 */
public class Main_BOJ_16967_배열_복원하기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] B = new int[(H+X)][(W+Y)];
		int newH = H+X, newW = W+Y;
		for(int i = 0; i<newH;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<newW;j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] A = new int[H][W];
		for(int i = 0; i<X;i++) {
			for(int j = 0; j<W;j++) {
				A[i][j] = B[i][j];
			}
		}
		
		for(int j = 0; j<Y;j++) {
			for(int i = 0; i<H;i++) {
				A[i][j] = B[i][j];
			}
		}
		
		for(int i = H-1;i>H-X-1;i--) {
			for(int j = 0; j<W;j++) {
				A[i][j] = B[i+X][j+Y];
			}
		}
		
		for(int j = W-1; j>W-Y-1;j--) {
			for(int i = 0; i<H;i++) {
				A[i][j] = B[i+X][j+Y];
			}
		}

		for(int i = 0; i<H;i++) {
			for(int j = 0; j<W;j++) {
				if(i + X >= H || j + Y >= W) continue;
				A[i+X][j+Y] = B[i+X][j+Y] - A[i][j];
			}
		}

		for(int i = 0; i<H;i++) {
			for(int j = 0; j<W;j++) {
				sb.append(A[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
