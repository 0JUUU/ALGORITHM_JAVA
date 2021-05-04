import java.util.*;
import java.io.*;

/**
 * BOJ 2846 오르막길
 * 2021.05.03
 * @author 0JUUU
 *
 */
public class Main_BOJ_2846_오르막길 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		int sum = 0, tmp = 0, max = 0;
		for(int i = 0; i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if(i == 0) {
				tmp = num[0];
			} else {
				if(tmp < num[i]) {
					sum += (num[i] - num[i-1]);
				} else {
					if(sum != 0) {
						max = max < sum ? sum : max;
					}
					sum = 0;
				}
				tmp = num[i];
			}
		}
		
		if(sum != 0) max = max < sum ? sum : max;
		System.out.println(max);
	} 
}
