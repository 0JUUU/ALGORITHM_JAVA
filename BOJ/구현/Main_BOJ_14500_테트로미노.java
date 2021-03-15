import java.util.*;
import java.io.*;

/**
 * BOJ 14500 테트로미노 2021.03.15
 * : 1. 진짜 모든 경우를 다 돌림 --> 나올 수 있는 최대값을 구해서 만약 그 값에 도달한다면 그 즉시 끝낸다.
 * @author 0JUUU
 */
public class Main_BOJ_14500_테트로미노 {
	static int N, M, sumMax, max;
	static int[][] paper;
	static int[] maxFour = new int[4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				for (int k = 3; k >= 0; k--) {
					if (maxFour[k] < paper[i][j])
						maxFour[k] = paper[i][j];
				}
				Arrays.sort(maxFour);
			}
		}

		for (int i = 0; i < 4; i++) { // 나올 수 있는 제일 큰 값 구하기 --> 중간 과정에서 그만둘 수 있음
			sumMax += maxFour[i];
		}

		// 1번 모양
		int startX = 0, startY = 0;
		int sum = 0;
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if(M == 4) {
				sum = paper[i][0] + paper[i][1] + paper[i][2] + paper[i][3];
				if(sum > max) max = sum;
			}
			for (int j = 0; j < M - 4; j++) {
				sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];
				if (sum > max)
					max = sum;
			}
		}

		for (int j = 0; j < M; j++) {
			if(N == 4) {
				sum = paper[0][j] + paper[1][j] + paper[2][j] + paper[3][j];
				if(sum > max) max = sum;
			} else {	
				for (int i = 0; i < N - 4; i++) {
					sum = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j];
					if (sum > max) {
						max = sum;
					}
				}
			}
		}
		if (max == sumMax) {
			System.out.println(sumMax);
			return;
		}
		// 2번모양
		for (int i = 0; i <= N - 2; i++) {
			for (int j = 0; j <= M - 2; j++) {
				sum = paper[i][j] + paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1];
				if (sum > max)
					max = sum;
			}
		}
		if (max == sumMax) {
			System.out.println(sumMax);
			return;
		}

		// 3번 모양 (뻐큐모양의 중지가 오른쪽 / 왼쪽/ 아래/ 위 순으로 가리킴)
		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 2; j++) {
				sum = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 1][j + 1];
				if (sum > max)
					max = sum;
			}

			if (max == sumMax) {
				System.out.println(sumMax);
				return;
			}
			
			for (int j = 0; j <= M - 2; j++) {
				sum = paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1] + paper[i][j + 1];
				if (sum > max)
					max = sum;
			}
		}
		
		if (max == sumMax) {
			System.out.println(sumMax);
			return;
		}
		
		for (int j = 0; j <= M - 3; j++) {
			for (int i = 0; i <= N - 2; i++) {
				sum = paper[i+1][j] + paper[i + 1][j+1] + paper[i][j+1] + paper[i +1][j + 2];
				if (sum > max)
					max = sum;
			}

			if (max == sumMax) {
				System.out.println(sumMax);
				return;
			}
			
			for (int i = 0; i <= N - 2; i++) {
				sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i][j + 2];
				if (sum > max)
					max = sum;
			}
		}
		if (max == sumMax) {
			System.out.println(sumMax);
			return;
		}
		
		// 4번째 모양
		for(int i = 0; i<=N-3;i++) {
			for(int j = 0; j<=M-2;j++) {
				sum = paper[i][j] + paper[i+1][j] + paper[i + 1][j + 1] + paper[i+2][j + 1];
				if (sum > max)
					max = sum;
			}
			
			if (max == sumMax) {
				System.out.println(sumMax);
				return;
			}
			
			for(int j = 0; j<=M-2;j++) {
				sum = paper[i][j+1] + paper[i+1][j] + paper[i + 1][j + 1] + paper[i+2][j];
				if (sum > max)
					max = sum;
			}
		}
		
		if (max == sumMax) {
			System.out.println(sumMax);
			return;
		}
		
		for(int j = 0; j<=M-3;j++) {
			for(int i = 0; i<=N-2;i++) {
				sum = paper[i+1][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i][j+2];
				if (sum > max)
					max = sum;
			}
			if (max == sumMax) {
				System.out.println(sumMax);
				return;
			}
			
			for(int i = 0; i<=N-2;i++) {
				sum = paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+1][j+2];
				if (sum > max)
					max = sum;
			}
		}
		if (max == sumMax) {
			System.out.println(sumMax);
			return;
		}
		
		// 5번째
		for(int i = 0; i<=N-3;i++) {
			for(int j = 0; j<=M-2;j++) {
				sum = paper[i][j] + paper[i+1][j] + paper[i + 2][j] + paper[i+2][j + 1];
				if (sum > max)
					max = sum;
			}
			
			if (max == sumMax) {
				System.out.println(sumMax);
				return;
			}
			
			for(int j = 0; j<=M-2;j++) {
				sum = paper[i][j] + paper[i][j+1] + paper[i + 1][j+1] + paper[i+2][j + 1];
				if (sum > max)
					max = sum;
			}
			
			if (max == sumMax) {
				System.out.println(sumMax);
				return;
			}
			
			for(int j = 0; j<=M-2;j++) {
				sum = paper[i][j+1] + paper[i+1][j+1] + paper[i + 2][j + 1] + paper[i+2][j];
				if (sum > max)
					max = sum;
			}
			
			if (max == sumMax) {
				System.out.println(sumMax);
				return;
			}
			
			for(int j = 0; j<=M-2;j++) {
				sum = paper[i][j] + paper[i][j+1] + paper[i + 1][j] + paper[i+2][j];
				if (sum > max)
					max = sum;
			}
			
			if (max == sumMax) {
				System.out.println(sumMax);
				return;
			}
		}
		
		for(int j = 0; j<=M-3;j++) {
			for(int i = 0; i<=N-2;i++) {
				sum = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j];
				if (sum > max)
					max = sum;
			}
			
			if (max == sumMax) {
				System.out.println(sumMax);
				return;
			}
			for(int i = 0; i<=N-2;i++) {
				sum = paper[i+1][j] + paper[i+1][j+1] + paper[i+1][j+2] + paper[i][j+2];
				if (sum > max)
					max = sum;
			}
			
			if (max == sumMax) {
				System.out.println(sumMax);
				return;
			}
			
			for(int i = 0; i<=N-2;i++) {
				sum = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+2];
				if (sum > max)
					max = sum;
			}
			
			if (max == sumMax) {
				System.out.println(sumMax);
				return;
			}
			for(int i = 0; i<=N-2;i++) {
				sum = paper[i][j] + paper[i+1][j] + paper[i+1][j+1] + paper[i+1][j+2];
				if (sum > max)
					max = sum;
			}
			
			if (max == sumMax) {
				System.out.println(sumMax);
				return;
			}
		}
		
		System.out.println(max);
	}
}
