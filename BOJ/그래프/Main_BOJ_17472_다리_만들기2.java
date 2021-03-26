import java.util.*;
import java.io.*;

/**
 * BOJ 17472 다리 만들기2
 * 2021.03.26
 * : 1. BFS로 섬의 개수 구하기
 * : 2. 각 섬에서 다른 섬을 연결할 수 있는 다리 & 다리 길이 구해서 인접행렬로 변환
 * : 3. MST --> PRIM을 이용해서 최소간선 구하기
 * @author 0JUUU
 *
 */
public class Main_BOJ_17472_다리_만들기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		
		// 섬의 개수 세기
		Deque<int[]> q = new LinkedList<int[]>();
		int[][] visited = new int[N][M];
		int countIsland = 1;
		for(int i = 0; i<N;i++) {
			for(int j =0; j<M;j++) {
				if(map[i][j] == 1 && visited[i][j] == 0) {
					visited[i][j] = countIsland++;
					q.offer(new int[] {i, j});
				}
				
				while(!q.isEmpty()) {
					int[] cur = q.pollFirst();
					for(int dir = 0; dir<4;dir++) {
						int nx = cur[0] + dx[dir];
						int ny = cur[1] + dy[dir];
						if(nx < 0 || nx >=N || ny <0 || ny>=M) continue;
						if(visited[nx][ny] != 0 || map[nx][ny] == 0) continue;
						visited[nx][ny] = visited[cur[0]][cur[1]];
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		
		int[][] adjMatrix = new int[countIsland][countIsland];
		int[] minEdge = new int[countIsland+1];
		Arrays.fill(minEdge, 987654321);
		
		// 이어질 수 있는 섬의 정보 선별
		for(int i = 0; i<N;i++) {
			int from = 0, to = 0;
			int count = 0;
			for(int j = 0; j<M;j++) {
				if(visited[i][j] != 0 && from == 0) from = visited[i][j];
				else if(visited[i][j] != 0 && from == visited[i][j]) count = 0;
				else if(visited[i][j] != 0 && from != visited[i][j]) {
					to = visited[i][j]; 
					if(count >= 2 && from != 0 && to != 0) {
						if(adjMatrix[from][to] == 0 || (adjMatrix[from][to] != 0 && adjMatrix[from][to] > count)) adjMatrix[from][to] = adjMatrix[to][from] = count;
					
					}
					count = 0; from = to; to = 0;
				}
				else if(from != 0 && visited[i][j] == 0) count++;
			}
		
		}
		
		for(int j = 0; j<M;j++) {
			int from = 0, to = 0;
			int count = 0;
			for(int i = 0; i<N;i++) {
				if(visited[i][j] != 0 && from == 0) from = visited[i][j];
				else if(visited[i][j] != 0 && from == visited[i][j]) count = 0;
				else if(visited[i][j] != 0 && from != visited[i][j]) {
					to = visited[i][j]; 
					if(count >= 2 && from != 0 && to != 0) {
						if(adjMatrix[from][to] == 0 || (adjMatrix[from][to] != 0 && adjMatrix[from][to] > count)) adjMatrix[from][to] = adjMatrix[to][from] = count;
					}
					count = 0; from = to; to = 0;
				}
				else if(from != 0 && visited[i][j] == 0) count++;
			}
		}
		
		int result = 0;
		boolean[] visitedIsland = new boolean[countIsland];
		minEdge[1] = 0;
		for(int i = 1; i<countIsland;i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for(int j = 1; j<countIsland;j++) {
				if(!visitedIsland[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			result += min;
			visitedIsland[minVertex] = true;
			
			for(int j = 1; j<countIsland;j++) {
				if(!visitedIsland[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}
		}
		
		boolean isConnected = true;
		for(int i = 1; i<countIsland;i++) {
			if(minEdge[i] == 987654321) isConnected = false;
		}
		if(isConnected) System.out.println(result);
		else System.out.println(-1);
	} 
}
