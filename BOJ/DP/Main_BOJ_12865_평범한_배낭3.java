import java.util.*;
import java.io.*;

/**
 * BOJ 12865 평범한 배낭
 * 2021.06.04
 * : DP로 접근
 * @author 0JUUU
 *
 */
public class Main_BOJ_12865_평범한_배낭3 {
	static class Thing implements Comparable<Thing> {
		int w,v;

		public Thing(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Thing [w=" + w + ", v=" + v + "]";
		}

		@Override
		public int compareTo(Thing o) {
			int gap = this.w - o.w;
			return gap != 0 ? gap : o.v-this.v;
		}	
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N][K+1];
		Thing[] things = new Thing[N];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			things[i] = new Thing(w,v);
		}
		
		Arrays.sort(things);
		
		// dp 이용
		for(int i = 1; i<=K;i++) {
			if(things[0].w > i) continue;
			dp[0][i] = things[0].v;	// 초기화
		}
		
		for(int i = 1; i<N;i++) {
			for(int j = 1; j<=K;j++) {
				if(dp[i-1][j] == 0) continue;
				if(j < things[i].w) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				int now = things[i].v + dp[i-1][j-things[i].w];
				int before = dp[i-1][j];
				dp[i][j] = now > before ? now : before;
			}
		}
		System.out.println(dp[N-1][K]);
	}
}
