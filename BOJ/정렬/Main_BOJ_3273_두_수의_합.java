import java.util.*;
import java.io.*;

/**
 * BOJ 3273 두 수의 합
 * 2021.09.24
 * 1. WA => X가 짝수이고 X/2가 있는 경우의 수를 옳다고 체크했음 => (i != X-i) 라는 조건 추가
 * 2. ArrayIndexOutOfBounds => X의 범위를 잘못체크함
 * @author user
 *
 */
public class Main_BOJ_3273_두_수의_합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] num = new boolean[2000001];
		for(int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			num[a] = true;
		}
		
		int sum = 0;
		int x = Integer.parseInt(br.readLine());
		for(int i = 1; i <= x/2; i++) {
			if((i != x-i) && num[i] && num[x-i]) sum++;
		}
		System.out.println(sum);
	}
}
