import java.util.*;

import java.io.*;

/**
 * 정올 1828 냉장고
 * 2021.02.16
 * @author 0JUUU
 *
 */
public class Main_정올_1828_냉장고 {

	static class Refri implements Comparable<Refri>{
		public int min;
		public int max;
		
		public Refri(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "Refri [min=" + min + ", max=" + max + "]";
		}

		@Override
		public int compareTo(Refri o) {
			int diff = Integer.compare(this.max, o.max);	
			return diff != 0 ? diff : Integer.compare(this.min, o.min);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Refri[] refri = new Refri[N];
	
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int minValue = Integer.parseInt(st.nextToken());
			int maxValue = Integer.parseInt(st.nextToken());
			refri[i] = new Refri(minValue, maxValue);
		}

		int ans = getCount(refri);
		System.out.println(ans);
	}
	
	static int getCount(Refri[] r) {
		int count = 1;
		Arrays.sort(r);
		ArrayList<Refri> list = new ArrayList<>();
		list.add(r[0]);
		for(int i = 1, size = r.length; i<size;i++) {
			if(list.get(list.size() -1).max < r[i].min) {
				list.add(r[i]); count++;
			}
		}
		return count;
	}
}
