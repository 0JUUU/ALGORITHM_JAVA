import java.util.*;
import java.io.*;

/***
 * BOJ 1767 프로세서 연결하기
 * :1. 가장자리에 위치한 코어를 제외한 각 코어들의 전선 방향을 바꾸어 모든 경우를 파악
 * @author 0JUUU
 *
 */
public class Solution_1767_프로세서_연결하기 {
	static int[][] maxinos, temp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N;
	static int[][] isUsed;
	static int[] answer;	// answer[0]에 저장된 값보다 count_core가 크면(answer[0]을 count_core로 변경)
							// --> answer[1] 을 count_line과 비교하여 작은 값 저장
	static ArrayList<int[]> core;
	static LinkedList<int[]> selectCore;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			//count_core = 0; count_line = 0;
			answer = new int[2];
			maxinos = new int[N][N];
			temp = new int[N][N]; 
			isUsed = new int[N][N];
			core = new ArrayList<>();
			selectCore = new LinkedList<>();
			for(int i = 0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N;j++) {
					maxinos[i][j] = Integer.parseInt(st.nextToken());
					temp[i][j] = maxinos[i][j];
					if(!(i == 0 || i == N-1 || j == 0 || j == N-1) && maxinos[i][j] == 1 ) {
						core.add(new int[] {i,j});		// 가장자리를 제외한 코어 제외
						isUsed[i][j] = 1;
					} else if(maxinos[i][j] == 1) isUsed[i][j] = 1;
				}
			}
			
			if(core.size() == 1) {
				int[] loc = core.get(0);	// loc[0] : x, loc[1] = y
				answer[1] = Math.min(loc[0], Math.min(loc[1], Math.min(N - loc[0] - 1, N - loc[1] -1)));
			} else {
				answer[1] = Integer.MAX_VALUE;
				setCore(0, 0, 0);
			}
			sb.append("#" + tc + " " + answer[1] + "\n");
		}
		System.out.println(sb);
	}
	private static void setCore(int core_index, int count_core, int count_line) {
		if(core_index == core.size()) {
			if(count_core >= answer[0] && count_core != 0) {
				if(count_core > answer[0]) {
					answer[0] = count_core;
					answer[1] = count_line;
					
				} else {
					answer[1] = answer[1] > count_line ? count_line : answer[1];
				}
			}
//			for(int i = 0; i<N;i++) {	// temp 상태를 초기화
//				for(int j = 0; j<N;j++) {
//					temp[i][j] = maxinos[i][j];
//				}
//			}	
			return;
		}
		int[] cur = core.get(core_index);
		for(int dir = 0; dir<5; dir++) {
			int line = 0;
			boolean isLine = false;
			switch(dir) {
			case 0:	// 0 -> 선택 X
				isLine = true;
				setCore(core_index+1, count_core, count_line);
				break;
			case 1:	// 1 -> 상
				for(int i = cur[0] - 1; i>=0;i--) {
					if(temp[i][cur[1]] == 1) {
						isLine = true;
						break;
					}
				}	
				if(!isLine) {
					for(int i = cur[0] - 1; i>=0; i--) {
						temp[i][cur[1]] = 1;
					}
//					count_core++;
//					count_line += cur[0];
					line = cur[0];
					setCore(core_index+1, count_core+1, count_line + line);
					for(int i = cur[0] - 1; i>=0; i--) {
						temp[i][cur[1]] = 0;
					}
				}
				break;
			case 2:
				for(int i = cur[0] + 1; i<N;i++) {
					if(temp[i][cur[1]] == 1) {
						isLine = true;
						break;
					}
				}	
				if(!isLine) {
					for(int i = cur[0] + 1; i<N;i++) {
						temp[i][cur[1]] = 1;
					}
//					count_core++;
//					count_line += N - cur[0] -1;
					line = N - cur[0] -1;
					setCore(core_index+1, count_core+1, count_line + line);
					for(int i = cur[0] + 1; i<N;i++) {
						temp[i][cur[1]] = 0;
					}
				}
				break;
			case 3:
				for(int j = cur[1] - 1; j>=0;j--) {
					if(temp[cur[0]][j] == 1) {
						isLine = true;
						break;
					}
				}	
				if(!isLine) {
					for(int j = cur[1] - 1; j>=0; j--) {
						temp[cur[0]][j] = 1;
					}
//					count_core++;
//					count_line += cur[1];
					line = cur[1];
					setCore(core_index+1, count_core+1, count_line + line);
					for(int j = cur[1] - 1; j>=0; j--) {
						temp[cur[0]][j] = 0;
					}
				}
				break;
			case 4:
				for(int j = cur[1] + 1; j<N;j++) {
					if(temp[cur[0]][j] == 1) {
						isLine = true;
						break;
					}
				}	
				if(!isLine) {
					for(int j = cur[1] + 1; j<N;j++) {
						temp[cur[0]][j] = 1;
					}
//					count_core++;
//					count_line += N - cur[1] -1;
					line = N - cur[1] - 1;
					setCore(core_index+1, count_core+1, count_line + line);
					for(int j = cur[1] + 1; j<N;j++) {
						temp[cur[0]][j] = 0;
					}
				}
				break;
			}
			
		}
	}
}
