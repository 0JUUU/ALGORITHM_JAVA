import java.util.*;
import java.io.*;

/**
 * BOJ 20444 색종이와 가위
 * 2021.10.25
 * 수학 => 996 ms로 해결
 * 더 빨리 할 방법 없는지 확인해볼 것
 * @author 0JUUU
 *
 */
public class Main_BOJ_20444_색종이와_가위 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		for(long i = 0, half = n/2; i<=half; i++) {
			long opp = n-i;
			if((i+1)*(opp+1) == k) {
				System.out.print("YES");
				return;
			}
		}
		System.out.print("NO");
	}
}
