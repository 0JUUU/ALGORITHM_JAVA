import java.util.*;
import java.io.*;

/**
 * BOJ 3085. 사탕 게임
 * 2021.02.05
 * 코딩방범대 브루트포스
 * 2021.10.29 다시 도전
 * => 못하겠어서 풀이 확인
 * 50X50 이므로 1초 안에 모든 연산 가능 
 * @author 0JUUU
 *
 */
public class Main_BOJ_3085_사탕_게임 {
	static int N, answer;
	static char[][] board;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		answer = 0;
		board = new char[N][N];
		for(int i = 0 ; i<N;i++) {
			String s= br.readLine();
			board[i] = s.toCharArray();
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(j + 1 < N && board[i][j+1] != board[i][j]) {
					swap(i, j, i, j+1);
					check();
					swap(i, j, i, j+1);
				}
				
				if(i + 1 < N && board[i][j] != board[i+1][j]) {
					swap(i, j, i+1, j);
					check();
					swap(i, j, i+1, j);
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static void swap(int startI, int startJ, int endI, int endJ) {
		char tmp = board[startI][startJ];
		board[startI][startJ] = board[endI][endJ];
		board[endI][endJ] = tmp;
	}
	
	public static void check() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				checkRow(i, j);
				checkCol(i, j);
			}
		}
	}

	private static void checkRow(int i, int j) {
		int count = 1;
		char color = board[i][j];
		
		int nextI = i;
		while(true) {
			nextI += 1;
			if(nextI >= N || board[nextI][j] != color) 
				break;
			count++;
		}
		
		nextI = i;
		while(true) {
			nextI -= 1;
			if(nextI < 0 || board[nextI][j] != color)
				break;
			count++;
		}
		answer = count > answer ? count : answer;
	}

	private static void checkCol(int i, int j) {
		int count = 1;
		char color = board[i][j];
		
		int nextJ = j;
		while(true) {
			nextJ += 1;
			if(nextJ >= N || board[i][nextJ] != color) 
				break;
			count++;
		}
		
		nextJ = j;
		while(true) {
			nextJ -= 1;
			if(nextJ < 0 || board[i][nextJ] != color)
				break;
			count++;
		}
		answer = count > answer ? count : answer;
		
	}
}
