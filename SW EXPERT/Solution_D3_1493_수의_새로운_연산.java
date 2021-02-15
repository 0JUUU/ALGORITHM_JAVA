import java.util.*;
import java.io.*;

/**
 * SWEA 1493 수의 새로운 연산
 * 2021.02.15
 * @author 0JUUU
 *
 */
public class Solution_D3_1493_수의_새로운_연산 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int x1, y1, x2, y2, nx, ny, ans;
			// 1. &() 연산
			int n = 2;	// (좌표의 합)
			while(n * (n-1) / 2 < p) n++;
			
			if(n * (n-1) / 2 == p) {
				x1 = n-1; y1 = 1;
			} else {
				int gap = n*(n-1) / 2 - p;
				x1 = (n-1) - gap;
				y1 = n - x1;
			}
			n = 2;	// (좌표의 합)
			while(n * (n-1) / 2 < q) n++;
			
			if(n * (n-1) / 2 == q) {
				x2 = n-1; y2 = 1;
			} else {
				int gap = n*(n-1) / 2 - q;
				x2 = (n-1) - gap;
				y2 = n - x2;
			}
			// 2. #(x,y)
			nx = x1 + x2; ny = y1 + y2;
			
			ans = (nx + ny) * (nx + ny -1) /2 - (ny -1);
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}
