import java.util.*;
import java.io.*;

/**
 * BOJ 2239 스도쿠 2021.04.16
 * 
 * @author 0JUUU
 *
 */

public class Main_BOJ_2239_스도쿠 {
	static int[][] tmp, sudoku; // 하다 만 스도쿠 퍼즐
	static LinkedList<Integer>[][] list = new LinkedList[9][9];
	static int[] count = new int[10];
	static boolean[][][] isSelected = new boolean[10][9][9];
	static boolean[][] sectionNum = new boolean[9][10];
	static class Location {
		int startX, startY, endX, endY;

		public Location(int startX, int startY, int endX, int endY) {
			super();
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
		}

	}

	static Location[] loc = new Location[9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		sudoku = new int[9][9];
		// 구역
		loc[0] = new Location(0, 0, 2, 2);
		loc[1] = new Location(0, 3, 2, 5);
		loc[2] = new Location(0, 6, 2, 8);
		loc[3] = new Location(3, 0, 5, 2);
		loc[4] = new Location(3, 3, 5, 5);
		loc[5] = new Location(3, 6, 5, 8);
		loc[6] = new Location(6, 0, 8, 2);
		loc[7] = new Location(6, 3, 8, 5);
		loc[8] = new Location(6, 6, 8, 8);

		for (int i = 0; i < 9; i++) {
			s = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = s.charAt(j) - '0';
				if (sudoku[i][j] != 0)
					count[sudoku[i][j]]++;
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				list[i][j] = new LinkedList<>();
			}
		}
		checkNumLoc();
		addSudoku();
		dfs(0,0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}

	static long min = Long.MAX_VALUE;

	private static void dfs(int i, int j) {
		if (i == 9 && j == 0) {

			System.exit(0);
		}

		if (list[i][j].isEmpty()) {
			if (j == 8)
				dfs(i + 1, 0);
			else
				dfs(i, j + 1);
		} else {
			Collections.sort(list[i][j], (a, b) -> {
				return a - b;
			});
			for (int s = 0; s < list[i][j].size(); s++) {
				int num = list[i][j].get(s);
				if(!checkCondition(i, j, num)) continue;
				sudoku[i][j] = num;
				if (j == 8)
					dfs(i + 1, 0);
				else
					dfs(i, j + 1);
			}
		}
	}

	private static boolean checkCondition(int i, int j, int num) {
		if(isSelected[i][j][num])  return false;
	}

	private static boolean checkZero() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0)
					return true;
			}
		}
		return false;
	}

	private static void addSudoku() {
		// 1-9 모든 숫자에 대해 들어갈 수 있는 자리 확인
		for (int n = 1; n <= 9; n++) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (sudoku[i][j] != 0)
						continue;
					if (isSelected[n][i][j])
						continue;
					list[i][j].add(n);
				}
			}
		}
	}

	private static void checkNumLoc() {
		// 어떤 숫자가 어디에 위치할 수 없는지 체크하는 로직
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0)
					continue;
				int location = 9;
				int num = sudoku[i][j];
				// 현재 좌표가 위치해있는 구역 알기
				for (int l = 0; l < 9; l++) {
					if (loc[l].startX <= i && i <= loc[l].endX && loc[l].startY <= j && j <= loc[l].endY) {
						location = l;
						break;
					}

				}

				// 해당 숫자가 위치하는 행과 열에 마크
				for (int k = 0; k < 9; k++) {
					isSelected[num][i][k] = true;
					isSelected[num][k][j] = true;
				}
				int sX = loc[location].startX, sY = loc[location].startY, eX = loc[location].endX,
						eY = loc[location].endY;
				for (int x = sX; x <= eX; x++) {
					for (int y = sY; y <= eY; y++) {
						isSelected[num][x][y] = true;
					}
				}
				sectionNum[location][num] = true;
			} // end for j
		} // end for i
	}

}
