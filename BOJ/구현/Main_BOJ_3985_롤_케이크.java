import java.util.*;
import java.io.*;

/**
 * BOJ 3985 롤 케이크
 * 2021.02.25
 * @author 0JUUU
 *
 */
public class Main_BOJ_3985_롤_케이크 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int roll[] = new int[L+1];
		int person[] = new int[N+1];
		StringTokenizer st;
		int expect = 0, real = 0, max = 0, m =0;
		for(int i =1; i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			person[i] = end - start + 1;
			if(max < person[i]) {
				max  = person[i];
				expect = i;
			}
			
			int count = 0;
			for(int r = start; r<=end;r++) {
				if(roll[r] != 0) continue; 
				roll[r] = i; count++;
			}
			person[i] = count;
			if(m < person[i]) {
				m = person[i];
				real = i;
			}
		}
		System.out.println(expect + "\n" + real);
	}
}
