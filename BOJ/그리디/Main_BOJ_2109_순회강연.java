import java.util.*;
import java.io.*;

/**
 * BOJ 2109 순회강연
 * 2021.09.14
 * p가 큰 것부터 먼저 오게 & p가 같다면 d가 큰 것부터 (뒤부터 선택하면 좋으니까?)
 * @author 0JUUU
 *
 */
public class Main_BOJ_2109_순회강연 {

	static class University implements Comparable<University> {
		int day;
		int money;
		
		University(int day, int money) {
			this.day = day;
			this.money = money;
		}

		@Override
		public int compareTo(University o) {
			int gap = o.money - this.money;
			return gap != 0 ? gap : o.day - this.day;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		LinkedList<University> uniList = new LinkedList<>();
		int sum = 0;
		int[] completeDays = new int[10001];
		for(int i  = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			uniList.add(new University(d, p));
		}
		
		Collections.sort(uniList);
		while(!uniList.isEmpty()) {
			University cur = uniList.poll();
			int day = cur.day;
			int money = cur.money;
			for(int i = day; i >= 1; i--) {
				if(completeDays[i] != 0) continue;
				completeDays[i] = 1;
				sum += money;
				break;
			}
		}
		
		System.out.println(sum);
	}
}
