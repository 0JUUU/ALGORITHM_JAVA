import java.util.*;
import java.io.*;

/**
 * BOJ 14916 거스름돈
 * 2021.09.06
 * : DP 이용
 * @author 0JUUU
 *
 */

public class Main_BOJ_14916_거스름돈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[100001];
		Arrays.fill(cnt, -1);
		for(int i = 1; i<=N; i++) {
			if(i < 2 && i < 5) continue;
			else if(i == 2 || i == 5) cnt[i] = 1;
			else if(i < 5) {
				int sub = i - 2;
				if(cnt[sub] == -1) continue;
				cnt[i] = cnt[sub] + 1;
			} else {
				int sub1 = i-2;
				int sub2 = i-5;
				if(cnt[sub1] == -1 && cnt[sub2] == -1) continue;
				else if(cnt[sub1] == -1) {
					cnt[i] = cnt[sub2] + 1;
				} else if(cnt[sub2] == -1) {
					cnt[i] = cnt[sub1] + 1;
				} else {
					int less = sub1 > sub2 ? sub2 : sub1;
					cnt[i] = cnt[less] + 1;
				}
				
			}
		}
		System.out.println(cnt[N]);
	}
}
