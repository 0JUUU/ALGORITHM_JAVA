import java.util.*;
import java.io.*;

/**
 * BOJ 2660 회장뽑기
 * 2021.11.11
 * :플로이드 와샬 이용 (자기자신은 0으로 초기화해야함을 유의하자!)
 * => 얘를 다익스트라를 N번 반복해서 해보는 방법도 적용할 수 있을 듯
 * @author 0JUUU
 *
 */

public class Main_BOJ_2660_회장뽑기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] graph = new int[N+1][N+1];
		for(int i = 0; i<=N; i++) {
			Arrays.fill(graph[i], 101);
			graph[i][i] = 0;
		}
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1) break;
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		for(int k = 1; k<=N; k++) {
			for(int i = 1; i<=N; i++) {
				for(int j = 1 ; j<=N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		
		int min = 101;
		int[] score = new int[N+1];
		for(int i = 1; i<=N; i++) {
			int scoreMax = 0;
			for(int j = 1; j<=N; j++) {
				scoreMax = graph[i][j] > scoreMax ? graph[i][j] : scoreMax;
			}
			score[i] = scoreMax;
			min = min > scoreMax ? scoreMax : min;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i<=N; i++) {
			if(score[i] == min) 
				list.add(i);
		}
		
		sb.append(min + " " + list.size() + "\n");
		for(Integer num : list) {
			sb.append(num + " ");
		}
		
		System.out.println(sb);
	}
}
