import java.util.*;
import java.io.*;

/***
 * BOJ 16922 로마 숫자 만들기
 * 2021.02.24
 * : 1. 중복 가능한 수열을 이용하여 풂
 * @author 0JUUU
 *
 */
public class Main_BOJ_16922_로마_숫자_만들기 {
	static int roma[] = {1,5,10,50};
	static int N, count;
	static int[] res;
	static int[] num = new int[10000];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		res = new int[N];
		makeCombination(0,0);
		System.out.println(count);
	}
	
	static void makeCombination(int cnt, int start) {
		if(cnt == N) {
			int sum = 0;
			for(int i = 0; i<N;i++) {
				sum += res[i];
			}
			if(num[sum] == 0) {
				count++;
				num[sum] = 1;
			}
 			return;
		}
		for(int i = start; i<4;i++) {
			res[cnt] = roma[i];
			makeCombination(cnt+1, i);
		}
	}
}
