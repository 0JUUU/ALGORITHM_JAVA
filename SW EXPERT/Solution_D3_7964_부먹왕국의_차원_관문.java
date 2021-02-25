import java.util.*;
import java.io.*;

/**
 * SWEA 7964 부먹왕국의 차원 관문
 * 2021.02.25
 * : 연속한 0의 개수를 세어 D값과 비교한다.
 * @author 0JUUU
 *
 */
public class Solution_D3_7964_부먹왕국의_차원_관문 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] city = new int[N];
			int door = 0; int serial = 0;
			
			for(int i = 0 ;i<N;i++) {
				city[i] = Integer.parseInt(st.nextToken());
				if(city[i] == 0) serial++;
				else if(city[i] == 1) serial = 0; 
				if(serial == D) {
					door++;
					serial = 0;
				}
			}
			sb.append("#" + tc + " " + door + "\n");
		}
		
		
		System.out.println(sb);
	}
}
