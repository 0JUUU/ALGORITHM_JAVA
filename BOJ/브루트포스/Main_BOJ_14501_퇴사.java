import java.util.*;
import java.io.*;

/**
 * BOJ 14501 퇴사
 * 2021.08.02
 * : 1. 브루트포스로 풀었음
 * @author 0JUUU
 *
 */
public class Main_BOJ_14501_퇴사 {

	static int N;
	static int[][] days;
	static boolean[] isUsed;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		days = new int[N+1][2];
		StringTokenizer st;
		for(int i = 1; i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int take = Integer.parseInt(st.nextToken());
			int pay = Integer.parseInt(st.nextToken());
			days[i][0] = take;
			days[i][1] = pay;
		}
		
		makeSubSet(1, 0);
		System.out.println(max);
	}
	private static void makeSubSet(int day, int sum) {
		if(day > N) {
			max = sum > max ? sum : max;
			return;
		}
		
		// 현재 day 안했을 때
		makeSubSet(day+1, sum);
		
		// 현재 day 했을 때
		if(day + days[day][0] - 1 <= N) {
			makeSubSet(day + days[day][0] , sum + days[day][1]);
		}
		
	}
	
}
