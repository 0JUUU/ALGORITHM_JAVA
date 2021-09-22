import java.util.*;
import java.io.*;

public class Main_BOJ_20159_동작_그만_밑장_빼기냐 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int half = (n/2) - 1;
		long[] odd = new long[n/2];
		long[] even = new long[n/2];
		for(int i = 0; i < n; i++) {
			if(i == 0) even[i] = Long.parseLong(st.nextToken());
			else if(i == 1) odd[i-1] = Long.parseLong(st.nextToken());
			else {
				if(i % 2 == 0) {
					even[i / 2] = even[(i-2) / 2] + Long.parseLong(st.nextToken());
				} else {
					odd[i / 2] = odd[(i-2) / 2] + Long.parseLong(st.nextToken());
				}
			}
		}
		
		if(half == 0) {
			System.out.println(even[0] > odd[0] ? even[0] : odd[0]);
			return;
		}
		long max = odd[half];
		// 정훈이 턴에 밑장 빼기
		for(int i = 0; i<=half; i++) {
			long sum = even[i] + (odd[half] - odd[i]);
			max = sum > max ? sum : max;
		}
		
		// 상대 턴에 밑장 빼기
		long sum = even[0] + odd[half-1];
		max = sum > max ? sum : max;
		for(int i = 1; i <  half; i++) {
			sum = even[i] + odd[half-1] - odd[i-1];
			max = sum > max ? sum : max;
		}
		System.out.println(max);
	}
}
