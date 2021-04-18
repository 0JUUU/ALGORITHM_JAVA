import java.util.*;
import java.io.*;

/**
 * JUNGOL 2577 회전 초밥(고) 2021.04.15
 * 
 * @author 0JUUU
 *
 */

public class Main_JUNGOL_2577_회전_초밥 {
	static int N, d, k, c;
	static int[] chobab;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int countSort = 0;
		int[] sort = new int[d + 1];
		boolean isCoupon = false;
		chobab = new int[N + k];
		for (int i = 0; i < N; i++) {
			chobab[i] = Integer.parseInt(br.readLine());
		}

		System.arraycopy(chobab, 0, chobab, N, k - 1);
		
		int max = 0;
		int count = 0;
		sort = new int[d + 1];
		for (int i = 0; i < k; i++) {
			if (sort[chobab[i]]++ == 0) {
				count++;
			} 
		}

		for (int i = 1; i < N; i++) {
			if (sort[chobab[i + k - 1]]++ == 0) {
				count++;
			} 

			if (--sort[chobab[i - 1]] < 1)
				count--;

			int temp = count;
			if (sort[c] == 0)
				temp++;

			max = temp > max ? temp : max;
		}

		System.out.println(max);

	}
}
