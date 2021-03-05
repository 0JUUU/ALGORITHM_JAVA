import java.util.*;
import java.io.*;

/**
 * BOJ 1202 보석 도둑
 * 2021.03.05
 * @author 0JUUU
 *
 */
public class Main_BOJ_1202_보석_도둑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long max = 0;
		ArrayList<int[]> jewelry = new ArrayList<>();
		     
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewelry.add(new int[] {m,v});
		}
		jewelry.sort((j1, j2) -> j1[0] - j2[0]);
		
		Bag[] eachBag = new Bag[M];
		for(int i = 0; i<M;i++) {
			int c = Integer.parseInt(br.readLine());
			eachBag[i] = new Bag();
			eachBag[i].maxWeight = c;
		}
		
		PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());
		Arrays.sort(eachBag);
		int index = 0;
		for(int i = 0; i<M;i++) {
			for(int j = index; j<jewelry.size();j++) {
				if(jewelry.get(j)[0] <= eachBag[i].maxWeight) {
					list.add(jewelry.get(j)[1]);
					index = j+1;
				} else {
					index = j;
					break;
				}
			}
			if(!list.isEmpty()) {
				int del = list.poll();
				//System.out.println(del);
				max += del;
			}
		}
		System.out.println(max);
	}
}

class Bag implements Comparable<Bag>{
	int maxWeight;
	
	public Bag() {
		super();
	}

	@Override
	public int compareTo(Bag o) {
		return this.maxWeight - o.maxWeight;
	}
}