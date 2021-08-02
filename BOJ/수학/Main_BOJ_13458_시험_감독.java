import java.util.*;
import java.io.*;

/**
 * BOJ 13458 시험 감독
 * 2021.08.02
 * : Long 변수에 유의! 범위를 잘 살피자!!
 * @author 0JUUU
 *
 */
public class Main_BOJ_13458_시험_감독 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] rooms = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			rooms[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int all = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		int[] superVi = new int[N];
		for(int i = 0; i<N;i++) {
			int cur = rooms[i];
			sum += 1;
			if(cur <= all) continue;
			cur -= all;
			if(cur % sub == 0) {
				sum += cur/sub;
			} else {
				sum += (cur/sub) + 1;
			}
		}
		System.out.println(sum);
	}
}
