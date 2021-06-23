import java.util.*;
import java.io.*;

/**
 * BOJ 2931 가스관
 * 2021.06.24
 * : WA --> 불필요한 블록이 존재하지 않는다는 조건을 고려하지 않음
10 10
..........
..........
.........Z
1---4....|
|1-4|....|
||13|....|
|2.-3....|
2-+------3
..|.......
..M.......

CORRECT ANSWER : 7 3 +
WRONG ANSWER : 7 3 1

 * @author 0JUUU
 *
 */
public class Main_BOJ_2931_가스관 {

	static int N, M;
	static char[][] pipe;
	static int[] dx = {-1,0,1,0};	// 상좌하우
	static int[] dy = {0,-1,0,1};
	static int[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashMap<Character, Integer> block = new HashMap<>();
		block.put('|', 0);
		block.put('-', 1);
		block.put('+', 2);
		block.put('1', 3);
		block.put('2', 4);
		block.put('3', 5);
		block.put('4', 6);
		int[][][] moveBlock = new int[7][][];
		moveBlock[0] = new int[][] {{0,2},{}, {2,0},{}};
		moveBlock[1] = new int[][] {{}, {1,3},{}, {3,1}};
		moveBlock[2] = new int[][] {{0,2},{1,3}, {2,0}, {3,1}};
		moveBlock[3] = new int[][] {{0,1},{1,0},{} ,{}};
		moveBlock[4] = new int[][] {{}, {1,2}, {2,1}, {}};
		moveBlock[5] = new int[][] {{}, {}, {2,3}, {3,2}};
		moveBlock[6] = new int[][] {{0,3}, {}, {}, {3,0}};
		
		int mx = 0, my = 0, zx = 0, zy = 0;
		pipe = new char[N][M];
		visited = new int[N][M];
		
		for(int i = 0; i<N;i++) {
			String s = br.readLine();
			Arrays.fill(visited[i], -1);
			for(int j = 0; j<M;j++) {
				pipe[i][j] = s.charAt(j);
				if(pipe[i][j] == 'M') {
					mx = i; my = j;
				} else if(pipe[i][j] == 'Z') {
					zx = i; zy = j;
				}
			}
		}
		
		LinkedList<int[]> mList = new LinkedList<>();
		for(int dir = 0; dir<4;dir++) {
			int nx = mx+dx[dir];
			int ny = my+dy[dir];
			if(nx<0|| nx>=N||ny<0||ny>=M) continue;
			if(pipe[nx][ny] == '.') continue;
			visited[mx][my] = (dir + 2) % 4;
		}
 		mList.add(new int[] {mx, my});

 		int nmx = 0, nmy = 0, cmx = 0, cmy = 0;
		while(!mList.isEmpty()) {
			int[] cur = mList.poll();
			cmx = cur[0]; cmy = cur[1];
			int inDir = (visited[cur[0]][cur[1]] + 2) % 4;	// 다음 거 들어가는 방향
			nmx = cur[0]+dx[inDir];
			nmy = cur[1]+dy[inDir];
			if(!block.containsKey(pipe[nmx][nmy])) break;
			int index = block.get(pipe[nmx][nmy]);
			visited[nmx][nmy] = moveBlock[index][inDir][1];
			mList.add(new int[] {nmx,nmy});
			
		}
	//	System.out.println("x : " + nmx +", y : " + nmy);
		LinkedList<int[]> zList = new LinkedList<>();
		for(int dir = 0; dir<4;dir++) {
			int nx = zx+dx[dir];
			int ny = zy+dy[dir];
			if(nx<0|| nx>=N||ny<0||ny>=M) continue;
			if(pipe[nx][ny] == '.') continue;
			visited[zx][zy] =(dir + 2) % 4;
			break;
		}
		zList.add(new int[] {zx, zy});

 		int nzx = 0, nzy = 0, czx = 0, czy = 0;
		while(!zList.isEmpty()) {
			int[] cur = zList.poll();
			czx = cur[0]; czy = cur[1];
			int inDir = (visited[cur[0]][cur[1]] + 2) % 4;	// 다음 거 들어가는 방향
			nzx = cur[0]+dx[inDir];
			nzy = cur[1]+dy[inDir];
			if(!block.containsKey(pipe[nzx][nzy])) break;
			int index = block.get(pipe[nzx][nzy]);
			visited[nzx][nzy] = moveBlock[index][inDir][1];
			zList.add(new int[] {nzx,nzy});
		}
//		System.out.println("x : " + nzx +", y : " + nzy);
//		System.out.println("cmx : " + cmx + ", cmy : " + cmy + ", visited[cmx][cmy] : " + visited[cmx][cmy]);
//		System.out.println("czx : " + czx + ", czy : " + czy + ", visited[czx][czy] : " + visited[czx][czy]);
		char blindBlock = '+';
		if(cmy == czy) blindBlock = '|';
		else if(cmx == czx) blindBlock = '-';
		else {
			int onex = 0, oney = 0, twox = 0, twoy = 0;
			if(cmx > czx) {
				onex = czx; twox = cmx;
				oney = czy; twoy = cmy;
			} else {
				onex = cmx; twox = czx;
				oney = cmy; twoy = czy;
			}
			int oneDir = visited[onex][oney];
			int twoDir = visited[twox][twoy];
			if(oney < twoy) {
				if((oneDir == 1 && twoDir == 2) || (oneDir == 2 && twoDir == 1)) blindBlock='4';
				else blindBlock = '2';
			} else {
				if((oneDir == 1 && twoDir == 0) || (oneDir == 0 && twoDir == 1)) blindBlock='3';
				else blindBlock = '1';
			}
		}
		System.out.println((nzx+1) + " " + (nzy+1) + " " + blindBlock);
	}
}
