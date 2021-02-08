import java.util.*;
import java.io.*;

/**
 * SWEA 9229. 한빈이와 Spot Mart 2021.02.08
 * : 2가지 선택을 고려 -> 2중 for문 이용
 * @author 0JUUU
 *
 */
public class Solution_D3_9229_한빈이와_Spot_Mart {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] cookie = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				cookie[n] = Integer.parseInt(st.nextToken());
			}
			int max = Integer.MIN_VALUE;
			Arrays.sort(cookie);
			if (cookie[0] + cookie[1] > M)
				max = -1;
			else if(cookie[N-1] + cookie[N-2] <= M) max = cookie[N-1] + cookie[N-2];
			else {
				for (int i = 0; i < N; i++) {
					for (int j = i+1; j < N; j++) {
						if (cookie[i] + cookie[j] <= M)
							max = max < cookie[i] + cookie[j] ? cookie[i] + cookie[j] : max;
						if (max == M)
							break;
					}
					if (max == M)
						break;
				}
			}
			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.print(sb);
	}
}
