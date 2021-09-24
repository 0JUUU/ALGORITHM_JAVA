import java.util.*;
import java.io.*;

/**
 * BOJ 1780 종이의 개수
 * 2021.09.24
 * @author 0JUUU
 *
 */
public class Main_BOJ_1780_종이의_개수 {

	static int N;
	static int[] sum;
	static int[][] paper;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sum = new int[3];
		paper = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		countPaper(0, 0, N);
		for(int i = 0; i < 3; i++) 
			System.out.println(sum[i]);

	}
	private static void countPaper(int startX, int startY, int N) {
		// N = 1 => 확인할 필요 없이 바로 개수 리턴
		if(N == 1) {
			sum[paper[startX][startY] + 1]++;
			return;
		}
		
		// 모두 같은 수인지 확인
		boolean isMinusOne = false, isZero = false, isOne = false;
		for(int i = startX; i < startX + N; i++) {
			for(int j = startY; j < startY + N; j++) {
				if(paper[i][j] == -1) isMinusOne = true;
				else if(paper[i][j] == 0) isZero = true;
				else isOne = true;
			}
		}
		
		if(isMinusOne && !isZero && !isOne) {
			sum[0]++; return;
		}
		
		if(!isMinusOne && isZero && !isOne) {
			sum[1]++; return;
		}
		
		if(!isMinusOne && !isZero && isOne) {
			sum[2]++; return;
		}
		
		// 아니면 9등분
		int nextLen = N / 3;
		for(int i = startX; i < startX + N; i += nextLen) {
			for(int j = startY; j < startY + N; j += nextLen) {
				countPaper(i, j, nextLen);
			}
		}
	}
}
