import java.util.*;
import java.io.*;

/**
 * BOJ 2961 도영이가 만든 맛있는 음식
 * 2021.02.15
 * : 1. flag - 비트마스크를 이용한 기법 
 * : 2. isSelected를 이용한 기법  V
 * @author 0JUUU
 *
 */
public class Main_BOJ_2961_도영이가_만든_맛있는_음식 {
	static long[][] favor;
	static long min;
	static int N;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		favor = new long[N][2];
		min = Long.MAX_VALUE;
		isSelected = new boolean[N];
		for(int i = 0; i<N;i++) {	// 재료의 맛 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			favor[i][0] = Long.parseLong(st.nextToken());	// 신 맛
			favor[i][1] = Long.parseLong(st.nextToken());	// 쓴 맛
		}
		
		subset(0);
		System.out.println(min);
	}
	
	static void subset(int cnt) {
		if(cnt == N) {
			long mulSour = 1, sumBitter = 0;
			int totalCnt = 0;
			for(int i = 0; i<N;i++) {
				if(isSelected[i]) totalCnt++;
			}
			
			if(totalCnt == 0) return;
			for(int i = 0; i<N;i++) {
				if(isSelected[i]) {
					mulSour *= favor[i][0];
					sumBitter += favor[i][1];
				}
			}
			min = min > Math.abs(mulSour - sumBitter) ?  Math.abs(mulSour - sumBitter) : min;
			return;
		}
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
	}
}
