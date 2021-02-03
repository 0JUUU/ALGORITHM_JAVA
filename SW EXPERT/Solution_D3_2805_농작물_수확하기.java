import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Location {
	public int x;
	public int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution_D3_2805_농작물_수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];			// 농작물 가치 저장할 배열
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = s.charAt(j) - '0';	// char -> int 전환
				}
			}

			int[][] isVisited = new int[N][N];		// 방문 및 깊이? 를 알려주는 배열
			int[] dx = { -1, 1, 0, 0 };				// 델타 배열 ( 상 하 좌 우 )
			int[] dy = { 0, 0, -1, 1 };
			if(N != 1) {
				Queue<Location> q = new LinkedList<>();		// 각 꼭지점을 큐에 넣어줌
				q.add(new Location(0, 0));					// (0, 0)
				isVisited[0][0] = 1;
				farm[0][0] = 0;

				q.add(new Location(0, N - 1));				// (0, N-1)
				isVisited[0][N - 1] = 1;
				farm[0][N - 1] = 0;

				q.add(new Location(N - 1, 0));				// (N-1, 0)
				isVisited[N - 1][0] = 1;
				farm[N - 1][0] = 0;

				q.add(new Location(N - 1, N - 1));			// (N-1, N-1)
				isVisited[N - 1][N - 1] = 1;
				farm[N - 1][N - 1] = 0;

				while (!q.isEmpty()) {
					Location cur = q.poll();
					for (int dir = 0; dir < 4; dir++) {
						int x = cur.x + dx[dir];
						int y = cur.y + dy[dir];
						if (x < 0 || x >= N)
							continue;
						if (y < 0 || y >= N)
							continue;
						if(isVisited[x][y] != 0) continue;
						isVisited[x][y] = isVisited[cur.x][cur.y] + 1;
						if(isVisited[x][y] == N/2 + 1) {
							break;
						}
						farm[x][y] = 0;
						q.add(new Location(x,y));
					}
				}
			}
			
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					answer += farm[i][j];
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
