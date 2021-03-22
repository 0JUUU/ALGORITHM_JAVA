import java.util.*;
import java.io.*;

/**
 * BOJ 14496 그대, 그머가 되어
 * 2021.03.22
 * : 1. 인접행렬로 해결
 * @author 0JUUU
 *
 */
public class Main_BOJ_14496_그대_그머가_되어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b= Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] adjMatrix = new int[N+1][N+1];
		int[] D = new int[N+1];
		boolean[] visited = new boolean[N+1];
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjMatrix[x][y] = adjMatrix[y][x] = 1;
		}
		
		Arrays.fill(D, Integer.MAX_VALUE);
		D[a] = 0;
		
		int min = Integer.MAX_VALUE, cur = a;
		for(int i = 1; i<=N;i++) {
			min = Integer.MAX_VALUE;
			for(int j = 1; j<=N;j++) {
				if(!visited[j] && D[j] < min) {
					min = D[j];
					cur = j;
				}
			}
			
			visited[cur] = true;
			
			for(int j = 1; j<=N;j++) {
				if(!visited[j] && adjMatrix[cur][j] != 0 && D[j] > 1 + min) {
					D[j] = min + 1;
				}
			}
		}
		
		if(D[b] != Integer.MAX_VALUE) System.out.println(D[b]);
		else System.out.println(-1);
	}
}
