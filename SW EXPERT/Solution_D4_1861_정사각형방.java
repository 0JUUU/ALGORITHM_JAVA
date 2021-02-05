import java.util.*;
import java.io.*;

/**
 * SWEA D4 1861. 정사각형방
 * : 2021.02.05
 * : * 처음에는 DFS?로 뻗어나야가하나 생각했음 --> 수가 중복되지않는다는 성질을 이용하면 괜찮을 것이라고 생각
 * : 1. 내가 나아갈 수 있는 방법 - '나'의 상하좌우에 나보다 1 큰 수가 존재해야함
 * : 2. 나보다 1 큰 수가 주위에 없으면 나는 무조건 '나'에서 머물러야하므로 1값이 됨
 * : 3. 제일 큰 값은 무조건 1이 될 수 밖에 없음! 왜냐? 나보다 큰 애는 없으니까
 * : 4. 큰 값에서부터 작은 값까지 줄여나가며 내가 나보다 1 큰 수와 이어져있는지 확인
 * : 5. 내가 나보다 1 큰애랑 이어져있다면, 나는 1 큰 애보다 한번 더 이동 가능해지는 것 
 * @author 0JUUU
 */

public class Solution_D4_1861_정사각형방 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<= T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] room = new int[N][N];
			boolean[] isNear = new boolean[N*N+1];

			for(int i = 0; i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N;j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] dx = {1,-1,0,0};	 // 하상좌우
			int[] dy = {0,0,-1,1};
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<N;j++) {
					for(int dir = 0; dir<4;dir++) {						// 현재 i, j 좌표에 근접한 좌표 중 해당 값보다 1 작은 값이 있다면 마킹처리
						int x= i + dx[dir];
						int y = j + dy[dir];
						if(x <0 || x>=N) continue;
						if(y<0 || y>=N) continue;
						if(room[x][y] != room[i][j] -1) continue;
						else {
							isNear[room[x][y]] = true;
							break;
						}
					}
				}
			}
			int[] move = new int[N*N+1];
			int max = 0; int number = 0;
			for(int i  = N*N; i >0 ;i--) {
				if(!isNear[i]) move[i] = 1;
				else move[i] = move[i+1] + 1;
				
				if(max <= move[i]) {
					max = move[i];
					number = i;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(number).append(" ").append(max).append("\n");
		} // for-테케
		System.out.println(sb);
	} //main
}
