import java.util.*;
import java.io.*;

/**
 * BOJ 1987 알파벳
 * 2021.02.18
 * : 1. dfs를 이용하여 문제를 풂
 * : 2. 반례를 잘 찾아야함 (처음 풀었을 때, 알파벳들이 하나도 겹치지않는 경우를 생각하지 못했음)
 * */

public class Main_BOJ_1987_알파벳 {
	static int R, C, max = Integer.MIN_VALUE;
	static char[][] board;
	static int[][] isVisited;
	static int[] isUsed;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s;
		R = Integer.parseInt(st.nextToken());	C = Integer.parseInt(st.nextToken());
		board = new char[R][];
		isVisited = new int[R][C];
		for(int i = 0; i<R;i++) {
			board[i] = br.readLine().toCharArray();
		}
		isUsed = new int[26]; isVisited = new int[R][C];
		isUsed[board[0][0] - 'A'] = 1;
		isVisited[0][0] = 1;
		dfs(0,0);
		max = max == Integer.MIN_VALUE ? R *C : max; 
		System.out.println(max);
	}
	
	static void dfs(int i, int j) {
		int nx, ny;
		
		for(int dir = 0; dir<4;dir++) {
			nx = i + dx[dir];
			ny = j + dy[dir];
			
			if(nx < 0 || nx>=R || ny <0 || ny>=C) continue;
			if(isVisited[nx][ny] != 0) continue;
			if(isUsed[board[nx][ny] - 'A'] != 0) {
				max = max < isVisited[i][j] ? isVisited[i][j] : max;
				continue;
			}
			isUsed[board[nx][ny] - 'A'] = 1;
			isVisited[nx][ny] = isVisited[i][j] + 1;
			dfs(nx,ny);
			isVisited[nx][ny] = 0;
			isUsed[board[nx][ny] -'A'] = 0;
		}
	}
	
}
