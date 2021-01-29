import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1018. 체스판 다시 칠하기 2021.01.29 SSAFY 스터디
 * 
 * @author 0JUUU
 *
 */
public class RecolorChess {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min = 2501;

		char[][] board = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j); // 저장
			}
		}
		
		int count = 0;
		if (N == 8 && M == 8) {
			// 1. 왼쪽 맨 위 : W
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 'B') {
						if (i % 2 == 0 && j % 2 == 0)
							count++;
						else if (i % 2 == 1 && j % 2 == 1)
							count++;
					} else {
						if (i % 2 == 0 && j % 2 == 1)
							count++;
						else if (i % 2 == 1 && j % 2 == 0)
							count++;
					}
				}
			}
			min = count > 64 - count ? 64 - count : count;
		} // if (N 과 M이 모두 8일때)

		else {
			int addN = N - 8;
			int addM = M - 8;
			for (int n = 0; n <= addN; n++) {
				for (int m = 0; m <= addM; m++) {
					// 1. 왼쪽 맨 위 : W
					count = 0;
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if (board[i + n][j + m] == 'B') {
								if ((i + n) % 2 == 0 && (j + m) % 2 == 0)
									count++;
								else if ((i + n) % 2 == 1 && (j + m) % 2 == 1)
									count++;
							} else {
								if ((i + n) % 2 == 0 && (j + m) % 2 == 1)
									count++;
								else if ((i + n) % 2 == 1 && (j + m) % 2 == 0)
									count++;
							}
						}
					}
					count = count > 64 - count ? 64 - count : count;
					if (min > count) {
						min = count;
					}
				}
			}
		} // else (N 또는 M이 8이 아닐 때)

		System.out.println(min);
	}// main
}
