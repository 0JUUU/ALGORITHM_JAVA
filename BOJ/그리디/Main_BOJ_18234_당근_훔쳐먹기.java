import java.util.*;
import java.io.*;

public class Main_BOJ_18234_당근_훔쳐먹기 {

	static class Carrot implements Comparable<Carrot>{
		int w;
		int p;
		public Carrot(int w, int p) {
			this.w = w;
			this.p = p;
		}
		
		@Override
		public int compareTo(Carrot o) {
			return (int) (o.p- this.p == 0 ? o.w - this.w : o.p - this.p);
		}

		@Override
		public String toString() {
			return "Carrot [w=" + w + ", p=" + p + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, T;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
	
		Carrot[] carrots = new Carrot[N];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			carrots[i] = new Carrot(w, p);
		}
		
		Arrays.sort(carrots);
		long sum = 0;
		for(int i = 0; i<N;i++) {
			sum += (long)carrots[i].w;
			long add = ((long) carrots[i].p) * (T-1-i);
			sum += add;
		}
		System.out.println(sum);
	}
}
