import java.util.*;
import java.io.*;

public class Main_BOJ_11000_강의실_배정 {

	static class Class implements Comparable<Class>{
		int start;
		int end;
		Class(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Class o) {
			int gap = this.start - o.start;
			return gap == 0 ? (this.end - o.end) : gap;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		Class[] room = new Class[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			room[i] = new Class(start, end);
		}
		
		Arrays.sort(room);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(room[0].end);
		
		for(int i = 1; i < N; i++) {
			if(pq.peek() <= room[i].start) {
				pq.poll();
			}
			
			pq.add(room[i].end);
		}
		
		System.out.println(pq.size());
	}
}
