import java.util.*;
import java.io.*;

/**
 * BOJ 1992 쿼드트리
 * 2021.02.17
 * : 1. 좌표값을 설정하는 것에 대한 연습이 필요함 
 * @author 0JUUU
 *
 */
public class Main_BOJ_1992_쿼드트리 {
	static int N;
	static int[][] video;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		String s;
		for(int i = 0; i<N;i++) {
			s = new String(br.readLine());
			for(int j = 0; j<N;j++) {
				video[i][j] = s.charAt(j) - '0';
			}
		}
		getQuery(N, 0, 0);
		System.out.println(sb);
	}
	
	static void getQuery(int N, int x, int y) {
		
		if(N == 1) {
			sb.append(video[x][y]);
			return;
		}
		
		int halfN = N/2;
		int count = N * N; 
		int isZero = 0; 
		for(int i = x; i<N + x;i++) {
			for(int j = y; j<N + y;j++) {
				if(video[i][j] == 0) isZero++;
			}
		}
		
		if(isZero == 0 ) {
			sb.append(1);
			return;
		} else if (isZero == count){
			sb.append(0);
			return;
		} else {
			sb.append("(");
			getQuery(halfN, x, y);
			getQuery(halfN, x, y + halfN);
			getQuery(halfN, x + halfN, y);
			getQuery(halfN, x + halfN, y + halfN);
			sb.append(")");
		}
		
	}
	
}
