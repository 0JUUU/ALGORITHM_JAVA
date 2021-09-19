import java.util.*;
import java.io.*;

/**
 * BOJ 17266 어두운 굴다리
 * 2021.09.19
 * 처음과 끝 값은 0~N과 비교하고 중간은 /2를 해줘야한다. 
 * @author 0JUUU
 *
 */
public class Main_BOJ_17266_어두운_굴다리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int gap = 0;
		int before = 0;
		for(int i = 0; i<M;i++) {
			int now = Integer.parseInt(st.nextToken());
			if(i == 0) {
				gap = now;
			}
			else {
				int tmp = 0;
				if((now - before) % 2 == 0) {
					tmp = (now - before) / 2;
				} else {
					tmp = ((now - before) / 2) + 1;
				}
				gap = gap > tmp ? gap : tmp;
			}
			if(i == M-1) {
				gap = gap > N - now ? gap : N - now;
			}
			before = now;
		} 
		
		System.out.println(gap);
	}
}
