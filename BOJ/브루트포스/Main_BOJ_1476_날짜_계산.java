import java.util.*;
import java.io.*;

/**
 * BOJ 1476. 날짜 계산
 * 2021.02.09
 * 코딩방범대 브루트포스
 * @author 0JUUU
 *
 */
public class Main_BOJ_1476_날짜_계산 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int year = 1;
		while(true) {
			E = E>=15? 0 : E;
			S = S>=28? 0 : S;
			M = M>=19? 0 : M;
			if(year % 15 == E && year % 28 == S && year % 19 == M) break;
			year++;
		}
//		while(year % 15 != E || year % 28 != S || year % 19 != M) {
//			year++;
//		}
		System.out.println(year);
	}
}
