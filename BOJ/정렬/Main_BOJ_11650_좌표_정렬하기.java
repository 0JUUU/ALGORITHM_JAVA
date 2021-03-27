import java.util.*;
import java.io.*;

/**
 * BOJ 11650 좌표 정렬하기
 * 20201.03.27
 * : 1. Comparable 사용
 * @author 0JUUU
 *
 */
public class Main_BOJ_11650_좌표_정렬하기 {
	static class Location implements Comparable<Location> {
		int x; int y;

		public Location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Location o) {
			int gap = Integer.compare(this.x, o.x);
			if(gap == 0) return Integer.compare(this.y, o.y);
			return gap;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N =Integer.parseInt(br.readLine());
		Location[] loc = new Location[N];
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			loc[i] = new Location(x,y);
		}
		
		Arrays.sort(loc);
		for(int i = 0;i<N;i++) {
			sb.append(loc[i].x + " " + loc[i].y + "\n");
		}
		System.out.print(sb);
	}
}
