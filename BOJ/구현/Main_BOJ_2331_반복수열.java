import java.util.*;
import java.io.*;

/**
 * BOJ 2331 반복수열
 * 2021.02.23
 * : 각 수들이 등장하는 횟수를 센 후, 3이 등장하면 반복 수열의 마지막 원소를 돌고 반복 수열의 처음으로 왔다는 의미
 * @author 0JUUU
 *
 */

public class Main_BOJ_2331_반복수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] num = new int[100000000];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		num[A] = 1;
		int max = 0;
		while(true) {
			int tmp  = 0;
			while(A / 10 != 0) {
				tmp += Math.pow(A % 10, P);
				A /= 10;
			}
			tmp += Math.pow(A, P);
	//		System.out.println(tmp);
			num[tmp]++;
			max = max < tmp ? tmp : max;
			if(num[tmp] == 3) break;
			A = tmp;
		}
		
		int count = 0;
		for(int i = 0; i<=max;i++) {
			if(num[i] == 1) count++;
		}
		System.out.println(count);
	}
}
