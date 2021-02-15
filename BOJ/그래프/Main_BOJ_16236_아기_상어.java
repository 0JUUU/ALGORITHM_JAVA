import java.util.*;
import java.io.*;

/**
 * BOJ 16236 아기 상어
 * 2021.02.15
 * SSAFY 스터디
 * : 1. isVisited에 마크가 되어있지 않은 애들도 경우에 포함되어 혼란
 * : 2. isAvail이라는 함수가 내 주변에서 갈 수 있는지 check하는 것이 아닌 단순히 내 사이즈보다 작은 애들을 확인하는 것이므로 한번 더 조건 확인이 필요함
 * : 3. min을 지역변수로 두고 min == Integer.MAX_VALUE; 일 때 second를 0으로 초기화하니 한 번 먹이감을 찾고 이후에 찾지 못할 경우도 함께 second가 0이 됨
 * : 3-1. 이를(=min) 전역변수로 두고 min이 Integer.MAX_VALUE라는 값을 가질 때 while문을 break함으로써 이 문제를 해결 
 * @author 0JUUU
 *
 */
public class Main_BOJ_16236_아기_상어 {
	static int[][] area, isVisited;
	static int N, size, second, count = 1;/*잡아먹은 물고기 수(size와 같아지면 0으로 초기화됨)*/;
	static int min;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		area =  new int[N][N];
		min = Integer.MAX_VALUE;
		StringTokenizer st;
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N;j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(area[i][j] == 9) {
					q.offer(new int[] {i, j});
					area[i][j] = 0;
				}
			}
		}
		size = 2; 
		while(isAvail()) {
			bfs();
			if(min == Integer.MAX_VALUE) break;
		}
		System.out.println(second);
	}
	
	static boolean isAvail() {		// 먹을 수 있는 물고기가 있는지 확인 ( 내 주변을 확인하는 것이 아니고 가능성이 있는 것을 체크하는 것임) --> bfs를 돌 때 아예 움직이지 못하는 경우가 있음
		boolean isFound = false;
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				if(area[i][j] != 0 && area[i][j] < size && area[i][j] != 9) {
					isFound = true;
					break;
				}
			}
			if(isFound) break;
		}
		return isFound;
	}
	
	static void bfs() {		// 먹이까지의 최단 거리를 구하는 지도
		isVisited = new int[N][N];
		int[] frontQ = q.peek();
		isVisited[frontQ[0]][frontQ[1]] = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir = 0; dir<4;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || ny <0 || nx>=N|| ny >=N) continue;
				if(isVisited[nx][ny] != 0) continue;
				if(area[nx][ny] > size) continue;
				q.offer(new int[] {nx,ny});
				isVisited[nx][ny] = isVisited[cur[0]][cur[1]] + 1;
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int i = 0; i<N;i++) {		// 적은 이동횟수를 구함
			for(int j = 0; j<N;j++) {
				if(area[i][j] != 0 && area[i][j] < size && isVisited[i][j] != 0)	// isVisited[i][j]가 0인 애들도 체크할 수 있으므로 꼭 넣어줬어야함
					min = min < isVisited[i][j] ? min : isVisited[i][j];
			}
		}
		
		int x = 0, y = 0;
		boolean isFoundXY = false;
		for(int i = 0; i<N;i++) {		
			for(int j = 0; j<N;j++) {
				if(area[i][j] != 0 && area[i][j] < size && isVisited[i][j] == min && area[i][j] != 9) {
					x = i; y = j;
					isFoundXY = true;
					break;
				}
			}
			if(isFoundXY) break;
		}
		
		if(min == Integer.MAX_VALUE) {		
			return;
		}
		second += min -1;	// 걸리는 시간 더하기
		if(count == size) {
			count =1; size++;
		} else {
			count++;
		}
		area[x][y] = 9;
		q.offer(new int[] {x,y});
		area[x][y] = 0;
	}
}
