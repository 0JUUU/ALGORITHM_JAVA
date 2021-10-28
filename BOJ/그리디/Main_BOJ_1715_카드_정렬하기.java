import java.util.*;
import java.io.*;

/**
 * BOJ 1715 카드 정렬하기
 * 2021.10.28
 * : 그리디 & 우선순위 큐
 * @author 0JUUU
 *
 */
public class Main_BOJ_1715_카드_정렬하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i = 0; i<N; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		if(pq.size() == 1) System.out.println(0);
		else if(pq.size() == 2) {
			long a = pq.poll();
			long b = pq.poll();
			System.out.println(a+b);
		} else {
			long sum = 0;
			while(pq.size() != 1) {
				long a = pq.poll();
				long b = pq.poll();
				long compare = a+b;
				sum += (compare);
				pq.add(compare);
			}
			System.out.println(sum);
		}
		
		
	}
}
