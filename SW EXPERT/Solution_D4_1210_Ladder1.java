import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1 {
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1;tc<=10;tc++) {
			int T = Integer.parseInt(br.readLine());
		
			int[][] ladder = new int[100][100];
			
			int dirY = 0;
			for(int i = 0;i<100;i++) {		// 사다리 저장
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0;j<100;j++) {
					
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0;i<100;i++) {
				if(ladder[99][i] == 2) dirY = i;
			}
			int[] dx = {0,0,-1};
			int[] dy = {1,-1,0};
			
			int dirX = 99;
			boolean[][] isVisited = new boolean[100][100];
			isVisited[dirX][dirY] = true;
			while(dirX != 0) {
				for(int dir = 0;dir<3;dir++) {
					int x = dirX + dx[dir];
					int y = dirY + dy[dir];
					if(x<0 || x>99) continue;
					if(y<0||y>99) continue;
					if(ladder[x][y] == 1 && !isVisited[x][y]) {			// 좌우로 이동시 밑을 내려갈 가능성이 있으므로 x축을 위로 한번 올려줌
						dirX = x; dirY = y;	
						isVisited[x][y] = true;
						break;
					}
				}
			}
			
			System.out.println("#"+T+" "+dirY);
		}
	}
}
