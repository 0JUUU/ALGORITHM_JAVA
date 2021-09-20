import java.util.*;
import java.io.*;

/**
 * BOJ 5347 LCM
 * 2021.09.20
 * 흔한 gcd / lcm 구하는 방법
 * @author 0JUUU
 *
 */
public class Main_BOJ_5347_LCM {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(a < b) {
				long tmp = b;
				b = a;
				a = tmp;
			}
			
			long gcd = a, q = b;
			long r = a % b;
			while(q!=0) {
				r = gcd % q;
				gcd = q;
				q = r;
			}
			sb.append(a * b / gcd +"\n");
		}
		System.out.println(sb);
	}
}
