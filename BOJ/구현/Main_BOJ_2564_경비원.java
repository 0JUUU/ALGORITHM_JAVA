import java.util.*;
import java.io.*;

/**
 * BOJ 2564 경비원
 * 
 * @author user
 *
 */
public class Main_BOJ_2564_경비원 {
	static class Location {
		int dir;
		int distance;
		int sub;

		public Location(int dir, int distance, int N) {
			super();
			this.dir = dir;
			this.distance = distance;
			sub = N - this.distance;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int store = Integer.parseInt(br.readLine());
		Location[] stores = new Location[store+1]; 
		for(int i = 0; i<=store;i++) {
			st = new StringTokenizer(br.readLine());
			int dir= Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			if(dir == 1 || dir == 2) {
				stores[i] = new Location(dir, dist, N);
			} else {
				stores[i] = new Location(dir, dist, M);
			}	
		}
		int sum = 0;
		Location x = stores[store];
		for(int i = 0; i<store;i++) {
			Location cur = stores[i];
			if(x.dir == cur.dir) {
				sum += Math.abs(cur.distance - x.distance);
			} else if((x.dir+1)/2 == (cur.dir+1)/2) {	// 마주보는 방향
				int tmp = 0;
				int a = x.distance + cur.distance;		
				int b = x.sub + cur.sub;
				if(a > b) {
					if((x.dir+1)/2 == 1) sum += b + M;
					else sum += b + N;
				} else {
					if((x.dir+1)/2 == 1) sum += a + M;
					else sum += a + N;
				}
			} else {		// 사이드 방향
				if(x.dir % 2 == 0) {
					if(cur.dir % 2 == 0) {
						sum += x.sub + cur.sub;
					} else {
						sum += x.distance + cur.sub;
					}
				} else {
					if(cur.dir % 2 == 0) {
						sum += x.sub + cur.distance;
					} else {
						sum += x.distance + cur.distance;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
