import java.util.*;
import java.io.*;
/**
 * BOJ 2343 기타 레슨
 * 2021.06.23
 * : TLE - 조합
 * @author 0JUUU
 *
 */
public class Main_BOJ_2343_기타_레슨 {

	static int N, M, minSize;
	static int[] number, index;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[N];
		index = new int[M];
		index[0] = 0;
		minSize = Integer.MAX_VALUE;
		int maxNumber = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			number[i] = Integer.parseInt(st.nextToken());
			maxNumber = number[i] > maxNumber ? number[i] : maxNumber;
		}
		
		if(N == M) System.out.println(maxNumber);
		else {
			// 조합
			comb(1, 1);
			System.out.println(minSize);
		}
	}
	private static void comb(int start, int cnt) {
		if(cnt == M) {
			int maxSize = 0;
			for(int i = 0; i<M-1;i++) {
				int sum = 0;
				for(int j = index[i]; j < index[i+1];j++) {
					sum += number[j];
				}
				maxSize = sum > maxSize ? sum : maxSize;
			}
			int sum = 0;
			for(int i = index[M-1]; i< N;i++) {
				sum += number[i];
			}
			maxSize = sum > maxSize ? sum : maxSize;
			
			minSize = minSize> maxSize ? maxSize : minSize;
			return;
		}
		
		for(int i = start; i<N;i++) {
			index[cnt] = i;
			comb(i+1, cnt+1);
		}
		
	}
}
