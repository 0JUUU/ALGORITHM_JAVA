import java.util.*;
import java.io.*;

/**
 * BOJ 16917 양념 반 후라이드 반
 * 2021.04.04
 * @author 0JUUU
 *
 */
public class Main_BOJ_16917_양념_반_후라이드_반 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A, B, C, X, Y, money;
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		if(A + B > 2*C) {	// 한마리씩 시키는 것보다 반반 시키는게 이득일 때
			int count = Math.min(X, Y);
			money = count * 2 * C;
			money += (X-count) * A;
			money += (Y-count) * B;
		} else {
			money = A * X;
			money += B * Y;
		}
		
		System.out.println(money);
	}
}
