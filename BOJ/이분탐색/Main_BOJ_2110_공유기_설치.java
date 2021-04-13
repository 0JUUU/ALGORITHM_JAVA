import java.util.*;
import java.io.*;

/**
 * BOJ 2110 공유기 설치
 * 2021.04.13
 * @author 0JUUU
 *
 */
public class Main_BOJ_2110_공유기_설치 {
	static int N, C;
	static int[] router;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		router = new int[200001]; 
		for(int i = 0; i<N;i++) {
			int loc = Integer.parseInt(br.readLine());
			router[i] = loc;
		}
		
		Arrays.sort(router, 0, N);
		
		int min = 1;
		int max = router[N-1] - router[0];
		while(min + 1 < max) {
			int mid = (min + max) / 2;
			if(isAvail(mid)) {
				min = mid;
			} else {
				max = mid;
			}
		}
		
		System.out.println(min);
	}

	private static boolean isAvail(int dist) {
		int cnt = 1;
		int cur = router[0];
		for(int i = 1; i<N;i++) {
			if(router[i] - cur >= dist) {
				cnt++;
				cur = router[i];
			}
		}
		
		if(cnt >= C) return true;
		else return false;
	}
}
