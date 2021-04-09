import java.util.*;
import java.io.*;

/**
 * BOJ 10800 컬러볼
 * 2021.04.09
 * @author 0JUUU
 *
 */
public class Main_BOJ_10800_컬러볼 {
	static class Ball implements Comparable<Ball>{
		int number;
		int color;
		int size;
		public Ball(int number, int color, int size) {
			super();
			this.number = number;
			this.color = color;
			this.size = size;
		}
		@Override
		public int compareTo(Ball o) {
			return this.size - o.size;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sum = new int[N];
		ArrayList<Ball> list = new ArrayList<>();
		PriorityQueue<Ball> balls = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			balls.add(new Ball(i, color, size));
		}
		sum[balls.peek().number] = 0;
		while(!balls.isEmpty()) {
			Ball cur = balls.poll();
			if(list.isEmpty()) {
				list.add(cur); continue;
			}
			else {
				for(int i = 0; i<list.size();i++) {
					Ball before = list.get(i);
					if(before.color != cur.color) sum[cur.number] += before.size;
				}
			}
			list.add(cur);
		}
		for(int i = 0; i<N;i++) {
			sb.append(sum[i] + "\n");
		}
		System.out.print(sb);
	}
}
