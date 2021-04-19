import java.util.*;
import java.io.*;

/**
 * BOJ 14890 경사로
 * 2021.04.19
 * : index 조절에 유의하자!
 * @author 0JUUU
 *
 */
public class Main_BOJ_14890_경사로 {
	static int N, L, count;
	static int[][] map, trans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		trans = new int[N][N];
		
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				trans[j][i] = map[i][j];
			}
		}
		
		for(int i = 0; i<N;i++) {
			if(makeBridge(map[i])) count++;
			if(makeBridge(trans[i])) count++;
		}
		System.out.println(count);
	}
	private static boolean makeBridge(int[] map) {
		int i = 0, tmp = map[0];
		int len = 0;
		while(i < N) {
			if(tmp == map[i]) {
				len++;
				i++;
			} else if(tmp == map[i] - 1) {
				if(len < L) return false;
				len = 1;
				tmp = map[i];
				i++;
			} else if(tmp -1 == map[i]) {
				len = 0;
				for(int j = i; j<N;j++) {
					if(map[i] != map[j]) break;
					if(map[i] == map[j]) len++;
				}
				if(len < L) return false;
				tmp = map[i];
				i += L;
				len = 0;
			} else return false;
		}
		return true;
	}
}
