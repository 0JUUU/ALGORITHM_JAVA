import java.io.BufferedReader;
import java.io.InputStreamReader;

/** DailyHomework 
 *  Algorithm 02. SWEA 1954
 *  학습 주제 : 알고리즘 풀이
 *  학습 목표 : 아래 문제를 분석하고 적절한 알고리즘을 적용하여 문제를 해결할 수 있다. 
 *  : 나는 4개의 방향을 부여하여 배열 범위에 넘어서거나 이미 값이 존재하는 칸이라면 방향을 바꿔주는 식으로 구현하였다. 
 * @author 0JUUU
 *
 */

public class Solution_D2_1954_달팽이_숫자 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int snail = N*N;
			int[][] arr = new int[N][N];
			int s = 1;
			
			int[] dx = {0,1,0,-1};	//우,하,좌,상
			int[] dy = {1,0,-1,0};
			int i = 0, j = 0;
			arr[i][j] = 1;
			
			if(N != 1) {
				for(int dir = 0; dir<4;) {
					int x = i + dx[dir]; int y = j + dy[dir];
					
					if(x < 0 || x >= N || y <0 || y >= N) {
						if(dir == 3) dir = 0;
						else dir++; continue;
					}
					if(arr[x][y] != 0) {
						if(dir == 3) dir = 0;
						else dir++;
						continue;
					}
					arr[x][y] = ++s;
					i = x; j = y;
					if(s == snail) break;
				}
			}
			
			// 출력
			System.out.print("#"+tc+"\n");
			for(int x = 0;x<N;x++) {
				for(int y = 0;y<N;y++) {
					System.out.print(arr[x][y]+" ");
				}
				System.out.println();
			}
			
		}
	}
}
