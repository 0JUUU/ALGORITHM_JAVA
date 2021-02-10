import java.util.*;
import java.io.*;

public class Main_BOJ_16935_배열_돌리기_3 {
	static int[][] arr;
//	static int N, M, R;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int operation = Integer.parseInt(st.nextToken());
			switch (operation) {
			case 1:
				operate1();
				break;
			case 2:
				operate2();
				break;
			case 3:
				operate3();
				break;
			case 4:
				operate4();
				break;
			case 5:
				operate5();
				break;
			case 6:
				operate6();
				break;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void operate1() {		// 1. 상하반전
		int X = arr.length;
		int Y = arr[0].length;
		for(int i = 0; i<X/2;i++) {
			for(int j = 0; j<Y;j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[X-i-1][j];
				arr[X-i-1][j] = tmp;
			}
		}
	}

	static void operate2() {
		int X = arr.length;
		int Y = arr[0].length;
		for(int j = 0; j<Y/2;j++) {
			for(int i = 0; i<X;i++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[i][Y-j-1];
				arr[i][Y-j-1] = tmp;
			}
		}
	}

	static void operate3() {
		int X = arr.length;
		int Y = arr[0].length;
		int[][]tmp = new int[Y][X];
		for(int j = 0; j<Y;j++) {
			for(int i = 0; i<X;i++) {
				tmp[j][X-i-1]= arr[i][j];
			}
		}
		arr = new int[Y][X];
		arr = tmp;
	}

	static void operate4() {
		int X = arr.length;
		int Y = arr[0].length;
		int[][]tmp = new int[Y][X];
		for(int i = 0; i<X;i++) {
			for(int j = 0; j<Y;j++) {
				tmp[Y-j-1][i]= arr[i][j];
			}
		}
		arr = new int[Y][X];
		arr = tmp;
	}

	static void operate5() {
		int X = arr.length;
		int Y = arr[0].length;
		int[][] first = new int[X/2][Y/2];
		for(int i = 0; i<X/2;i++) {		// 1번 그룹 저정
			for(int j = 0; j<Y/2;j++) {	
				first[i][j] = arr[i][j];	
			}
		}
		
		for(int i = 0; i<X/2;i++) {			// 4->1
			for(int j = 0; j<Y/2;j++) {
				arr[i][j] = arr[i+X/2][j];
			}
		}
		for(int j = 0; j<Y/2;j++) {			// 3->4
			for(int i = X/2;i<X;i++) {
				arr[i][j] = arr[i][j+Y/2];
			}
		}
		for(int i = 0; i<X/2;i++) {			// 2->3
			for(int j = Y/2; j<Y;j++) {
				arr[i+X/2][j] = arr[i][j];
			}
		}
		
		for(int j = 0; j<Y/2;j++) {			// 1->2
			for(int i = 0;i<X/2;i++) {
				arr[i][j+Y/2] = first[i][j];
			}
		}
	}

	static void operate6() {
		int X = arr.length;
		int Y = arr[0].length;
		int halfX = X/2;
		int halfY = Y/2;
		int[][] first = new int[X/2][Y/2];
		for(int i = 0; i<halfX;i++) {		// 1번 그룹 저정
			for(int j = 0; j<halfY;j++) {	
				first[i][j] = arr[i][j];	
			}
		}
		
		for(int j = 0; j<halfY;j++) {			// 2->1
			for(int i = 0;i<X/2;i++) {
				arr[i][j] = arr[i][j+halfY];
			}
		} 
		
		for(int i = 0; i<X/2;i++) {			// 3->2
			for(int j = Y/2; j<Y;j++) {
				arr[i][j] = arr[i+X/2][j];
			}
		}
		
		for(int j = 0; j<Y/2;j++) {			// 4->3
			for(int i = X/2;i<X;i++) {
				arr[i][j+Y/2] = arr[i][j];
			}
		}
		
		for(int i = 0; i<X/2;i++) {			// 1->4
			for(int j = 0; j<Y/2;j++) {
				arr[i+X/2][j] = first[i][j];
			}
		}
	}
}
