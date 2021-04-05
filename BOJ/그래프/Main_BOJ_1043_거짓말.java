import java.util.*;
import java.io.*;

/**
 * BOJ 1043 거짓말
 * 2021.04.05
 * @author 0JUUU
 *
 */
public class Main_BOJ_1043_거짓말 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken());
		boolean[] known = new boolean[N+1];
		Deque<Integer> q = new LinkedList<Integer>();
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			known[num] = true;
			q.add(num);
		}
		
		ArrayList<Integer>[] info = new ArrayList[M+1];
		for(int i = 0; i<=M;i++) {
			info[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int party = Integer.parseInt(st.nextToken());
			for(int j = 0; j<party;j++) {
				int person = Integer.parseInt(st.nextToken());
				info[i].add(person);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.pollFirst();
			for(int i = 0; i<M;i++) {
				if(info[i].contains(cur)) {
					for(int j = 0, size = info[i].size(); j<size;j++) {
						int next = info[i].get(j);
						if(known[next]) continue;
						known[next] = true;
						q.add(next);
					}
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i<M;i++) {
			boolean availLie = true;
			for(int j = 0, size = info[i].size();j<size;j++) {
				if(known[info[i].get(j)]) {
					availLie = false;
					break;
				}
			}
			if(availLie) max++;
		}
		
		System.out.println(max);
	}
}
