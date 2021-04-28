import java.util.*;
import java.io.*;

/**
 * BOJ 5557 1학년
 * : TLE ==> 백트래킹
 * @author user
 *
 */
public class Main_BOJ_5557_1학년 {
	static int N;
	static long count;
	static int[] numbers;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		for(int i = 0; i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0, 0);
		System.out.println(count);
	}
	private static void subset(int cnt, int sum) {
		if(sum < 0) return;
		if(sum > 20) return;
		
		if(cnt == N-1) {
			if(numbers[cnt] == sum) count++;
			return;
		}
		subset(cnt + 1, sum + numbers[cnt]);
		subset(cnt+1, sum-numbers[cnt]);
	}
}
