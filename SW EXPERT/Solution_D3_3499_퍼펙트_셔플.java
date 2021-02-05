import java.util.*;
import java.io.*;

/**
 * SWEA 3499. 퍼펙트 셔플
 * : 1. 큐 2개를 이용해서 풀이 (0)
 * : 2. 배열 인덱스값을 이용해서 풀이
 * @author 0JUUU
 *
 */
public class Solution_D3_3499_퍼펙트_셔플 {
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean isEven = N % 2 == 0? true : false;
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] s = new String[N];
			Queue<String> first = new LinkedList<>();
			Queue<String> second = new LinkedList<>();
			for(int i = 0;i<N;i++) {
				s[i] = st.nextToken();	// 문자열 입력값 저장
				if(i == N/2) {
					if(isEven) {
						second.offer(s[i]);
					} else {
						first.offer(s[i]);
					}
					continue;
				} else {
					if(i < N/2) first.offer(s[i]);
					else second.offer(s[i]);
				}	
			}
			
			sb.append("#").append(tc);
			while(!first.isEmpty() && !second.isEmpty()) {
				sb.append(" ").append(first.poll()); sb.append(" ").append(second.poll());
			}
			if(first.isEmpty() && second.isEmpty()) sb.append("\n");
			else sb.append(" ").append(first.poll()).append("\n");
		}
		System.out.println(sb);
	}
}
