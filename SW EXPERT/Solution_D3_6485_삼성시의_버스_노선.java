import java.util.*;
import java.io.*;

/**
 * SWEA 6485 삼성시의 버스 노선
 * 2021.02.25
 * @author 0JUUU
 *
 */
public class Solution_D3_6485_삼성시의_버스_노선 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] busStop = new int[5001];
			for(int i = 0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				for(int j = start; j<=end;j++) {
					busStop[j] ++;
				}
			}
			sb.append("#" + tc + " ");
			int P = Integer.parseInt(br.readLine());
			for(int i = 0; i<P;i++) {
				int c = Integer.parseInt(br.readLine());
				sb.append(busStop[c] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
