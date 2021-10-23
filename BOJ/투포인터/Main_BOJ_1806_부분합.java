import java.util.*;
import java.io.*;

/**
 * BOJ 1806 부분합
 * 2021.10.23
 * : 예상 못 한 반례
4 5
1 2 2 3

 * @author 0JUUU
 *
 */
public class Main_BOJ_1806_부분합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if(num[i] >= S) {
				System.out.println(1);
				return;
			}
		}
		
		int start = 0, end = 0, min = Integer.MAX_VALUE, sum = 0;
		while(start != N || end != N) {
			if(end == N) {
				if(sum >= S) {
					int gap = end - start;
					min = min > gap ? gap : min;
				}
				sum -= num[start];
				start++;
				continue;
			}
			if(start == end) {
				sum += num[end];
				end++;
				continue;
			}
			if(sum >= S) {
				int gap = end - start;
				min = min > gap ? gap : min;
				sum -= num[start];
				start++;
			} else {
				sum += num[end];
				end++;
			}	
		}
		
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}
