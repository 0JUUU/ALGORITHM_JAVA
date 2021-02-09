import java.util.*;
import java.io.*;

/**
 * BOJ 1913 요세푸스 문제
 * 2021.02.09
 * : deque를 이용한 풀이
 * @author 0JUUU
 *
 */
public class Main_BOJ_1913_요세푸스_문제 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i = 1; i<=N;i++) {
			deque.offer(i);
		}
		int cnt = 0;
		while(!deque.isEmpty()) {
			cnt++;
			deque.offer(deque.pollFirst());
			if(cnt == K) {
				sb.append(deque.pollLast() + ", ");
				cnt = 0;
			}
		}
		sb.setLength(sb.length()-2);
		sb.insert(0,"<"); sb.append(">\n");
		System.out.print(sb);
	}
}
