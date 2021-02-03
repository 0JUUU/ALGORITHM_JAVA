import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의_배틀필드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int x = 0, y = 0, dir = 0;
			char[][] field = new char[H][W];
			for (int i = 0; i < H; i++) {
				s = br.readLine();
				for (int j = 0; j < W; j++) {
					field[i][j] = s.charAt(j);
					if (field[i][j] == '^') {
						x = i;
						y = j;
						dir = 0;
					} else if (field[i][j] == 'v') {
						x = i;
						y = j;
						dir = 1;
					} else if (field[i][j] == '<') {
						x = i;
						y = j;
						dir = 2;
					} else if (field[i][j] == '>') {
						x = i;
						y = j;
						dir = 3;
					}
				}
			}

			int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
			int[] dy = { 0, 0, -1, 1 };
			int N = Integer.parseInt(br.readLine());
			s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'S') {
					if (dir == 0) { // 위

						for (int check = x - 1; check >= 0; check--) {
							if (field[check][y] == '#')
								break;
							if (field[check][y] == '*') {
								field[check][y] = '.';
								break;
							}
						}

					} else if (dir == 1) { // 아래
						for (int check = x + 1; check < H; check++) {
							if (field[check][y] == '#')
								break;
							if (field[check][y] == '*') {
								field[check][y] = '.';
								break;
							}
						}
					} else if (dir == 2) { // 왼
						for (int check = y - 1; check >= 0; check--) {
							if (field[x][check] == '#')
								break;
							if (field[x][check] == '*') {
								field[x][check] = '.';
								break;
							}
						}
					} else if (dir == 3) { // 오
						for (int check = y + 1; check < W; check++) {
							if (field[x][check] == '#')
								break;
							if (field[x][check] == '*') {
								field[x][check] = '.';
								break;
							}
						}
					}
				} else if (s.charAt(i) == 'U') {
					dir = 0;
					field[x][y] = '^';
					if (x + dx[dir] < 0)
						continue;
					if (field[x + dx[dir]][y] != '-' && field[x + dx[dir]][y] != '#' && field[x + dx[dir]][y] != '*') {
						field[x][y] = '.';
						x = x + dx[dir];
						field[x][y] = '^';
					}

				} else if (s.charAt(i) == 'D') {
					dir = 1;
					field[x][y] = 'v';
					if (x + dx[dir] >= H)
						continue;
					if (field[x + dx[dir]][y] != '-' && field[x + dx[dir]][y] != '#' && field[x + dx[dir]][y] != '*') {
						field[x][y] = '.';
						x = x + dx[dir];
						field[x][y] = 'v';
					}

				} else if (s.charAt(i) == 'L') {
					dir = 2;
					field[x][y] = '<';
					if (y + dy[dir] < 0)
						continue;
					if (field[x][y + dy[dir]] != '-' && field[x][y + dy[dir]] != '#' && field[x][y + dy[dir]] != '*') {
						field[x][y] = '.';
						y = y + dy[dir];
						field[x][y] = '<';
					}

				} else if (s.charAt(i) == 'R') {
					dir = 3;
					field[x][y] = '>';
					if (y + dy[dir] >= W)
						continue;
					if (field[x][y + dy[dir]] != '-' && field[x][y + dy[dir]] != '#' && field[x][y + dy[dir]] != '*') {
						field[x][y] = '.';
						y = y + dy[dir];
						field[x][y] = '>';
					}
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field[i].length; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}
	}
}
