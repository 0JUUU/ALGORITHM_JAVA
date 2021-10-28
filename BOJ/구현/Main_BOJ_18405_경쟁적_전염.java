import java.util.*;
import java.io.*;

/**
 * BOJ 18405 경쟁적 전염
 * 2021.10.28
 * 1. TLE => 모든 행렬 다 돌아보고 지금 찾고 있는 바이러스와 일치하면 BFS 시작 
 * 2. SOLVE => 바이러스 번호에 대한 정보들을 미리 저장하고 그것만 돌림
 * @author 0JUUU
 *
 */

public class Main_BOJ_18405_경쟁적_전염 {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] board = new int[N+1][N+1];
		
		LinkedList<int[]>[] nowVirus = new LinkedList[K+1];
		LinkedList<int[]>[] nextVirus = new LinkedList[K+1];
		for(int i = 0; i<=K; i++) {
			nowVirus[i] = new LinkedList<>();
			nextVirus[i] = new LinkedList<>();
		}
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] != 0) {
					nowVirus[board[i][j]].add(new int[] {i, j});
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] visited = new int[N+1][N+1];
		LinkedList<int[]> q = new LinkedList<>();
		for(int time = 0; time < S; time++) {
			for(int virus = 1; virus <= K; virus++) {
				while(!nowVirus[virus].isEmpty()) {
					int[] cur = nowVirus[virus].poll();
					visited[cur[0]][cur[1]] = 1;
					for(int dir = 0; dir<4; dir++) {
						int nx = cur[0] + dx[dir];
						int ny = cur[1] + dy[dir];
						if(nx <= 0 || nx > N || ny <= 0 || ny > N) continue;
						if(board[nx][ny] != 0) continue;
						if(visited[nx][ny] != 0) continue;
						board[nx][ny] = virus;
						visited[nx][ny] = 1;
						nextVirus[virus].add(new int[] {nx, ny});
					}
				}
				
				while(!nextVirus[virus].isEmpty()) {
					nowVirus[virus].add(nextVirus[virus].poll());
				}
			}
		}
		
		
		System.out.println(board[X][Y]);
	}
}
