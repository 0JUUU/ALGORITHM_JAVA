import java.util.*;
import java.io.*;

/**
 * BOJ 2847 게임을 만든 동준이
 * 2021.10.21
 * : 뒤에서부터 차근차근 => 그리디
 * @author 0JUUU
 *
 */
public class Main_BOJ_2847_게임을_만든_동준이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] level = new int[N];
		int redux = 0;
		for(int i = N-1; i>=0; i--) {
			level[i] = Integer.parseInt(br.readLine());
		}
		
		int cur = level[0];
		for(int i = 1; i<N; i++) {
			if(cur > level[i]) {
				cur = level[i];
			} else {
				redux += (level[i] - cur) + 1;
				cur -=1;
			}
		}
		
		System.out.println(redux);
	}
}
