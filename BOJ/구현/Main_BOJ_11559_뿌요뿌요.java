import java.util.*;
import java.io.*;

/**
 * BOJ 11559 뿌요뿌요
 * 2021.02.26
 * : bfs를 이용 --> 나는 색 별로 queue를 구별했는데 하나의 큐로 하면 코드가 훨씬 간편해질듯
 * @author 0JUUU
 *
 */
public class Main_BOJ_11559_뿌요뿌요 {
	static char[][] field = new char[12][6];
	static int pop = 0;
	static Deque<int[]> queueR = new LinkedList<int[]>();
	static Deque<int[]> queueG = new LinkedList<int[]>();
	static Deque<int[]> queueB = new LinkedList<int[]>();
	static Deque<int[]> queueP = new LinkedList<int[]>();
	static Deque<int[]> queueY = new LinkedList<int[]>();
	static LinkedList<int[]> update = new LinkedList<>();
	static LinkedList<int[]> notupdate = new LinkedList<>();
	static int[][] visited;
	static boolean isNotFound = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		visited = new int[12][6];
		for(int i = 0; i<12;i++) { 
			field[i] = br.readLine().toCharArray();
		}
		
		while(!isNotFound) getPop();
		System.out.println(pop);
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	private static void getPop() {
		int count = 1;
		for(int i =11 ;i>=0;i--) {
			for(int j = 5; j>=0;j--) {
				if(field[i][j] == '.') continue;
				if(visited[i][j] != 0) continue;
				switch(field[i][j]) {
				case 'R':
					count = 1;
					queueR.offer(new int[] {i, j}); visited[i][j] = 1;
					update.add(new int[] {i, j});
					while(!queueR.isEmpty()) {
						int cur[] = queueR.pollFirst();
						for(int dir = 0; dir<4;dir++) {
							int nx = cur[0] + dx[dir];
							int ny = cur[1] + dy[dir];
							if(nx < 0 || ny < 0 || nx>=12 || ny >=6) continue;
							if(field[nx][ny] != 'R' || visited[nx][ny] != 0) continue;
							visited[nx][ny] = 1;
							count++;
							queueR.offer(new int[] {nx, ny}); update.add(new int[] {nx,ny});
						}
					}
					break;
				case 'G':
					count = 1;

					queueG.offer(new int[] {i, j}); visited[i][j] = 1;
					update.add(new int[] {i, j});
					while(!queueG.isEmpty()) {
						int cur[] = queueG.pollFirst();
						for(int dir = 0; dir<4;dir++) {
							int nx = cur[0] + dx[dir];
							int ny = cur[1] + dy[dir];
							if(nx < 0 || ny < 0 || nx>=12 || ny >=6) continue;
							if(field[nx][ny] != 'G' || visited[nx][ny] != 0) continue;
							visited[nx][ny] = 1;
							count++;
							queueG.offer(new int[] {nx, ny}); update.add(new int[] {nx,ny});
						}
					}
					break;
				case 'B':
					count = 1;
					queueB.offer(new int[] {i, j}); visited[i][j] = 1;
					update.add(new int[] {i, j});
					while(!queueB.isEmpty()) {
						int cur[] = queueB.pollFirst();
						for(int dir = 0; dir<4;dir++) {
							int nx = cur[0] + dx[dir];
							int ny = cur[1] + dy[dir];
							if(nx < 0 || ny < 0 || nx>=12 || ny >=6) continue;
							if(field[nx][ny] != 'B' || visited[nx][ny] != 0) continue;
							visited[nx][ny] = 1;
							count++;
							queueB.offer(new int[] {nx, ny}); update.add(new int[] {nx,ny});
						}
					}
					break;
				case 'P':
					count = 1;
					queueP.offer(new int[] {i, j}); visited[i][j] = 1;
					update.add(new int[] {i, j});
					while(!queueP.isEmpty()) {
						int cur[] = queueP.pollFirst();
						for(int dir = 0; dir<4;dir++) {
							int nx = cur[0] + dx[dir];
							int ny = cur[1] + dy[dir];
							if(nx < 0 || ny < 0 || nx>=12 || ny >=6) continue;
							if(field[nx][ny] != 'P' || visited[nx][ny] != 0) continue;
							visited[nx][ny] = 1;
							count++;
							queueP.offer(new int[] {nx, ny}); update.add(new int[] {nx,ny});
						}
					}
					break;
				case 'Y':
					count = 1;
					queueY.offer(new int[] {i, j}); visited[i][j] = 1;
					update.add(new int[] {i, j});
					while(!queueY.isEmpty()) {
						int cur[] = queueY.pollFirst();
						for(int dir = 0; dir<4;dir++) {
							int nx = cur[0] + dx[dir];
							int ny = cur[1] + dy[dir];
							if(nx < 0 || ny < 0 || nx>=12 || ny >=6) continue;
							if(field[nx][ny] != 'Y' || visited[nx][ny] != 0) continue;
							visited[nx][ny] = 1;
							count++;
							queueY.offer(new int[] {nx, ny}); update.add(new int[] {nx,ny});
						}
					}
					break;
				}
				if(count < 4) {
					for(int c = 0; c<count;c++) {
						int length = update.size();
						int[] remove = update.get(length - 1);
						update.remove(length-1);
						notupdate.add(remove);
					}
				} 
			}
		}	// for - i
		if(!update.isEmpty()) {
			while(!notupdate.isEmpty()) {
				visited[notupdate.peekFirst()[0]][notupdate.peekFirst()[1]] = 0;
				notupdate.pollFirst();
			}
			setField();
		}
		else isNotFound = true;
	}
	
	private static void setField() {
		pop++;
		int push = 0, gravity = 0;
		
		for(int i = 11; i>=0;i--) {
			for(int j = 5; j>=0; j--) {
				if(visited[i][j] != 0) field[i][j] = '.';
			}
		}
		char[] nC = new char[12]; int index = 0;

		for(int j = 0; j<6;j++) {
			Arrays.fill(nC, '.');
			index = 0;
			for(int i =11; i>=0;i--) {
				if(field[i][j] != '.') {
					nC[index++] = field[i][j];
				}
			}
			
			for(int i = 11; i>=0; i--) {
				field[i][j] = nC[11-i];
			}
		}
		
		visited = new int[12][6];	// visited 초기화~
		update = new LinkedList<>();
	}

}
